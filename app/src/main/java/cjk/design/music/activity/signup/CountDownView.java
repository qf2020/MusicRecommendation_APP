package cjk.design.music.activity.signup;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

import java.util.Locale;

/**
 * @description 用于显示倒计时现象的View
 * @author cjk
 * @time 2021/11/29 22:25
 */
public class CountDownView extends AppCompatTextView {

    public CountDownView(Context context) {
        super(context);
    }

    public CountDownView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private static final int COUNT_DOWN_SECONDS = 60; //倒计时60s

    private static final int COUNT_DOWN_INTERVAL_SECONDS = 1; //每次倒计时多少秒

    private CountDownTimer mCountDownTimer = new CountDownTimer(COUNT_DOWN_SECONDS * 1000L,
            COUNT_DOWN_INTERVAL_SECONDS * 1000L) {
        @Override
        public void onTick(long millisUntilFinished) {
            setText(String.format(Locale.getDefault(), "%ds", millisUntilFinished / 1000));
        }

        @Override
        public void onFinish() {
            setText("重新获取");
            setEnabled(true);
        }
    };

    /**
     * @description 开启倒计时
     * @author cjk
     * @time 2021/11/29 22:27
     */
    public void start() {
        mCountDownTimer.start();
        setEnabled(false);
    }

    public void cancel() {
        mCountDownTimer.cancel();
    }

}

