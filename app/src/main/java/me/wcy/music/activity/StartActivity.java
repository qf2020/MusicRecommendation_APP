package me.wcy.music.activity;

import static io.reactivex.internal.schedulers.SchedulerPoolFactory.start;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import me.wcy.music.R;
import me.wcy.music.databinding.ActivityHomeBinding;
import me.wcy.music.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {

    private SharedPreferences mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        SharedPreferences jame = getSharedPreferences("jame", 0);//创建一个文件用来储存app的开启次数状态
        boolean isFirst = jame.getBoolean("isFirst", true);//这个文件里面的布尔常量名，和它的初始状态，状态为是，则触发下面的方法
        if (isFirst) {
            //显示引导页界面
            setContentView(R.layout.activity_start);
            SharedPreferences.Editor edit = jame.edit();//创建状态储存文件
            edit.putBoolean("isFirst", false);//将参数put，改变其状态
            edit.commit();//保证文件的创建和编辑
            new CountDownTimer(1000, 1000) //这个方法是一个计时器
            {
                @Override
                public void onTick(long millisUntilFinished) {
                }

                @Override
                public void onFinish() {

                    Intent intent = new Intent();
                    intent.setClass(StartActivity.this, MusicActivity.class);
                    startActivity(intent);
                    //下面的功能实现了引导页的逐渐关闭
                    int VERSION = Integer.parseInt(android.os.Build.VERSION.SDK);
//                    if (VERSION >= 5) {
//                        StartActivity.this.overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
//                    }
                    finish();
                }
            }.start();
        } else {
            setContentView(R.layout.activity_music);//否则就显示注册界面
        }
    }
}
