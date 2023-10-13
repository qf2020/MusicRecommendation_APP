package cjk.design.music.activity.forget;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

import com.bigkoo.pickerview.view.OptionsPickerView;

import cjk.design.music.R;
import cjk.design.music.activity.HomeActivity;
import cjk.design.music.activity.login.LoginActivity;
import cjk.design.music.activity.login.LoginBean;
import cjk.design.music.activity.service.RegisterManager;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.utils.ToastUtils;

/**
 * @description 登录活动界面
 * @author cjk
 * @time 2021/12/2 17:36
 */
public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private final RegisterManager uRegister = new RegisterManager();

    private TextView buttonSign;

    private String sNameEditGet;

    private EditText forgetTel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_main);
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

        buttonSign = findViewById(R.id.main_btn_forget_text);
        forgetTel =  findViewById(R.id.forget_tel);
    }

    /**
     * @description 设置注册、获取验证码、身份下拉框等响应时间
     * @author cjk
     * @time 2021/11/29 22:06
     */
    private void iniSetOnClickListener(){

        buttonSign.setOnClickListener(this);

        forgetTel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sNameEditGet = forgetTel.getText().toString();
            }
        });
    }

    /**
     * @description 初始化toorbar返回组件的所有配置
     * @author cjk
     * @time 2021/11/29 22:07
     */
    private void initToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.forget_tb);
        setSupportActionBar(toolbar);//设置toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("忘记密码");
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
            case R.id.main_btn_forget_text:{

                if(sNameEditGet==null){
                    ToastUtils.show("电话号码没有输入");
                }
                else{
                    if (uRegister.register(sNameEditGet)){
                        // uRegister.sendMessage("86"+sNameEditGet);
                        HttpClient.getIsExistUser(sNameEditGet,"",new HttpCallback<LoginBean>() {
                            @Override
                            public void onSuccess(LoginBean loginBean) {
                                if (loginBean == null || loginBean.getRows() == null) {
                                    onFail(null);
                                    return;
                                }
                                Intent  intent = new Intent(ForgetActivity.this,ForgetCodeActivity.class);
                                intent.putExtra("Code",uRegister.verifyCode);
                                intent.putExtra("Tel",sNameEditGet);
                                intent.putExtra("userId",loginBean.getRows().get(0).getUserId());
                                intent.putExtra("userIdRec",loginBean.getRows().get(0).getUserIdRec());
                                startActivity(intent);
                            }

                            @Override
                            public void onFail(Exception e) {
                                ToastUtils.show("账号不存在");
                            }
                        });

                    }
                    else {
                        ToastUtils.show("电话号码不符合规范");
                    }

                }


                break;
            }
            default:
                break;
        }

    }

    public void CloseKeyBoard() {
        forgetTel.clearFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(forgetTel.getWindowToken(), 0);

    }

    // 监听点击屏幕上任何位置软键盘消失
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        CloseKeyBoard();
        return super.onTouchEvent(event);
    }
}
