package yang.shuai.ysandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * 　┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 * 作者：杨帅
 * 日期：2019/6/14 16:00
 * 邮箱：57125827@qq.com
 **/
public class TestView extends ViewGroup {
    public TestView(Context context) {
        this(context,null);
    }

    public TestView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Log.w("测试","构造方法");
    }
    /**
     * 当view及其子view从xml文件中甲在完成后被调用
     * */
    @Override
    protected void onFinishInflate() {
        Log.w("测试","onFinishInflate");
        super.onFinishInflate();
    }
    /**
     * 该方法在计算当前View及其所有子View尺寸大小需求时会被调用。
     * */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.w("测试","onMeasure");
        super.onMeasure(widthMeasureSpec,heightMeasureSpec);
    }

    /**
     * 该方法在当前View需要为其子View分配尺寸和位置时会被调用。
     * */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        Log.w("测试","onLayout");
        for(int i = 0;i<getChildCount();i++){
            View view = getChildAt(i);
            view.layout(left,top,left+100,top+100);
            left += 100+20;
        }
    }

    /**
     * 该方法在当前View尺寸变化时被调用。
     * */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.w("测试","onSizeChanged");
        super.onSizeChanged(w, h, oldw, oldh);
    }
    /**
     * 该方法在当前View需要呈现其内容时被调用。
     * */
    @Override
    protected void onDraw(Canvas canvas) {
        Log.w("测试","onDraw");
        super.onDraw(canvas);
    }
    /**
     * 该方法在一个物理按键事件发生时被调用。
     * */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.w("测试","onKeyDown");
        return super.onKeyDown(keyCode, event);
    }
    /**
     * 该方法在一个物理按键弹起事件发生时被调用。
     * */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.w("测试","onKeyUp");
        return super.onKeyUp(keyCode, event);
    }
    /**
     * 该方法在一个轨迹球运动事件发生时被调用。
     * */
    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        Log.w("测试","onTrackballEvent");
        return super.onTrackballEvent(event);
    }
    /**
     * 该方法在一个触摸屏幕运动事件发生时被调用。
     * */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.w("测试","onTouchEvent");
        return super.onTouchEvent(event);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.w("测试","dispatchTouchEvent ==> view");
        return super.dispatchTouchEvent(event);
    }

    /**
     * 该方法在当前View获得或失去焦点时被调用。
     * */
    @Override
    protected void onFocusChanged(boolean gainFocus, int direction, @Nullable Rect previouslyFocusedRect) {
        Log.w("测试","onFocusChanged");
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
    }
    /**
     * 该方法在包含当前View的window获得或失去焦点时被调用。
     * */
    @Override
    public void onWindowFocusChanged(boolean hasWindowFocus) {
        Log.w("测试","onWindowFocusChanged");
        super.onWindowFocusChanged(hasWindowFocus);
    }
    /**
     * 该方法在当前View被附到一个window上时被调用。
     * */
    @Override
    protected void onAttachedToWindow() {
        Log.w("测试","onAttachedToWindow");
        super.onAttachedToWindow();
    }
    /**
     * 该方法在当前View从一个window上分离时被调用。
     * */
    @Override
    protected void onDetachedFromWindow() {
        Log.w("测试","onDetachedFromWindow");
        super.onDetachedFromWindow();
    }



    /**
     * 该方法在当前View或其祖先的可见性改变时被调用。
     * */
    @Override
    protected void onVisibilityChanged(@NonNull View changedView, int visibility) {
        Log.w("测试","onVisibilityChanged");
        super.onVisibilityChanged(changedView, visibility);
    }
    /**
     * 该方法在包含当前View的window可见性改变时被调用。
     * */
    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        Log.w("测试","onWindowVisibilityChanged");
        super.onWindowVisibilityChanged(visibility);
    }

}
