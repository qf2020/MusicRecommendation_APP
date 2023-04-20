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
import cjk.design.music.activity.MusicPlayActivity;
import cjk.design.music.adapter.MusicRecycleAdapter;
import cjk.design.music.databinding.ActivityRecommendationFirstBinding;

public class RecommendationFirstActivity extends AppCompatActivity {


    private static final String TAG = "MainActivity";
    private ActivityRecommendationFirstBinding binding;
    private MusicRecycleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //标题折叠状态下，无法设置maxlines。（目前来看改不了了）
        //未完成数据填充和界面按键响应事件
        super.onCreate(savedInstanceState);
        binding = ActivityRecommendationFirstBinding.inflate(getLayoutInflater());
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
        setSupportActionBar(binding.recommendationFirstTb); //获取actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//显示返回按钮

        SpannableString sStr = new SpannableString("美好的约会!"+'\n'+"  乘着明媚阳光，不插电好歌伴你轻松一夏.");
        sStr.setSpan(new AbsoluteSizeSpan(25, true),6,sStr.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        binding.recommendationFirstCollapsingToolbar.setTitle(sStr);
        MusicData musicData  = new MusicData();
        adapter = new MusicRecycleAdapter(this,musicData.musicList,1);
        adapter.setOnItemListener(new MusicRecycleAdapter.ItemListener() {
            @Override
            public void ItemOnClick(int position) {
                Intent intent = new Intent(RecommendationFirstActivity.this, MusicPlayActivity.class);
                startActivity(intent);
            }
        });
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.recommendationFirstRecycle.setLayoutManager(manager);
        binding.recommendationFirstRecycle.setAdapter(adapter);

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