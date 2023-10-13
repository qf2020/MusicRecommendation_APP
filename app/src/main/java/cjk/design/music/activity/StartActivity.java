package cjk.design.music.activity;

import static io.reactivex.internal.schedulers.SchedulerPoolFactory.start;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import cjk.design.music.R;
import cjk.design.music.activity.login.LoginActivity;
import cjk.design.music.databinding.ActivityHomeBinding;
import cjk.design.music.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {

    private ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        SharedPreferences jame = getSharedPreferences("jame", 0);//创建一个文件用来储存app的开启次数状态
        boolean isFirst = jame.getBoolean("isFirst", true);//这个文件里面的布尔常量名，和它的初始状态，状态为是，则触发下面的方法
        if (isFirst) {
            //显示引导页界面
            binding = ActivityStartBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

            SharedPreferences.Editor edit = jame.edit();//创建状态储存文件
            edit.putBoolean("isFirst", false);//将参数put，改变其状态
            edit.commit();//保证文件的创建和编辑
            binding.enterLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.setClass(StartActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        } else {
            Intent intent = new Intent();
            intent.setClass(StartActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
