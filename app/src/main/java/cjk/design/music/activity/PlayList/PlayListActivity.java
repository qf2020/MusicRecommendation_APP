package cjk.design.music.activity.PlayList;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import org.blinkenlights.jid3.io.IFileSource;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.activity.BaseActivity;
import cjk.design.music.activity.ui.personal_information.MusicLikeBean;
import cjk.design.music.activity.ui.personal_information.MusicLikeData;
import cjk.design.music.adapter.MusicRecycleAdapter;
import cjk.design.music.databinding.ActivityPlayListBinding;
import cjk.design.music.executor.PlaySearchedMusic;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.model.Music;
import cjk.design.music.onLineMusicBean.PlaylistDetailBean;
import cjk.design.music.service.AudioPlayer;
import cjk.design.music.utils.ToastUtils;

public class PlayListActivity extends BaseActivity implements View.OnClickListener {
    private MusicRecycleAdapter adapter;
    private ActivityPlayListBinding binding;
    private String playListId;
    private List<Music> list = new ArrayList<>();
    private long likeId;
    private int isLove;
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        playListId = intent.getStringExtra("playListId");
        isLove = intent.getIntExtra("isLove",0);
        likeId = intent.getLongExtra("likeId",0);
        userId = intent.getIntExtra("userId",0);
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

                HttpClient.getMusicLike(String.valueOf(userId),new HttpCallback<MusicLikeBean>() {
                    @Override
                    public void onSuccess(MusicLikeBean playlistBean) {
                        if (playlistBean == null || playlistBean.getRows() == null) {
                            onFail(null);
                            return;

                        }
                        for (int i = 0;i<playlistDetailBean.getPlaylist().getTracks().size();i++){
                            Music music = new Music();
                            music.setCoverPath(playlistDetailBean.getPlaylist().getTracks().get(i).getAl().getPicUrl());
                            music.setSongId(playlistDetailBean.getPlaylist().getTracks().get(i).getId());
                            music.setArtist(playlistDetailBean.getPlaylist().getTracks().get(i).getAr().get(0).getName());
                            music.setTitle(playlistDetailBean.getPlaylist().getTracks().get(i).getName());
                            music.setType(Music.Type.ONLINE);
                            for(int j = 0;j<playlistBean.getRows().size();j++){
                                if(playlistBean.getRows().get(j).getMusicId()==music.getSongId()){
                                    music.setIsLove(1);
                                    music.setCurIsLove(1);
                                }
                            }
                            list.add(music);
                        }
                        initData();
                    }

                    @Override
                    public void onFail(Exception e) {
                        System.out.println(e);
                    }
                });



            }
            @Override
            public void onFail(Exception e) {

            }
        });
    }
    private void initData(){
        adapter = new MusicRecycleAdapter(this,list,1);
        adapter.setOnItemListener(new MusicRecycleAdapter.ItemListener() {
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
        adapter.setOnLoveListener(new MusicRecycleAdapter.LoveListener() {
            @Override
            public void ItemOnClick(String tag,int position) {
                if (tag.equals("selected")){
                    list.get(position).setCurIsLove(1);
                }else if(tag.equals("unselected")){
                    list.get(position).setCurIsLove(0);
                }
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

        if (isLove==1){
            binding.musicListLove.setColorFilter(Color.parseColor("#F44336"));
            binding.musicListLove.setTag("selected");
        }else if (isLove == 3){
            binding.musicListLove.setVisibility(View.GONE);
        }

        binding.musicListLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.musicListLove.getTag().equals("unselected")){
                    binding.musicListLove.setColorFilter(Color.parseColor("#F44336"));
                    binding.musicListLove.setTag("selected");
                }else{
                    binding.musicListLove.clearColorFilter();
                    binding.musicListLove.setTag("unselected");
                }
            }
        });
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            for (int i = 0;i<list.size();i++){
                if (list.get(i).getCurIsLove()==1 && list.get(i).getIsLove()!=1){
                    HttpClient.addMusicLike(userId, list.get(i).getSongId(), new HttpCallback<String>() {
                        @Override
                        public void onSuccess(String s) {
                            System.out.println("调用音乐添加成功！！！");
                        }
                        @Override
                        public void onFail(Exception e) {

                        }
                    });
                }
                if(list.get(i).getCurIsLove()==0 && list.get(i).getIsLove()==1){
                    System.out.println("cur"+list.get(i).getCurIsLove()+"isLove"+list.get(i).getIsLove());
                    HttpClient.deleteMusicLike(userId,list.get(i).getSongId(), new HttpCallback<String>() {
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

            //以下用于歌单界面的添加，不是喜欢的界面
            if (isLove == 1 && binding.musicListLove.getTag().equals("unselected")){
                HttpClient.deleteMusicListLike(likeId, new HttpCallback<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println("调用歌单删除成功！！！");
                    }
                    @Override
                    public void onFail(Exception e) {

                    }
                });
            }else if (isLove == 0 && binding.musicListLove.getTag().equals("selected")){

                HttpClient.addMusicListLike(userId, Long.valueOf(playListId), new HttpCallback<String>() {
                    @Override
                    public void onSuccess(String s) {
                        System.out.println("增加歌单添加成功！！！");
                    }
                    @Override
                    public void onFail(Exception e) {

                    }
                });
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}