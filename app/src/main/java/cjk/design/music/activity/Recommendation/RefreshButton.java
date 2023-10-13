package cjk.design.music.activity.Recommendation;

import static cjk.design.music.ScrollPicker.util.ScreenUtil.spToPx;

import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;

import cjk.design.music.R;

public class RefreshButton extends View {
    private int borderColor = Color.parseColor("#6D44B5");
    private float borderWidth = 0;
    private float borderRadius = 120;
    // 文字属性
    private String text = "点击换一批";
    private int textColor = Color.parseColor("#6D44B5");
    private float textSize = 42;
    // 旋转图标属性
    private int iconSrc = R.mipmap.refresh;
    private float iconSize = 42;
    private Bitmap iconBitmap;
    private float space4TextAndIcon = 20;

    private float degress = 0;
    private ObjectAnimator mAnimator;

    // 画笔
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public RefreshButton(Context context) {
        this(context, null);
    }
    public RefreshButton(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public RefreshButton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // 将图标资源实例化为Bitmap
        iconBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.refresh);
        iconBitmap = zoomImg(iconBitmap, iconSize, iconSize);

        // 旋转动画
        mAnimator = ObjectAnimator.ofObject(this, "degress", new FloatEvaluator(), 360, 0);
        mAnimator.setDuration(2000);
        mAnimator.setRepeatMode(ObjectAnimator.RESTART);
        mAnimator.setInterpolator(new LinearInterpolator());
        mAnimator.setRepeatCount(ObjectAnimator.INFINITE);

    }

    public Bitmap zoomImg(Bitmap bm, float newWidth, float newHeight) {
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 1、画圆角矩形
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(borderColor);
        mPaint.setStrokeWidth(borderWidth);
        canvas.drawRoundRect(new RectF(0, 0, getWidth(), getHeight()), borderRadius, borderRadius, mPaint);
        // 2、画字
        mPaint.setTextSize(textSize);
        mPaint.setColor(textColor);
        mPaint.setStyle(Paint.Style.FILL);
        float measureText = mPaint.measureText(text);
        float measureAndIcon = measureText + space4TextAndIcon + iconSize;
        float textStartX = getWidth() / 2 - measureAndIcon / 2;
        float textBaseY = getHeight() / 2 + (Math.abs(mPaint.ascent()) - mPaint.descent()) / 2;
        canvas.drawText(text, textStartX, textBaseY, mPaint);
        // 3、画刷新图标
        float iconStartX = textStartX + measureText + space4TextAndIcon;
        canvas.save();
        float centerX = iconStartX + iconSize / 2;
        int centerY = getHeight() / 2;
        canvas.rotate(degress, centerX, centerY);
        canvas.drawBitmap(iconBitmap, iconStartX, getHeight() / 2 - iconSize / 2, mPaint);
        canvas.restore();
    }
    public void start() {
        mAnimator.start();
    }
    public void stop() {
        mAnimator.cancel();
        setDegress(0);
    }
    public float getDegress() {
        return degress;
    }
    public void setDegress(float degress) {
        this.degress = degress;
        invalidate();
    }

}
