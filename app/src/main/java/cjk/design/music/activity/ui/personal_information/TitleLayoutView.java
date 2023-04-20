package cjk.design.music.activity.ui.personal_information;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import cjk.design.music.R;


/**
 *
 * @description 标题栏
 * @author guoxiaozhe
 * @time 2021/11/30 9:17
 * @email 1041347917@qq.com
 *
 */
public class TitleLayoutView extends LinearLayout {
    private ImageView ivBackward;
    private TextView tvTitle, tvForward;

    public TitleLayoutView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LinearLayout barTitle = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.bar_title_layout, this);
        ivBackward = (ImageView) barTitle.findViewById(R.id.bar_title_backward_iv);
        tvTitle = (TextView) barTitle.findViewById(R.id.bar_title_title_text);
        tvForward = (TextView) barTitle.findViewById(R.id.bar_title_forward_text);
        //根据不同界面，初始化标题栏
//        if(ActivityCollector.getCurrentActivity().getClass().equals(PersonInfoActivity.class)){
//            tvForward.setText("保存");
//            tvTitle.setText("编辑资料");
//        }
//        if(ActivityCollector.getCurrentActivity().getClass().equals(MyInfoActivity.class)){
//            tvForward.setText("保存");
//            tvTitle.setText("个人信息");
//        }
//        if(ActivityCollector.getCurrentActivity().getClass().equals(EditHighActivity.class)){
//            tvForward.setText("完成");
//            tvTitle.setText("编辑身高");
//        }
//        if(ActivityCollector.getCurrentActivity().getClass().equals(EditNameActivity.class)){
//            tvForward.setText("完成");
//            tvTitle.setText("编辑昵称");
//        }
//        if(ActivityCollector.getCurrentActivity().getClass().equals(EditWeighActivity.class)){
//            tvForward.setText("完成");
//            tvTitle.setText("编辑体重");
//        }

        /**
         *
         * @description  设置监听器，如果点击back则结束活动
         * @return void
         * @author 86186
         * @time 2021/11/30 9:14
         *
         */
        ivBackward.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity)getContext()).finish();
            }
        });
    }
    public TextView getTextViewForward(){
        return tvForward;
    }
}
