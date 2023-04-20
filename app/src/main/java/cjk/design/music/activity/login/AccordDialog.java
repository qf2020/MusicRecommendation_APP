package cjk.design.music.activity.login;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import cjk.design.music.R;

/**
 * @author: cjk
 * @date: 2021/12/13
 * @func:
 * @para:
 * @return:
 */
public class AccordDialog extends Dialog {
    TextView  accordLogin;

    public AccordDialog(@NonNull Context context,String accord) {
        super(context, R.style.MyDialog);
        setMsgDialog(accord);
    }

    private void setMsgDialog(String accord) {
        View mView = LayoutInflater.from(getContext()).inflate(R.layout.dialog_accord, null);
        accordLogin= (TextView) mView.findViewById(R.id.accord_login);
        accordLogin.setText(accord);
        super.setContentView(mView);
        getWindow().setLayout(1000,1000);

    }

}
