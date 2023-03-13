package cjk.design.music.activity.ui.music_list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

import androidx.core.widget.NestedScrollView;

import cjk.design.music.utils.DensityUtil;


public class PlayListRecommendScrollerView extends NestedScrollView {
    private static final String TAG = "PlayListRecommendHorizontalScrollerView";

    private Context mContext;

    public PlayListRecommendScrollerView(Context context) {
        this(context, null);
    }

    public PlayListRecommendScrollerView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PlayListRecommendScrollerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    //解决横向滑动与竖向滑动之间的冲突
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //LogUtil.d(TAG, "x:" + ev.getX() + " Y:" + ev.getY());
        switch (ev.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                if (ev.getY() >= 0 && ev.getY() <= DensityUtil.dp2px(mContext, 165)) {
                    return false;
                }
                break;
        }
        return false;
    }
}
