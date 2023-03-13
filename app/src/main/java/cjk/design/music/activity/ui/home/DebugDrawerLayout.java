package cjk.design.music.activity.ui.home;

import android.content.Context;
import android.util.AttributeSet;

import androidx.drawerlayout.widget.DrawerLayout;


//修复了DrawerLayout强制父布局必须为matchlayout和具体大小的导致闪退的bug
public class DebugDrawerLayout  extends DrawerLayout {
    public DebugDrawerLayout(Context context) {
        super(context);
    }

    public DebugDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DebugDrawerLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(
                MeasureSpec.getSize(heightMeasureSpec), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
