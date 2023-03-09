package cjk.design.music.ScrollPicker.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import cjk.design.music.R;
import cjk.design.music.ScrollPicker.IPickerViewOperation;
import cjk.design.music.ScrollPicker.util.ScreenUtil;

public class ScrollPickerView extends RecyclerView {
    private Runnable mSmoothScrollTask;
    private Paint mBgPaint;
    private int mItemHeight;
    private int mItemWidth;
    private int mInitialY;
    private int mFirstLineY;
    private int mSecondLineY;
    private boolean mFirstAmend;

    //构造
    public ScrollPickerView(Context context) {
        this(context, null);
    }

    public ScrollPickerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollPickerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initTask();
    }

    public void doDraw(Canvas canvas) {
        if (mItemHeight > 0) {
            int screenX = getWidth();
            int startX = screenX / 2 - mItemWidth / 2 - ScreenUtil.dpToPx(5);
            System.out.println(startX);
            int stopX = mItemWidth + startX + ScreenUtil.dpToPx(5);

            canvas.drawLine(0, mFirstLineY, 0, mSecondLineY, mBgPaint);
            canvas.drawLine(stopX, mFirstLineY, stopX, mSecondLineY, mBgPaint);
        }
    }
/*
    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
        doDraw(c);
        if (!mFirstAmend) {
            mFirstAmend = true;
            ((LinearLayoutManager) getLayoutManager()).scrollToPositionWithOffset(getItemSelectedOffset(), 0);
        }
    }
*/
    @Override
    public void onScrolled(int dx, int dy) {
        super.onScrolled(dx, dy);
        freshItemView();
    }

    private void initPaint() {
        if (mBgPaint == null) {
            mBgPaint = new Paint();
            mBgPaint.setColor(getLineColor());
            mBgPaint.setStrokeWidth(ScreenUtil.dpToPx(1f));
        }
    }


    private int getScrollYDistance() {
        LinearLayoutManager layoutManager = (LinearLayoutManager) this.getLayoutManager();
        if (layoutManager == null) {
            return 0;
        }
        int position = layoutManager.findFirstVisibleItemPosition();
        View firstVisibleChildView = layoutManager.findViewByPosition(position);
        if (firstVisibleChildView == null) {
            return 0;
        }
        int itemWidth = firstVisibleChildView.getWidth();
        System.out.println(itemWidth+"滑动里面"+firstVisibleChildView.getLeft()+"left");
        return (position) * itemWidth - firstVisibleChildView.getLeft();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_UP) {
            IPickerViewOperation operation = (IPickerViewOperation) getAdapter();
            if(operation.getCorrect()){
                processItemOffset();
            }
        }
        return super.onTouchEvent(e);
    }


    //测量方法onMeasure
    //这里修改界面大小
    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {

        //width not restricted by fatherview
        widthSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        //父视图不限制子视图，自适应大小
        heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthSpec, heightSpec);

        measureSize();

        setMeasuredDimension(mItemWidth, mItemHeight);//界面显示view大小
    }
    private void measureSize() {

        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);


        if (getChildCount() > 0) {
            if (mItemHeight == 0) {
                mItemHeight = getChildAt(0).getMeasuredHeight();
            }
            if (mItemWidth == 0) {
                //mItemWidth = getChildAt(0).getMeasuredWidth();
                mItemWidth =  displayMetrics.widthPixels;
            }

            if (mFirstLineY == 0 || mSecondLineY == 0) {
                mFirstLineY = mItemHeight * getItemSelectedOffset();
                mSecondLineY = mItemHeight * (getItemSelectedOffset() + 1);
            }
        }
    }

    private void processItemOffset() {
        mInitialY = getScrollYDistance();
        postDelayed(mSmoothScrollTask, 30);
    }

    private void initTask() {
        mSmoothScrollTask = new Runnable() {
            @Override
            public void run() {
                //System.out.println("组件宽度"+mItemWidth+"偏移"+mInitialY);
                int newY = getScrollYDistance();
                if (mInitialY != newY) {
                    mInitialY = getScrollYDistance();
                    postDelayed(mSmoothScrollTask, 30);
                } else if (mItemWidth > 0) {
                    final int offset = mInitialY % mItemWidth;//离选中区域中心的偏移量
                    if (offset == 0) {
                        return;
                    }
                    if (offset >= mItemWidth / 2) {//滚动区域超过了item高度的1/2，调整position的值
                        smoothScrollBy(mItemWidth - offset -110, 0);
                    } else if (offset < mItemWidth / 2) {
                        smoothScrollBy( -offset - 110,0);
                    }
                }
            }
        };
    }


    private int getVisibleItemNumber() {
        IPickerViewOperation operation = (IPickerViewOperation) getAdapter();
        if (operation != null) {
            return operation.getVisibleItemNumber();
        }
        return 3;
    }

    private int getItemSelectedOffset() {
        IPickerViewOperation operation = (IPickerViewOperation) getAdapter();
        if (operation != null) {
            return operation.getSelectedItemOffset();
        }
        return 1;
    }

    private int getLineColor() {
        IPickerViewOperation operation = (IPickerViewOperation) getAdapter();
        if (operation != null && operation.getLineColor() != 0) {
            return operation.getLineColor();
        }
        return getResources().getColor(R.color.white);
    }

    private void updateView(View itemView, boolean isSelected) {
        IPickerViewOperation operation = (IPickerViewOperation) getAdapter();
        if (operation != null) {
            operation.updateView(itemView, isSelected);
        }
    }

    private void freshItemView() {
        for (int i = 0; i < getChildCount(); i++) {
            float itemViewY = getChildAt(i).getLeft();
           // System.out.println(itemViewY+" "+mItemWidth+"什么情况让我看看"+i+"总个数"+getChildCount());
            updateView(getChildAt(i), -mItemWidth/3 < itemViewY && itemViewY < mItemWidth);
        }
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        initPaint();
    }

}
