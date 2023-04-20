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
import cjk.design.music.activity.login.LoginActivity;
import cjk.design.music.activity.service.RegisterManager;


public class SignUpPasswordActivity extends AppCompatActivity implements  View.OnClickListener{

    private final RegisterManager uRegister = new RegisterManager();
    String sPassEditGet="",sPassEditConfirmGet="";
    TextView buttonSignUpPass;
    EditText SignUpPass,SignUpPassConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_password);

        buttonSignUpPass = findViewById(R.id.sign_up_password_enter);
        SignUpPass = findViewById(R.id.sign_up_passwd);
        SignUpPassConfirm = findViewById(R.id.sign_up_confirm_pass);
        SignUpPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sPassEditGet = SignUpPass.getText().toString();
            }
        });

        SignUpPassConfirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                sPassEditConfirmGet = SignUpPassConfirm.getText().toString();
            }
        });


        buttonSignUpPass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //注册按钮响应操作
            case R.id.sign_up_password_enter:{
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
                    Toast.makeText(this,"修改成功",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    finish();
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