package cjk.design.music.activity.PlayList;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.Data.MusicData;
import cjk.design.music.R;
import cjk.design.music.activity.BaseActivity;
import cjk.design.music.activity.MusicPlayActivity;
import cjk.design.music.activity.Recommendation.RecommendationFirstActivity;
import cjk.design.music.adapter.MusicListRecycleAdapter;
import cjk.design.music.databinding.ActivityPlayListBinding;
import cjk.design.music.executor.PlaySearchedMusic;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.model.Music;
import cjk.design.music.onLineMusicBean.PlaylistDetailBean;
import cjk.design.music.service.AudioPlayer;
import cjk.design.music.utils.ToastUtils;

public class PlayListActivity extends BaseActivity implements View.OnClickListener {
    private MusicListRecycleAdapter adapter;
    private ActivityPlayListBinding binding;
    private String playListId;
    private List<Music> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        playListId = intent.getStringExtra("playListId");
        initView(intent);
        SearchPlayList(playListId);


    }
    private void SearchPlayList(String playListId){
        HttpClient.getPlayListDetail(playListId, new HttpCallback<PlaylistDetailBean>() {
            @Override
            public void onSuccess(PlaylistDetailBean playlistDetailBean) {
                if (playlistDetailBean == null || playlistDetailBean.getPlaylist().getTracks() == null) {
                    onFail(null);
                    return;
                }
                initData(playlistDetailBean);
            }
            @Override
            public void onFail(Exception e) {

            }
        });
    }
    private void initData(PlaylistDetailBean playlistDetailBean){
        for (int i = 0;i<playlistDetailBean.getPlaylist().getTracks().size();i++){
            Music music = new Music();
            music.setCoverPath(playlistDetailBean.getPlaylist().getTracks().get(i).getAl().getPicUrl());
            music.setSongId(playlistDetailBean.getPlaylist().getTracks().get(i).getId());
            music.setArtist(playlistDetailBean.getPlaylist().getTracks().get(i).getAr().get(0).getName());
            music.setTitle(playlistDetailBean.getPlaylist().getTracks().get(i).getName());
            music.setType(Music.Type.ONLINE);
            list.add(music);
        }
        adapter = new MusicListRecycleAdapter(this,list,1);
        adapter.setOnItemListener(new MusicListRecycleAdapter.ItemListener() {
            @Override
            public void ItemOnClick(int position) {
                new PlaySearchedMusic(PlayListActivity.this, list.get(position)) {
                    @Override
                    public void onPrepare() {
                        showProgress();
                    }

                    @Override
                    public void onExecuteSuccess(Music music) {
                        cancelProgress();
                        AudioPlayer.get().addAndPlay(music);
                        //可能是这边进行添加
                        ToastUtils.show("已添加到播放列表");
                    }

                    @Override
                    public void onExecuteFail(Exception e) {
                        cancelProgress();
                        ToastUtils.show(R.string.unable_to_play);
                    }
                }.execute();
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.palylistRecycle.setLayoutManager(manager);
        binding.palylistRecycle.setAdapter(adapter);
    }
    private void initView(Intent intent){

        Glide.with(getApplicationContext()).load(intent.getStringExtra("playListCover"))
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .error(R.drawable.play_page_default_bg)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .into(binding.playlistCover);
        binding.playlistName.setText(intent.getStringExtra("playListName"));
        binding.playlistDescription.setText(intent.getStringExtra("playListDescription"));
        binding.playlistStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.playlist_start:
                if (!list.isEmpty()){
                    new PlaySearchedMusic(PlayListActivity.this, list.get(0)) {
                        @Override
                        public void onPrepare() {
                            showProgress();
                        }

                        @Override
                        public void onExecuteSuccess(Music music) {
                            cancelProgress();

                            AudioPlayer.get().addAndPlay(music);
                            ToastUtils.show("已添加到播放列表");
                        }

                        @Override
                        public void onExecuteFail(Exception e) {
                            cancelProgress();
                            ToastUtils.show(R.string.unable_to_play);
                        }
                    }.execute();
                    for (int i = 1;i<list.size();i++){
                        new PlaySearchedMusic(PlayListActivity.this, list.get(i)) {
                            @Override
                            public void onPrepare() {
                                showProgress();
                            }

                            @Override
                            public void onExecuteSuccess(Music music) {
                                cancelProgress();
                                AudioPlayer.get().add(music);
                            }

                            @Override
                            public void onExecuteFail(Exception e) {
                                cancelProgress();
                            }
                        }.execute();
                    }
                }
        }
    }
}