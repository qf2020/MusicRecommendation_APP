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

import cjk.design.music.Data.MusicData;
import cjk.design.music.R;
import cjk.design.music.activity.MusicPlayActivity;
import cjk.design.music.adapter.MusicListRecycleAdapter;
import cjk.design.music.databinding.ActivityRecommendationSecondBinding;
import cjk.design.music.databinding.ActivityRecommendationThirdBinding;

public class RecommendationThirdActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityRecommendationThirdBinding binding;
    private MusicListRecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //标题折叠状态下，无法设置maxlines。（目前来看改不了了）
        //未完成数据填充和界面按键响应事件
        super.onCreate(savedInstanceState);
        binding = ActivityRecommendationThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initDate();
        initView();
    }



    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    private void initDate(){
    }

    private void initView() {


        //显示返回按钮
        //CollapsingToolbarLayout  :可滚动toorbar
        setSupportActionBar(binding.recommendationThirdTb); //获取actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示返回按钮

        SpannableString sStr = new SpannableString("燥动吧!青年"+'\n'+"  触及灵魂深入并激发你创作潜力的20首歌曲.");
        sStr.setSpan(new AbsoluteSizeSpan(25, true),6,sStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.recommendationThirdCollapsingToolbar.setTitle(sStr);
        MusicData musicData  = new MusicData();
        adapter = new MusicListRecycleAdapter(this,musicData.musicList,3);
        adapter.setOnItemListener(new MusicListRecycleAdapter.ItemListener() {
            @Override
            public void ItemOnClick(int position) {
                Intent intent = new Intent(RecommendationThirdActivity.this, MusicPlayActivity.class);
                startActivity(intent);
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
            Intent intent = new Intent();
            Bundle bundle = new Bundle();

            intent.putExtras(bundle);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
        return false;
    }
}