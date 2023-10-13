package cjk.design.music.http;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.BitmapCallback;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONObject;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import cjk.design.music.activity.login.LoginBean;
import cjk.design.music.activity.newMusic.NewMusicBean;
import cjk.design.music.activity.ui.personal_information.MusicLikeBean;
import cjk.design.music.activity.ui.personal_information.MusicListLikeBean;
import cjk.design.music.activity.ui.personal_information.UserInformationBean;
import cjk.design.music.model.ArtistInfo;
import cjk.design.music.model.DownloadInfo;
import cjk.design.music.model.DownloadInfo1;
import cjk.design.music.model.Lrc;
import cjk.design.music.model.OnlineMusicList;
import cjk.design.music.model.SearchMusic;
import cjk.design.music.model.SearchMusic1;
import cjk.design.music.model.Splash;
import cjk.design.music.onLineMusicBean.MusicLrc;
import cjk.design.music.onLineMusicBean.PlaylistBean;
import cjk.design.music.onLineMusicBean.PlaylistDetailBean;
import cjk.design.music.onLineMusicBean.RankMusciBean;
import cjk.design.music.onLineMusicBean.RecommendationMusicBean;
import cjk.design.music.onLineMusicBean.SongInfoBean;
import cjk.design.music.onLineMusicBean.UserMusicActionBean;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

/**
 */
public class HttpClient {
    private static final String SPLASH_URL = "http://cn.bing.com/HPImageArchive.aspx?format=js&idx=0&n=1";
    private static final String ip = "http://192.168.109.92:3000";
    private static final String MUSIC_RUOYI = "http://192.168.109.92:8080";
    private static final String BASE_URL = "http://tingapi.ting.baidu.com/v1/restserver/ting";
    private static final String METHOD_GET_MUSIC_LIST = "baidu.ting.billboard.billList";
    private static final String METHOD_DOWNLOAD_MUSIC = "baidu.ting.song.play";
    private static final String METHOD_ARTIST_INFO = "baidu.ting.artist.getInfo";
    private static final String METHOD_SEARCH_MUSIC = "baidu.ting.search.catalogSug";
    private static final String METHOD_LRC = "baidu.ting.song.lry";
    private static final String PARAM_METHOD = "method";
    private static final String PARAM_TYPE = "type";
    private static final String PARAM_SIZE = "size";
    private static final String PARAM_OFFSET = "offset";
    private static final String PARAM_SONG_ID = "songid";
    private static final String PARAM_TING_UID = "tinguid";
    private static final String PARAM_QUERY = "query";

    static {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new HttpInterceptor())
                .build();
        OkHttpUtils.initClient(okHttpClient);

    }



    public static void addMusicLike(int userId,long musicId, @NonNull final HttpCallback<String> callback) {
        OkHttpUtils.postString().url(MUSIC_RUOYI+"/music-like/music-like-manager")
                .content(new Gson().toJson(new MusicLikeBean.RowsBean(userId, musicId)))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        callback.onSuccess(response);
                        System.out.println(response+"添加喜欢的歌曲");
                    }
                });
    }
    public static void deleteMusicLike(long userId, long MusicId,@NonNull final HttpCallback<String> callback) {
        OkHttpUtils.get().url(MUSIC_RUOYI+"/music-like/music-like-manager/delete")
                .addParams("userId", String.valueOf(userId))
                .addParams("MusicId", String.valueOf(MusicId))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        callback.onSuccess(response);
                        System.out.println(response+"删除喜欢的歌曲");
                    }
                });
    }

    public static void addMusicListLike(int userId,long musicListId, @NonNull final HttpCallback<String> callback) {
        OkHttpUtils.postString().url(MUSIC_RUOYI+"/music_list_like/music_list_like_manager")
                .content(new Gson().toJson(new MusicListLikeBean.RowsBean(musicListId, userId)))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        callback.onSuccess(response);
                        System.out.println(response+"添加喜欢的歌曲");
                    }
                });
    }

    //添加用户
    public static void addUser(String phone,String password, @NonNull final HttpCallback<String> callback) {
        OkHttpUtils.postString().url(MUSIC_RUOYI+"/user/user_manage")
                .content(new Gson().toJson(new LoginBean.RowsBean(phone, password)))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        callback.onSuccess(response);
                        System.out.println(response+"添加喜欢的歌曲");
                    }
                });
    }

    public static void addAction(int userId,String musicId,String listenHour,String pointTimes, @NonNull final HttpCallback<String> callback) {
        OkHttpUtils.postString().url(MUSIC_RUOYI+"/user_music_action/user_music_action_manage/action")
                .content(new Gson().toJson(new UserMusicActionBean.RowsBean(userId, musicId,listenHour,pointTimes)))
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        callback.onSuccess(response);
                        System.out.println(response+"添加时长");
                    }
                });
    }



    public static void changeInformation(UserInformationBean.RowsBean userInformationBean, @NonNull final HttpCallback<String> callback) {
        Gson  gson = new Gson();
        String personJson = gson.toJson(userInformationBean);
        OkHttpUtils.put().url(MUSIC_RUOYI+"/information/information_manage")
                .requestBody(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), personJson))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        callback.onSuccess(response);
                        System.out.println(response+"修改用户信息");
                    }
                });
    }




    public static void changePassword(LoginBean.RowsBean loginBean , @NonNull final HttpCallback<String> callback) {
        Gson  gson = new Gson();
        String personJson = gson.toJson(loginBean);
        OkHttpUtils.put().url(MUSIC_RUOYI+"/user/user_manage")
                .requestBody(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), personJson))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        callback.onSuccess(response);
                        System.out.println(response+"修改用户密码");
                    }
                });
    }


    public static void deleteMusicListLike(long userMusiclistLikeId,@NonNull final HttpCallback<String> callback) {
        OkHttpUtils.get().url(MUSIC_RUOYI+"/music_list_like/music_list_like_manager/delete")
                .addParams("userMusiclistLikeId", String.valueOf(userMusiclistLikeId))
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }
                    @Override
                    public void onResponse(String response, int id) {
                        callback.onSuccess(response);
                        System.out.println(response+"删除喜欢的歌单");
                    }
                });
    }

    public static void getIsExistUser(String phone,String password,@NonNull final HttpCallback<LoginBean> callback) {
        OkHttpUtils.get().url(MUSIC_RUOYI+"/user/user_manage/list")
                .addParams("phone", phone)
                .addParams("password", password)
                .build()
                .execute(new JsonCallback<LoginBean>(LoginBean.class) {
                    @Override
                    public void onResponse(LoginBean response, int id) {
                        callback.onSuccess(response);
                    }
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void getMusicLike(String userId,@NonNull final HttpCallback<MusicLikeBean> callback) {
        OkHttpUtils.get().url(MUSIC_RUOYI+"/music-like/music-like-manager/list")
                .addParams("userId", userId)
                .build()
                .execute(new JsonCallback<MusicLikeBean>(MusicLikeBean.class) {
                    @Override
                    public void onResponse(MusicLikeBean response, int id) {
                        callback.onSuccess(response);
                    }
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }
    public static void getRecommendation(String userId,@NonNull final HttpCallback<RecommendationMusicBean> callback) {
        OkHttpUtils.get().url(MUSIC_RUOYI+"/user_recommendation/user_recommendation_manage/list")
                .addParams("userId", userId)
                .build()
                .execute(new JsonCallback<RecommendationMusicBean>(RecommendationMusicBean.class) {
                    @Override
                    public void onResponse(RecommendationMusicBean response, int id) {
                        callback.onSuccess(response);
                    }
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void setRecommendation(String userId,String userIdRec,@NonNull final HttpCallback<String> callback) {
        OkHttpUtils.get().url(MUSIC_RUOYI+"/user_recommendation/user_recommendation_manage/setRecommendation")
                .addParams("userId", userId)
                .addParams("userIdRec", userIdRec)
                .build()
                .execute(new JsonCallback<String>(String.class) {
                    @Override
                    public void onResponse(String response, int id) {
                        callback.onSuccess(response);
                    }
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }


    public static void getInformation(String userId,@NonNull final HttpCallback<UserInformationBean> callback) {
        OkHttpUtils.get().url(MUSIC_RUOYI+"/information/information_manage/list")
                .addParams("userId", userId)
                .build()
                .execute(new JsonCallback<UserInformationBean>(UserInformationBean.class) {
                    @Override
                    public void onResponse(UserInformationBean response, int id) {
                        callback.onSuccess(response);
                    }
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }


    public static void getMusicLikeList(String userId,@NonNull final HttpCallback<MusicListLikeBean> callback) {
        OkHttpUtils.get().url(MUSIC_RUOYI+"/music_list_like/music_list_like_manager/list")
                .addParams("userId", userId)
                .build()
                .execute(new JsonCallback<MusicListLikeBean>(MusicListLikeBean.class) {
                    @Override
                    public void onResponse(MusicListLikeBean response, int id) {
                        callback.onSuccess(response);
                    }
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void getSplash(@NonNull final HttpCallback<Splash> callback) {
        OkHttpUtils.get().url(SPLASH_URL)
                .build()
                .execute(new JsonCallback<Splash>(Splash.class) {
                    @Override
                    public void onResponse(Splash response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void downloadFile(String url, String destFileDir, String destFileName, @Nullable final HttpCallback<File> callback) {
        OkHttpUtils.get().url(url).build()
                .execute(new FileCallBack(destFileDir, destFileName) {
                    @Override
                    public void inProgress(float progress, long total, int id) {
                    }

                    @Override
                    public void onResponse(File file, int id) {
                        if (callback != null) {
                            callback.onSuccess(file);
                        }
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        if (callback != null) {
                            callback.onFail(e);
                        }
                    }

                    @Override
                    public void onAfter(int id) {
                        if (callback != null) {
                            callback.onFinish();
                        }
                    }
                });
    }

    public static void getSongListInfo(String type, int size, int offset, @NonNull final HttpCallback<OnlineMusicList> callback) {
        OkHttpUtils.get().url(BASE_URL)
                .addParams(PARAM_METHOD, METHOD_GET_MUSIC_LIST)
                .addParams(PARAM_TYPE, type)
                .addParams(PARAM_SIZE, String.valueOf(size))
                .addParams(PARAM_OFFSET, String.valueOf(offset))
                .build()
                .execute(new JsonCallback<OnlineMusicList>(OnlineMusicList.class) {
                    @Override
                    public void onResponse(OnlineMusicList response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    //获取歌曲url
    public static void getMusicUrl(String songId, @NonNull final HttpCallback<DownloadInfo1> callback) {
        OkHttpUtils.get().url(ip+"/song/url")
                .addParams("id", songId)
                .build()
                .execute(new JsonCallback<DownloadInfo1>(DownloadInfo1.class) {
                    @Override
                    public void onResponse(DownloadInfo1 response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void getNewMusic(String type, @NonNull final HttpCallback<NewMusicBean> callback) {
        OkHttpUtils.get().url(ip+"/top/song")
                .addParams("type", type)
                .build()
                .execute(new JsonCallback<NewMusicBean>(NewMusicBean.class) {
                    @Override
                    public void onResponse(NewMusicBean response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }


    public static void getRank(@NonNull final HttpCallback<RankMusciBean> callback) {
        OkHttpUtils.get().url(ip+"/toplist")
                .build()
                .execute(new JsonCallback<RankMusciBean>(RankMusciBean.class) {
                    @Override
                    public void onResponse(RankMusciBean response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void getMusicCover(String songId, @NonNull final HttpCallback<SongInfoBean> callback) {
        OkHttpUtils.get().url(ip+"/song/detail")
                .addParams("ids", songId)
                .build()
                .execute(new JsonCallback<SongInfoBean>(SongInfoBean.class) {
                    @Override
                    public void onResponse(SongInfoBean response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void getMusicDownloadInfo(String songId, @NonNull final HttpCallback<DownloadInfo> callback) {
        OkHttpUtils.get().url(ip+"/song/url")
                .addParams("id", songId)
                .build()
                .execute(new JsonCallback<DownloadInfo>(DownloadInfo.class) {
                    @Override
                    public void onResponse(DownloadInfo response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void getPlayList( @NonNull final HttpCallback<PlaylistBean> callback) {
        OkHttpUtils.get().url(ip+"/top/playlist")
                .addParams("limit", "48")
                .build()
                .execute(new JsonCallback<PlaylistBean>(PlaylistBean.class) {
                    @Override
                    public void onResponse(PlaylistBean response, int id) {
                        callback.onSuccess(response);
                    }
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void getPlayListDetail(String playListID, @NonNull final HttpCallback<PlaylistDetailBean> callback) {
        OkHttpUtils.get().url(ip+"/playlist/detail")
                .addParams("id", playListID)
                .build()
                .execute(new JsonCallback<PlaylistDetailBean>(PlaylistDetailBean.class) {
                    @Override
                    public void onResponse(PlaylistDetailBean response, int id) {
                        callback.onSuccess(response);
                    }
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }



    public static void getBitmap(String url, @NonNull final HttpCallback<Bitmap> callback) {
        OkHttpUtils.get().url(url).build()
                .execute(new BitmapCallback() {
                    @Override
                    public void onResponse(Bitmap bitmap, int id) {
                        callback.onSuccess(bitmap);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void getLrc(String songId, @NonNull final HttpCallback<Lrc> callback) {
        OkHttpUtils.get().url(BASE_URL)
                .addParams(PARAM_METHOD, METHOD_LRC)
                .addParams(PARAM_SONG_ID, songId)
                .build()
                .execute(new JsonCallback<Lrc>(Lrc.class) {
                    @Override
                    public void onResponse(Lrc response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void getMusicLrc(String songId, @NonNull final HttpCallback<MusicLrc> callback) {
        OkHttpUtils.get().url(ip+"/lyric")
                .addParams("id", songId)
                .build()
                .execute(new JsonCallback<MusicLrc>(MusicLrc.class) {
                    @Override
                    public void onResponse(MusicLrc response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }


    public static void searchMusic(String keyword, @NonNull final HttpCallback<SearchMusic1> callback) {
        OkHttpUtils.get().url(ip+"/search")
                .addParams("keywords", keyword)
                .build()
                .execute(new JsonCallback<SearchMusic1>(SearchMusic1.class) {
                    @Override
                    public void onResponse(SearchMusic1 response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }

    public static void getArtistInfo(String tingUid, @NonNull final HttpCallback<ArtistInfo> callback) {
        OkHttpUtils.get().url(BASE_URL)
                .addParams(PARAM_METHOD, METHOD_ARTIST_INFO)
                .addParams(PARAM_TING_UID, tingUid)
                .build()
                .execute(new JsonCallback<ArtistInfo>(ArtistInfo.class) {
                    @Override
                    public void onResponse(ArtistInfo response, int id) {
                        callback.onSuccess(response);
                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {
                        callback.onFail(e);
                    }

                    @Override
                    public void onAfter(int id) {
                        callback.onFinish();
                    }
                });
    }
}
