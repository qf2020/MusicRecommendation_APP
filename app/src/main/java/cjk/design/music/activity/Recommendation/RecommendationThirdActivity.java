package cjk.design.music.activity.Recommendation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.Data.MusicData;
import cjk.design.music.R;
import cjk.design.music.activity.MusicPlayActivity;
import cjk.design.music.activity.ui.personal_information.MusicLikeBean;
import cjk.design.music.adapter.MusicRecycleAdapter;
import cjk.design.music.databinding.ActivityRecommendationThirdBinding;
import cjk.design.music.executor.PlaySearchedMusic;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.model.Music;
import cjk.design.music.onLineMusicBean.PlaylistDetailBean;
import cjk.design.music.service.AudioPlayer;
import cjk.design.music.utils.ToastUtils;

public class RecommendationThirdActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityRecommendationThirdBinding binding;
    private MusicRecycleAdapter adapter;
    private List<Music> list = new ArrayList<>();
    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //标题折叠状态下，无法设置maxlines。（目前来看改不了了）
        //未完成数据填充和界面按键响应事件
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        getWindow().setStatusBarColor(getResources().getColor(R.color.base3));

        Intent intent = getIntent();
        userId = intent.getIntExtra("userId",0);

        super.onCreate(savedInstanceState);
        binding = ActivityRecommendationThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initDate();
    }



    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    private void initDate(){
        HttpClient.getPlayListDetail("4969117191", new HttpCallback<PlaylistDetailBean>() {
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
                        initView();

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

    private void initView() {


        //显示返回按钮
        //CollapsingToolbarLayout  :可滚动toorbar
        setSupportActionBar(binding.recommendationThirdTb); //获取actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示返回按钮

        SpannableString sStr = new SpannableString("燥动吧!青年"+'\n'+"  触及灵魂深入并激发你创作潜力的20首歌曲.");
        sStr.setSpan(new AbsoluteSizeSpan(25, true),6,sStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.recommendationThirdCollapsingToolbar.setTitle(sStr);

        adapter = new MusicRecycleAdapter(this,list,3);
        adapter.setOnItemListener(new MusicRecycleAdapter.ItemListener() {
            @Override
            public void ItemOnClick(int position) {
                new PlaySearchedMusic(RecommendationThirdActivity.this, list.get(position)) {
                    @Override
                    public void onPrepare() {
                    }

                    @Override
                    public void onExecuteSuccess(Music music) {

                        AudioPlayer.get().addAndPlay(music);
                        ToastUtils.show("已添加到播放列表");
                        Intent intent = new Intent(RecommendationThirdActivity.this, MusicPlayActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onExecuteFail(Exception e) {

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
        binding.recommendationThirdRecycle.setLayoutManager(manager);
        binding.recommendationThirdRecycle.setAdapter(adapter);

    }



    //下面两个都跟返回键有关
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            Intent intent = new Intent();
            Bundle bundle = new Bundle();

            intent.putExtras(bundle);
            setResult(Activity.RESULT_OK, intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0){
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

            Intent intent = new Intent();
            Bundle bundle = new Bundle();

            intent.putExtras(bundle);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
        return false;
    }
}