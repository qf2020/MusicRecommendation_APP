package cjk.design.music.executor;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;

import java.io.File;

import cjk.design.music.adapter.MusicListRecycleAdapter;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.model.DownloadInfo;
import cjk.design.music.model.DownloadInfo1;
import cjk.design.music.model.Lrc;
import cjk.design.music.model.SearchMusic;
import cjk.design.music.model.Music;
import cjk.design.music.model.SearchMusic1;
import cjk.design.music.onLineMusicBean.MusicLrc;
import cjk.design.music.onLineMusicBean.SongInfoBean;
import cjk.design.music.utils.FileUtils;



//用于获取网路歌曲链接的
public abstract class PlaySearchedMusic extends PlayMusic {
    private String path = FileUtils.getLrcDir();
    public PlaySearchedMusic(Activity activity, Music song) {
        super(activity, 3);
        if (Build.VERSION.SDK_INT>29){
            path = activity.getExternalFilesDir(null).getAbsolutePath();
        }
        music = song;//注意这个music是调用了playmusic里面的
    }

    @Override
    protected void getPlayInfo() {
        //这个应该和歌词有关,还没研究
        String lrcFileName = FileUtils.getLrcFileName(music.getArtist(), music.getTitle());
        File lrcFile = new File(path+"/"+lrcFileName);

        downloadLrc(lrcFile.getPath());


        //获取图片链接
        if (music.getCoverPath() == null){
            HttpClient.getMusicCover(String.valueOf(music.getSongId()), new HttpCallback<SongInfoBean>() {
                @Override
                public void onSuccess(SongInfoBean songInfoBean) {
                    if (songInfoBean == null || songInfoBean.getSongs() == null) {
                        onFail(null);
                        return;
                    }
                    music.setCoverPath(songInfoBean.getSongs().get(0).getAl().getPicUrl());
                    checkCounter();
                }

                @Override
                public void onFail(Exception e) {
                    onExecuteFail(e);
                }
            });
        }else{
            checkCounter();
        }


        // 获取歌曲播放链接
        HttpClient.getMusicUrl(String.valueOf(music.getSongId()), new HttpCallback<DownloadInfo1>() {
            @Override
            public void onSuccess(DownloadInfo1 response) {
                if (response == null || response.getData() == null) {
                    onFail(null);
                    return;
                }

                music.setPath(response.getData().get(0).getUrl());
                music.setDuration(response.getData().get(0).getTime());
                checkCounter();
            }

            @Override
            public void onFail(Exception e) {
                onExecuteFail(e);
            }
        });


    }

    private void downloadLrc(final String filePath) {
        HttpClient.getMusicLrc(String.valueOf(music.getSongId()), new HttpCallback<MusicLrc>() {
            @Override
            public void onSuccess(MusicLrc response) {
                if (response == null || TextUtils.isEmpty(response.getLrc().getLyric())) {
                    return;
                }
                music.setLrc(response.getLrc().getLyric());
            }

            @Override
            public void onFail(Exception e) {

            }

            @Override
            public void onFinish() {
                checkCounter();
            }
        });
    }
}
