package cjk.design.music.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.LruCache;

import androidx.annotation.NonNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import cjk.design.music.R;
import cjk.design.music.model.Music;

/**
 * 专辑封面图片加载器
 */
public class CoverLoader {
    public static final int THUMBNAIL_MAX_LENGTH = 500;
    private static final String KEY_NULL = "null";

    private Context context;
    private Map<Type, LruCache<String, Bitmap>> cacheMap;
    private int roundLength = ScreenUtils.getScreenWidth() / 2;
    private Bitmap bitmap_url;

    private enum Type {
        THUMB,
        ROUND,
        BLUR
    }

    public static CoverLoader get() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static CoverLoader instance = new CoverLoader();
    }

    private CoverLoader() {
    }

    public void init(Context context) {
        this.context = context.getApplicationContext();

        // 获取当前进程的可用内存（单位KB）
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        // 缓存大小为当前进程可用内存的1/8
        int cacheSize = maxMemory / 8;
        LruCache<String, Bitmap> thumbCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    return bitmap.getAllocationByteCount() / 1024;
                } else {
                    return bitmap.getByteCount() / 1024;
                }
            }
        };
        LruCache<String, Bitmap> roundCache = new LruCache<>(10);
        LruCache<String, Bitmap> blurCache = new LruCache<>(10);

        cacheMap = new HashMap<>(3);
        cacheMap.put(Type.THUMB, thumbCache);
        cacheMap.put(Type.ROUND, roundCache);
        cacheMap.put(Type.BLUR, blurCache);
    }

    public void setRoundLength(int roundLength) {
        if (this.roundLength != roundLength) {
            this.roundLength = roundLength;
            cacheMap.get(Type.ROUND).evictAll();
        }
    }

    public Bitmap loadThumb(Music music) {
        return loadCover(music, Type.THUMB);
    }

    public Bitmap loadRound(Music music) {
        //System.out.println("音乐封面"+music.getCoverPath());
        //这里bitmap有值
        return loadCover(music, Type.ROUND);

    }

    public Bitmap loadBlur(Music music) {
        return loadCover(music, Type.BLUR);
    }

    private Bitmap loadCover(Music music, Type type) {
        Bitmap bitmap;
        String key = getKey(music);
        //这边cacheMap并没有初始化，LruCache是没有东西的
        LruCache<String, Bitmap> cache = cacheMap.get(type);
        //System.out.println("音乐封面1"+key);
        if (TextUtils.isEmpty(key)) {

            //System.out.println("按道理应该不会进入");
            bitmap = cache.get(KEY_NULL);
            if (bitmap != null) {
                return bitmap;
            }

            bitmap = getDefaultCover(type);
            cache.put(KEY_NULL, bitmap);
            return bitmap;
        }

        bitmap = cache.get(key);
        //这里bitmap为null

        if (bitmap != null) {
            return bitmap;
        }

        //这边是真正的赋值
        bitmap = loadCoverByType(music, type);

        if (bitmap != null) {
            cache.put(key, bitmap);

            return bitmap;
        }

        return loadCover(null, type);
    }

    //根据是本地音乐还是在线音乐给封面赋值不同
    private String getKey(Music music) {
        if (music == null) {
            return null;
        }

        if (music.getType() == Music.Type.LOCAL && music.getAlbumId() > 0) {
            return String.valueOf(music.getAlbumId());
        } else if (music.getType() == Music.Type.ONLINE && !TextUtils.isEmpty(music.getCoverPath())) {
            return music.getCoverPath();
        } else {
            return null;
        }
    }

    private Bitmap getDefaultCover(Type type) {
        switch (type) {
            case ROUND:
                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.play_page_default_cover);
                bitmap = ImageUtils.resizeImage(bitmap, roundLength, roundLength);
                return bitmap;
            case BLUR:
                return BitmapFactory.decodeResource(context.getResources(), R.drawable.play_page_default_bg);
            default:
                return BitmapFactory.decodeResource(context.getResources(), R.drawable.default_cover);
        }
    }


    private Bitmap loadCoverByType(Music music, Type type) {
        Bitmap bitmap;
        if (music.getType() == Music.Type.LOCAL) {
            bitmap = loadCoverFromMediaStore(music.getAlbumId());
        } else {
            //System.out.println("按道理进入这个2");
            bitmap = loadCoverFromFile(music.getCoverPath());
            //System.out.println("第一次bitmap没有转换成功吗"+bitmap);

        }
        switch (type) {
            case ROUND:
                bitmap = ImageUtils.resizeImage(bitmap, roundLength, roundLength);
                return ImageUtils.createCircleImage(bitmap);
            case BLUR:
                return ImageUtils.blur(bitmap);
            default:
                return bitmap;
        }
    }

    /**
     * 从媒体库加载封面<br>
     * 本地音乐
     */
    private Bitmap loadCoverFromMediaStore(long albumId) {
        ContentResolver resolver = context.getContentResolver();
        Uri uri = MusicUtils.getMediaStoreAlbumCoverUri(albumId);
        InputStream is;
        try {
            is = resolver.openInputStream(uri);
        } catch (FileNotFoundException ignored) {
            return null;
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        return BitmapFactory.decodeStream(is, null, options);
    }

    /**
     * 从下载的图片加载封面<br>
     * 网络音乐
     */
    private Bitmap loadCoverFromFile(String path) {
//        System.out.println("是否有path"+path);
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPreferredConfig = Bitmap.Config.RGB_565;
//        System.out.println("是否有decode成功"+BitmapFactory.decodeFile(path, options));

        //这边是从网络下载的

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                URL imageurl = null;

                try {
                    imageurl = new URL(path);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                //System.out.println("第一次的url"+imageurl);
                try {
                    HttpURLConnection conn = (HttpURLConnection)imageurl.openConnection();
                    conn.setDoInput(true);
                    conn.connect();
                    InputStream is = conn.getInputStream();
                    bitmap_url = BitmapFactory.decodeStream(is);
                    //System.out.println("第一次的bitmap"+bitmap_url);
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return bitmap_url;
    }
}
