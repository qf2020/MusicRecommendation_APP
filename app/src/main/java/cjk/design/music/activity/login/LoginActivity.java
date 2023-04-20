package cjk.design.music.activity.login;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import cjk.design.music.R;
import cjk.design.music.activity.HomeActivity;
import cjk.design.music.activity.signup.SignUpActivity;
import cjk.design.music.activity.ui.personal_information.MusicLikeBean;
import cjk.design.music.databinding.ActivityMainLoginBinding;
import cjk.design.music.databinding.ActivityMyInfoBinding;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.model.Music;

/**
 * @description 登录活动
 * @author cjk
 * @time 2021/11/29 22:29
 */
public class LoginActivity extends Activity implements View.OnClickListener {

    private TextView buttonLogin, buttonSign, tvAgreement, buttonForget, buttonExist;

    private View loginInputLayout;

    private float width, height;

    private EditText nameLayout, passwordLayout;

    private LinearLayout accordLayout;

    private TextView /*patient,family,doctor,*/error;

    private CountDownView loginMessage;

    private boolean isPassword;

    private int userIdentity = 0;

    private TabLayout videoTab;

    private CheckBox agreeAccordChekBox;

    private ActivityMainLoginBinding binding;


    private View contentView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //白屏显示logo
      /*  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }*/

        if((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0){
            finish();
            return;
        }

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        //StatusBarUtils.setWindowStatusBarColor(this,R.color.white);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//哪个小天才写的

        binding = ActivityMainLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences sharedPreferences = getSharedPreferences("CountUser", MODE_PRIVATE);
        if (sharedPreferences.getInt("key",-1) != -1) {
            Intent inte = new Intent(LoginActivity.this, HomeActivity.class);

            SharedPreferences sharedPreferences1 = getSharedPreferences("user"+sharedPreferences.getInt("key",-1), MODE_PRIVATE);

            inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            System.out.println("已有账户身份"+sharedPreferences1.getString("userPhone","")+" "+sharedPreferences.getInt("key",-1));
            inte.putExtra("userid",sharedPreferences1.getInt("userid",0));
            inte.putExtra("Id",sharedPreferences1.getInt("Id",0));
            inte.putExtra("userRole",sharedPreferences1.getInt("userRole",0));
            inte.putExtra("userPhone",sharedPreferences1.getString("userPhone",""));
            System.out.println(sharedPreferences1.getInt("userid",0)+" "+sharedPreferences1.getInt("Id",0)+" "+sharedPreferences1.getInt("userRole",0));
            startActivity(inte);
            finish();
        }
        initView();

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();

    }
    /**
     * @description 初始化活动中需要使用的组件以及设置监听器
     * @param
     * @return null
     * @author cjk
     * @time 2021/11/29 22:29
     */
    private void initView() {


        accordLayout = (LinearLayout) findViewById(R.id.shake_ll);
        buttonLogin = (TextView) findViewById(R.id.main_btn_login_text);
        buttonSign = (TextView) findViewById(R.id.sign_up_text);
        buttonForget = (TextView) findViewById(R.id.forget_text);
        tvAgreement = (TextView) findViewById(R.id.tv_agreement);
        loginInputLayout = findViewById(R.id.input_layout);
        nameLayout = (EditText) findViewById(R.id.login_tel);
        passwordLayout = (EditText) findViewById(R.id.login_passwd);
        agreeAccordChekBox = (CheckBox) findViewById(R.id.android);



        error = (TextView) loginInputLayout.findViewById(R.id.error) ;

        loginMessage = (CountDownView) loginInputLayout.findViewById(R.id.login_message);
        videoTab = (TabLayout)findViewById(R.id.videoTab);


        buttonLogin.setOnClickListener(this);
        buttonSign.setOnClickListener(this);
        buttonForget.setOnClickListener(this);
        loginMessage.setOnClickListener(this);
        loginMessage.setOnClickListener(this);

        videoTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {//这里tab被选择的原理还不是很清楚
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中了tab的逻辑
                if(videoTab.getTabAt(0).isSelected()){
                    isPassword = false;
                    loginMessage.setVisibility(View.GONE);
                }else{
                    isPassword = true;
                    loginMessage.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //未选中tab的逻辑

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                if(videoTab.getTabAt(0).isSelected()){

                    loginMessage.setVisibility(View.GONE);
                }else{
                    loginMessage.setVisibility(View.VISIBLE);
                }
            }
        });

        LoginAgrementView loginAgrementView = new LoginAgrementView(this,tvAgreement);
        loginAgrementView.useAgrement();
    }



    /**
     * @description 登录按钮已经注册按钮响应操作
     * @param
     * @return
     * @author cjk
     * @time 2021/11/29 22:31
     */
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {

            case R.id.main_btn_login_text:
            {

                if(!agreeAccordChekBox.isChecked()){
                    Animation animation = AnimationUtils.loadAnimation(LoginActivity.this, R.anim.translate_checkbox_shake);
                    accordLayout.startAnimation(animation);
                    break;
                }
                String loginName,loginPaswd;
                loginName=nameLayout.getText().toString();
                loginPaswd=passwordLayout.getText().toString();
                HttpClient.getIsExistUser("1","123",new HttpCallback<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean loginBean) {
                        if (loginBean == null) {
                            onFail(null);
                            return;
                        }
                        //这边写成功的语句
                    }

                    @Override
                    public void onFail(Exception e) {
                        //这边写失败的语句
                    }
                });
                if(true){
                    int identData[] = new int[5];
                    SharedPreferences sharedPreferences = getSharedPreferences("CountUser", MODE_PRIVATE);
                    SharedPreferences.Editor editor1 = sharedPreferences.edit();
                    int count = sharedPreferences.getInt("count",0);
                    for(int i = 0;i<count+1;i++){
                        SharedPreferences sharedPreferences1 = getSharedPreferences("user"+i, MODE_PRIVATE);
                        String temp = sharedPreferences1.getString("userPhone","");

                    }
                    if(true){
                        Intent inte = new Intent(LoginActivity.this, HomeActivity.class);
                        inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        error.setText(null);
                        startActivity(inte);
                        finish();
                    }
                }
                else if(loginName.isEmpty()){
                    error.setText("电话号码不能为空");
                }
                else{
                    error.setText("账号与密码不匹配");
                }



                break;
            }
            case R.id.sign_up_text:
            {
                Intent inte = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(inte);
                break;
            }
//            case R.id.forget_text:
//            {
//                Intent inte = new Intent(LoginActivity.this, ForgetActivity.class);
//                startActivity(inte);
//                break;
//            }
            case R.id.login_message:
                loginMessage.start();
            default:
                break;
        }
    }


    public void CloseKeyBoard() {
        passwordLayout.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(passwordLayout.getWindowToken(), 0);

    }

    // 监听点击屏幕上任何位置软键盘消失
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        CloseKeyBoard();
        return super.onTouchEvent(event);
    }

}
