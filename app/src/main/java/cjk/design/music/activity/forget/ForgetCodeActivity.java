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
import cjk.design.music.activity.signup.CountDownView;
import cjk.design.music.activity.service.RegisterManager;

public class ForgetCodeActivity extends AppCompatActivity implements  View.OnClickListener{

    CountDownView btnGetSmsCode;
    private final RegisterManager uRegister = new RegisterManager();
    String SmsCode,sCodeEditGet,sNameEditGet;
    TextView buttonForgetCode;
    EditText ForgetEdit;
    private int userId;
    private String userIdRec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_code);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);


        Intent intent = getIntent();
        SmsCode = intent.getStringExtra("Code");
        sNameEditGet = intent.getStringExtra("Tel");
        userId = getIntent().getIntExtra("userId",0);
        userIdRec = getIntent().getStringExtra("userIdRec");
        initToolBar();

        btnGetSmsCode = findViewById(R.id.forget_btn_get_sms_code_cd);
        btnGetSmsCode.start();

        buttonForgetCode = (TextView) findViewById(R.id.forget_code);
        ForgetEdit = findViewById(R.id.main_btn_forget_text_1);
        ForgetEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sCodeEditGet = ForgetEdit.getText().toString();
            }
        });


        buttonForgetCode.setOnClickListener(this);
        btnGetSmsCode.setOnClickListener(this);
    }

    private void initToolBar(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.forget_1_tb);
        setSupportActionBar(toolbar);//设置toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("忘记密码");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //注册按钮响应操作
            case R.id.forget_code:{
                if (!SmsCode.equals(sCodeEditGet)&&false){
                    Toast.makeText(this,"验证码错误",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"验证码正确",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this,ForgetPasswordActivity.class);
                    intent.putExtra("tel",sNameEditGet);
                    intent.putExtra("userId",userId);
                    intent.putExtra("userIdRec",userIdRec);

                    startActivity(intent);
                    finish();
                }
                break;
            }
            case R.id.forget_btn_get_sms_code_cd: {
                uRegister.sendMessage("86" + sNameEditGet);
                btnGetSmsCode.start();
            }
            default:
                break;
        }

    }

    @Override
    protected void onDestroy() {
        btnGetSmsCode.cancel();
        super.onDestroy();
    }

}