package yang.shuai.ysclock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

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
 * 日期：2019/5/31 17:02
 * 邮箱：57125827@qq.com
 **/
public class YsClockView extends View {
    public YsClockView(Context context) {
        this(context,null);
    }

    public YsClockView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public YsClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setInit();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public YsClockView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setInit();
    }
    Paint mPaint;
    private void setInit(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(10);
            mPaint.setStrokeCap(Paint.Cap.ROUND);//作用于圆环结尾
            mPaint.setColor(getContext().getColor(android.R.color.black));
        }
        p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setStyle(Paint.Style.FILL);
        p.setColor(getContext().getResources().getColor(android.R.color.black));
        p.setTextSize(100);
        p.setTextAlign(Paint.Align.CENTER);
        // 绘图线程
        new Thread() {
            public void run() {
                while (true) {
                    mProgressSecond +=6;//每次一秒
                    if (mProgressSecond == 360) {
                        mProgressSecond = 0;
                        mProgressMin +=6;
                        if(mProgressMin == 360){
                            mProgressMin = 0;
                            mProgressHour += 30;
                        }
                        if (!isNext)
                            isNext = true;
                        else
                            isNext = false;
                    }
                    postInvalidate();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
    int mProgressSecond = 0;
    int mProgressMin = 0;
    int mProgressHour = 0;
    boolean isNext;
    int mCircleWidth = 50;
    Paint p;
    //定时间
    public void setTime(int hour,int min,int second){
        if(hour>12) hour -=12;
        this.mProgressHour = 30*hour;
        this.mProgressMin = 6*min;
        this.mProgressSecond = 6*second;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        int centre = getWidth() / 2; // 获取圆心的x坐标
        int radius = centre - mCircleWidth / 2;// 半径
        mPaint.setStrokeWidth(mCircleWidth); // 设置圆环的宽度
        mPaint.setAntiAlias(true); // 消除锯齿
        mPaint.setStyle(Paint.Style.STROKE); // 设置空心
        /**
         * 画表框
         * */
        RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius); // 用于定义的圆弧的形状和大小的界限
        if (!isNext) {// 第一颜色的圈完整，第二颜色跑
            mPaint.setColor(getResources().getColor(R.color.back_ground)); // 设置圆环的颜色
            canvas.drawCircle(centre, centre, radius, mPaint); // 画出圆环
            mPaint.setColor(getResources().getColor(android.R.color.black)); // 设置圆环的颜色
            canvas.drawArc(oval, -90, mProgressSecond, false, mPaint); // 根据进度画圆弧
        } else {
            mPaint.setColor(getResources().getColor(android.R.color.black)); // 设置圆环的颜色
            canvas.drawCircle(centre, centre, radius, mPaint); // 画出圆环
            mPaint.setColor(getResources().getColor(R.color.back_ground)); // 设置圆环的颜色
            canvas.drawArc(oval, -90, mProgressSecond, false, mPaint); // 根据进度画圆弧
        }
        float x0 = centre;
        float y0 = centre;
        /**
         * 画时针
         * */
        mPaint.setColor(getResources().getColor(R.color.hour_color)); // 设置时针的颜色
        int progressHour = getProgress(mProgressHour);
        float x1Hour   = (float) (x0   +   radius/4  *   cos(progressHour   *   3.14   /180   ));
        float y1Hour   = (float) (y0   +   radius/4   *   sin(progressHour   *   3.14   /180   ));
        canvas.drawLine(x0,y0, x1Hour,y1Hour, mPaint);
        /**
         * 画分针
         * */
        mPaint.setColor(getResources().getColor(R.color.min_color)); // 设置分针的颜色
        int progressMin = getProgress(mProgressMin);
        float x1Min   = (float) (x0   +   radius/3   *   cos(progressMin   *   3.14   /180   ));
        float y1Min   = (float) (y0   +   radius/3   *   sin(progressMin   *   3.14   /180   ));
        canvas.drawLine(x0,y0, x1Min,y1Min, mPaint);
        /**
         * 画秒针
         * */
        mPaint.setColor(getResources().getColor(R.color.second_color)); // 设置秒针的颜色
        int progressSecond = getProgress(mProgressSecond);
        float x1   = (float) (x0   +   radius/2   *   cos(progressSecond   *   3.14   /180   ));
        float y1   = (float) (y0   +   radius/2   *   sin(progressSecond   *   3.14   /180   ));
        canvas.drawLine(x0,y0, x1,y1, mPaint);
        /**
         * 画刻度
         * */
        mPaint.setColor(getResources().getColor(R.color.back_ground)); // 设置秒针的颜色
        for(int i = 0;i<12;i++){
            //整点刻度
            int start;
            int end = 10;
            if(i%3 == 0){
                start = 6;
            }else{
                start = 9;
            }
            int a = i*30;
            float xx   = (float) (x0   +   (radius-radius/start)   *   cos(a   *   3.14   /180   ));
            float yy   = (float) (y0   +   (radius-radius/start)   *   sin(a   *   3.14   /180   ));
            float xxx   = (float) (x0   +   (radius-radius/end)   *   cos(a   *   3.14   /180   ));
            float yyy   = (float) (y0   +   (radius-radius/end)   *   sin(a   *   3.14   /180   ));
            canvas.drawLine(xx,yy, xxx,yyy, mPaint);
            //绘制数字
            float xxxx   = (float) (x0   +   (radius-radius/3)   *   cos(a   *   3.14   /180   ));
            float yyyy   = (float) (y0   +   (radius-radius/3)   *   sin(a   *   3.14   /180   ));
            int num;
            if(i<10){
                num = i+3;
            }else{
                num = i-9;
            }
            canvas.drawText(String.valueOf(num),xxxx,yyyy+30,p);
        }

    }
    /**
     * 计算指针的角度
     * */
    private int getProgress(int progress){
        return progress<0?progress+270:progress-90;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
