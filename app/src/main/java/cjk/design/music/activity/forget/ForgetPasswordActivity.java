package cjk.design.music.activity.forget;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import cjk.design.music.R;
import cjk.design.music.activity.login.LoginActivity;
import cjk.design.music.activity.login.LoginBean;
import cjk.design.music.activity.service.RegisterManager;
import cjk.design.music.http.HttpCallback;
import cjk.design.music.http.HttpClient;
import cjk.design.music.utils.ToastUtils;


public class ForgetPasswordActivity extends AppCompatActivity implements  View.OnClickListener{

    private final RegisterManager uRegister = new RegisterManager();
    String sPassEditGet="",sPassEditConfirmGet="",sName;
    TextView buttonForgetPass;
    EditText ForgetPass,ForgetPassConfirm;
    private int userId;
    private String userIdRec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        Intent intent = getIntent();
        sName = intent.getStringExtra("tel");
        userId = getIntent().getIntExtra("userId",0);
        userIdRec = getIntent().getStringExtra("userIdRec");
        initToolBar();
        buttonForgetPass = findViewById(R.id.forget_password_enter);
        ForgetPass = findViewById(R.id.forget_passwd);
        ForgetPassConfirm = findViewById(R.id.forget_confirm_pass);
        ForgetPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sPassEditGet = ForgetPass.getText().toString();
            }
        });

        ForgetPassConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sPassEditConfirmGet = ForgetPassConfirm.getText().toString();
            }
        });


        buttonForgetPass.setOnClickListener(this);
    }

    private void initToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.forget_2_tb);
        setSupportActionBar(toolbar);//设置toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("忘记密码");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //注册按钮响应操作
            case R.id.forget_password_enter:{
                boolean judge1 = false;
                boolean judge2 = false;
                boolean judge3 = false;
                for (int i = 0; i < sPassEditGet.length(); i++) {
                    char temp = sPassEditConfirmGet.charAt(i);
                    if (temp <= '9' && temp >= '0') {
                        judge1 = true;
                    } else if (temp <= 'z' && temp >= 'a') {
                        judge2 = true;
                    } else if (temp <= 'Z' && temp >= 'A') {
                        judge3 = true;
                    }
                }
                if(sPassEditGet.isEmpty()){
                    Toast.makeText(this,"密码不可为空",Toast.LENGTH_LONG).show();
                }
                else if(!(sPassEditGet.length()<=16 && sPassEditGet.length()>=8)){

                    Toast.makeText(this,"密码8-16位",Toast.LENGTH_LONG).show();


                }
                else if(judge1 == false | judge2 == false | judge3 == false) {

                    Toast.makeText(this,"密码必须包含大小写字母以及数字",Toast.LENGTH_LONG).show();

                }
                else if(sPassEditConfirmGet.isEmpty()){
                    Toast.makeText(this,"密码不可为空",Toast.LENGTH_LONG).show();

                }
                else if(!sPassEditGet.equals(sPassEditConfirmGet)){
                    Toast.makeText(this,"密码输入不一致",Toast.LENGTH_LONG).show();
                }
                else{
                    LoginBean.RowsBean rowsBean = new LoginBean.RowsBean(userId,sName,sPassEditConfirmGet,userIdRec);
                    HttpClient.changePassword(rowsBean,new HttpCallback<String>() {
                        @Override
                        public void onSuccess(String s) {
                            ToastUtils.show("密码修改成功");
                            Intent intent = new Intent(ForgetPasswordActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                        }

                        @Override
                        public void onFail(Exception e) {
                            System.out.println(e);
                        }
                    });


                }
                break;
            }
            default:
                break;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}