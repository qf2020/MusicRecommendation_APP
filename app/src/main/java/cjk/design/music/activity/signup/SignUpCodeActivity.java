package cjk.design.music.activity.signup;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import cjk.design.music.R;
import cjk.design.music.activity.service.RegisterManager;


public class SignUpCodeActivity extends AppCompatActivity implements  View.OnClickListener{

    CountDownView btnGetSmsCode;
    private final RegisterManager uRegister = new RegisterManager();
    String SmsCode,sCodeEditGet,sNameEditGet;
    TextView buttonSignUpCode;
    EditText SignUpEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_code);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        Intent intent = getIntent();
        SmsCode = intent.getStringExtra("Code");
        sNameEditGet = intent.getStringExtra("Tel");

        btnGetSmsCode = findViewById(R.id.sign_up_btn_get_sms_code_cd);
        btnGetSmsCode.start();

        buttonSignUpCode = (TextView) findViewById(R.id.sign_up_code);
        SignUpEdit = findViewById(R.id.main_btn_sign_up_text_1);
        SignUpEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sCodeEditGet = SignUpEdit.getText().toString();
            }
        });


        buttonSignUpCode.setOnClickListener(this);
        btnGetSmsCode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //注册按钮响应操作
            case R.id.sign_up_code:{
                if (!SmsCode.equals(sCodeEditGet)&&false){
                    Toast.makeText(this,"验证码错误",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this,"验证码正确",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, SignUpPasswordActivity.class);
                    intent.putExtra("Tel",sNameEditGet);
                    startActivity(intent);
                    finish();
                }
                break;
            }
            case R.id.sign_up_btn_get_sms_code_cd: {
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