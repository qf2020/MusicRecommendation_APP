package cjk.design.music.activity.ui.personal_information;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.activity.BaseActivity;
import cjk.design.music.adapter.MusicRecycleAdapter;
import cjk.design.music.databinding.ActivityPlayLikeBinding;
import cjk.design.music.databinding.ActivityPlayListBinding;
import cjk.design.music.executor.PlaySearchedMusic;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.model.Music;
import cjk.design.music.onLineMusicBean.PlaylistDetailBean;
import cjk.design.music.onLineMusicBean.SongInfoBean;
import cjk.design.music.service.AudioPlayer;
import cjk.design.music.utils.ToastUtils;

public class PlayLikeListActivity extends BaseActivity implements View.OnClickListener {
    private MusicRecycleAdapter adapter;
    private ActivityPlayLikeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayLikeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        initView(intent);
        initData();


    }

    private void initData(){

        adapter = new MusicRecycleAdapter(this,MusicLikeData.musicList,4);
        adapter.setOnItemListener(new MusicRecycleAdapter.ItemListener() {
            @Override
            public void ItemOnClick(int position) {
                new PlaySearchedMusic(PlayLikeListActivity.this, MusicLikeData.musicList.get(position)) {
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
        adapter.setOnLoveListener(new MusicRecycleAdapter.LoveListener() {
            @Override
            public void ItemOnClick(String tag,int position) {
                if (tag.equals("selected")){
                    MusicLikeData.musicList.get(position).setIsLove(1);
                    System.out.println("点赞"+MusicLikeData.musicList.get(position).getSongId());
                }else if(tag.equals("unselected")){
                    MusicLikeData.musicList.get(position).setIsLove(0);
                    System.out.println("取消点赞"+MusicLikeData.musicList.get(position).getSongId());
                }
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.palylistRecycle.setLayoutManager(manager);
        binding.palylistRecycle.setAdapter(adapter);
    }
    private void initView(Intent intent){

        Glide.with(getApplicationContext()).load(R.drawable.i_love_music)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .error(R.drawable.play_page_default_bg)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .into(binding.playlistCover);
        binding.playlistDescription.setText("音乐充满着音符和色彩"+"\n"+"打造出独特而又充满灵魂的旋律!");
        binding.playlistStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.playlist_start:
                if (!MusicLikeData.musicList.isEmpty()){
                    new PlaySearchedMusic(PlayLikeListActivity.this, MusicLikeData.musicList.get(0)) {
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
                    for (int i = 1;i<MusicLikeData.musicList.size();i++){
                        new PlaySearchedMusic(PlayLikeListActivity.this, MusicLikeData.musicList.get(i)) {
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
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            for (int i = 0;i<MusicLikeData.musicList.size();i++){
                if (MusicLikeData.musicList.get(i).getIsLove()==0){
                    HttpClient.deleteMusicLike(1,MusicLikeData.musicList.get(i).getSongId(), new HttpCallback<String>() {
                        @Override
                        public void onSuccess(String s) {
                            System.out.println("调用音乐删除成功！！！");
                        }
                        @Override
                        public void onFail(Exception e) {

                        }
                    });
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}

