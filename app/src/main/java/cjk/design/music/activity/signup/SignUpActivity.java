package cjk.design.music.activity.signup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import cjk.design.music.R;
import cjk.design.music.activity.service.RegisterManager;


/**
 * @description 登录活动界面
 * @author cjk
 * @time 2021/12/2 17:36
 */
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private final RegisterManager uRegister = new RegisterManager();

    private TextView buttonSign;

    private String signUserIdentity = "";

    private String sTelEditGet;

    private EditText SignUpTel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        initFindView();
        iniSetOnClickListener();
        initToolBar();

    }



   /**
    * @description 绑定sign_up布局中的组件
    * @author cjk
    * @time 2021/11/29 22:05
    */
    private void initFindView(){

        buttonSign = findViewById(R.id.main_btn_sign_up_text);
        SignUpTel =  findViewById(R.id.sign_up_tel);
    }

    /**
     * @description 设置注册、获取验证码、身份下拉框等响应时间
     * @author cjk
     * @time 2021/11/29 22:06
     */
    private void iniSetOnClickListener(){

        buttonSign.setOnClickListener(this);

        SignUpTel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sTelEditGet = SignUpTel.getText().toString();
            }
        });
    }

    /**
     * @description 初始化toorbar返回组件的所有配置
     * @author cjk
     * @time 2021/11/29 22:07
     */
    private void initToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.sign_up_tb);
        setSupportActionBar(toolbar);//设置toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("新用户注册");
    }


    /**
     *页面关闭时 销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //注册按钮响应操作
            case R.id.main_btn_sign_up_text:{

                if(sTelEditGet==null){
//
                    System.out.println("电话号码没有输入");
                }
                else if(false){//这边调用接口判断是否账号已经存在
                    System.out.println("账号已注册");
                }
                else{
                    if (uRegister.register(sTelEditGet)){
                       // uRegister.sendMessage("86"+sNameEditGet);
                        Intent  intent = new Intent(SignUpActivity.this, SignUpCodeActivity.class);
                        intent.putExtra("Code",uRegister.verifyCode);
                        intent.putExtra("Tel",sTelEditGet);
                        startActivity(intent);
                    }
                    else {

                        Toast.makeText(SignUpActivity.this, "电话号码不符合规范", Toast.LENGTH_SHORT).show();
                    }
                    //userDb.updateUser(userBean.getUserId(),sPawdEditGet);
                    //finish();
                }

                break;
            }
            default:
                break;
        }

    }

    public void CloseKeyBoard() {
        SignUpTel.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(SignUpTel.getWindowToken(), 0);

    }

    // 监听点击屏幕上任何位置软键盘消失
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        CloseKeyBoard();
        return super.onTouchEvent(event);
    }
}
