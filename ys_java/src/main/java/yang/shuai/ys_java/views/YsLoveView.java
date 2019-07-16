package yang.shuai.ys_java.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Shader;
import android.provider.CalendarContract;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import yang.shuai.ys_java.R;

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
 * 日期：2019/7/1 11:40
 * 邮箱：57125827@qq.com
 **/
public class YsLoveView extends View {
    public YsLoveView(Context context) {
        this(context,null);
    }

    public YsLoveView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public YsLoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setInit();
    }

    public YsLoveView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setInit();
    }
    private Paint paint;
    private ValueAnimator av;
    private float mLength;
    private PathMeasure pm;
    private Path mPath;
    private void setInit(){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(7);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                    if(m <= 1){//放大
                        isAdd = true;
                    }else if(m >= 3){//缩小
                        isAdd = false;
                    }
                    if(isAdd){
                        m += 0.01f;
                    }  else {
                        m -= 0.01f;
                    }
                    invalidate();
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    float m = 1;
    boolean isAdd = false;
    float n = 5;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setShader(null);
        paint.setColor(Color.YELLOW);
        float width = getWidth();
        float height = getHeight();
        n = 5;
        float x = width/2;
        float x1 = width/2 + 0.35f*width*n;
        float x2 = width/2 + 0.42f*width*n;
        float x3 = width/2 ;
        float y = height/2 - 0.25f*width*n;
        float y1 = height/2 - 0.38f*width*n;
        float y2 = height/2;
        float y3 = height/2 + 0.38f*width*n;
        float startX1 = x1;
        float startX2 = x2;
        float startX3 = x3;
        float startY = y;
        float startY1 = y1;
        float startY2 = y2;
        float startY3 = y3;
        /**
         * 结束位置
         * */
        n = 1;
        x = width/2;
        x1 = width/2 + 0.35f*width*n;
        x2 = width/2 + 0.42f*width*n;
        x3 = width/2 ;
        y = height/2 - 0.25f*width*n;
        y1 = height/2 - 0.38f*width*n;
        y2 = height/2;
        y3 = height/2 + 0.38f*width*n;
        float endX1 = x1;
        float endX2 = x2;
        float endX3 = x3;
        float endY = y;
        float endY1 = y1;
        float endY2 = y2;
        float endY3 = y3;
        int num= 100;
        for(int i = 0;i<=num;i++){
            float b = i*360/num;
            canvas.drawLine(
                    threebsr(b/360f,x,startX1,startX2,startX3),
                    threebsr(b/360f,startY,startY1,startY2,startY3),
                    threebsr(b/360f,x,endX1,endX2,endX3),
                    threebsr(b/360f,endY,endY1,endY2,endY3),
                    paint);
        }
        n = 5;
//        x1 = width - width*6 / 7;
        x1 = width/2 - 0.35f*width*n;
//        x2 = width - width*12 / 13;
        x2 = width/2 - 0.42f*width*n;
        x3 = width / 2;
        y = height/2 - 0.25f*width*n;
//        float y1 = height - height*8/9*n;
        y1 = height/2 - 0.38f*width*n;
//        float y2 = height - height*3/5*n;
        y2 = height/2;
        y3 = height/2 + 0.38f*width*n;
        startX1 = x1;
        startX2 = x2;
        startX3 = x3;
        startY = y;
        startY1 = y1;
        startY2 = y2;
        startY3 = y3;
        /**
         * 结束位置
         * */
        n = 1;
        x1 = width/2 - 0.35f*width*n;
//        x2 = width - width*12 / 13;
        x2 = width/2 - 0.42f*width*n;
        x3 = width / 2;
//        float y = height - height*3/4*n;
        y = height/2 - 0.25f*width*n;
//        float y1 = height - height*8/9*n;
        y1 = height/2 - 0.38f*width*n;
//        float y2 = height - height*3/5*n;
        y2 = height/2;
        y3 = height/2 + 0.38f*width*n;
        endX1 = x1;
        endX2 = x2;
        endX3 = x3;
        endY = y;
        endY1 = y1;
        endY2 = y2;
        endY3 = y3;
        for(int i = 0;i<=num;i++){
            float b = i*360/num;
            canvas.drawLine(
                    threebsr(b/360f,x,startX1,startX2,startX3),
                    threebsr(b/360f,startY,startY1,startY2,startY3),
                    threebsr(b/360f,x,endX1,endX2,endX3),
                    threebsr(b/360f,endY,endY1,endY2,endY3),
                    paint);
        }
        setDot(canvas,Color.RED,-2.7f);
        setDot(canvas,Color.GREEN,-2.4f);
        setDot(canvas,Color.BLACK,-2.1f);
        setDot(canvas,getResources().getColor(R.color.pink),-1.8f);
        setDot(canvas,Color.BLACK,-1.5f);
        setDot(canvas,Color.GREEN,-1.2f);
        setDot(canvas,Color.RED,-0.9f);
        setDot(canvas,Color.GREEN,-0.6f);
        setDot(canvas,Color.BLACK,-0.3f);
        setDot(canvas,getResources().getColor(R.color.pink),0);
        setDot(canvas,Color.BLACK,0.3f);
        setDot(canvas,Color.GREEN,0.6f);
        setDot(canvas,Color.RED,0.9f);
//        setDot(canvas,Color.GREEN,1.2f);
//        setDot(canvas,Color.BLACK,1.5f);
//        setDot(canvas,getResources().getColor(R.color.pink),2.1f);
    }

    private void setDot(Canvas canvas,int color,float o){
        paint.setColor(color);
        if(m <=1){
            n = 1;
        }else n = m-o;
        int num = 100;
        float width = getWidth();
        float height = getHeight();
        float x = width/2;
        float x1 = width/2 + 0.35f*width*n;
        float x2 = width/2 + 0.42f*width*n;
        float x3 = width/2 ;
        float y = height/2 - 0.25f*width*n;
        float y1 = height/2 - 0.38f*width*n;
        float y2 = height/2;
        float y3 = height/2 + 0.38f*width*n;
        float endX1 = x1;
        float endX2 = x2;
        float endX3 = x3;
        float endY = y;
        float endY1 = y1;
        float endY2 = y2;
        float endY3 = y3;
        for(int i = 0;i<=num;i++){
            float b = i*360/num;
            canvas.drawCircle(
                    threebsr(b/360f,x,endX1,endX2,endX3),
                    threebsr(b/360f,endY,endY1,endY2,endY3),
                    5,paint);
        }

        x1 = width/2 - 0.35f*width*n;
//        x2 = width - width*12 / 13;
        x2 = width/2 - 0.42f*width*n;
        x3 = width / 2;
//        float y = height - height*3/4*n;
        y = height/2 - 0.25f*width*n;
//        float y1 = height - height*8/9*n;
        y1 = height/2 - 0.38f*width*n;
//        float y2 = height - height*3/5*n;
        y2 = height/2;
        y3 = height/2 + 0.38f*width*n;
        endX1 = x1;
        endX2 = x2;
        endX3 = x3;
        endY = y;
        endY1 = y1;
        endY2 = y2;
        endY3 = y3;
        for(int i = 0;i<=num;i++){
            float b = i*360/num;
            canvas.drawCircle(
                    threebsr(b/360f,x,endX1,endX2,endX3),
                    threebsr(b/360f,endY,endY1,endY2,endY3),
                    5,paint);
        }
    }
    // t是百分比，a是参数

    // 1阶贝塞尔曲线公式
    private float onebsr(float t, float a1, float a2) {
        return a1 + (a2 - a1) * t;
    }

    // 2阶贝塞尔曲线公式
    private float twobsr(float t, float a1, float a2,float a3) {
        return ((1 - t) * (1 - t)) * a1 + 2 * t * (1 - t) * a2 + t * t * a3;
    }

    // 3阶贝塞尔曲线公式
    private float threebsr(float t, float a1, float a2,float a3,float a4) {
        return a1 * (1 - t) * (1 - t) * (1 - t) + 3 * a2 * t * (1 - t) * (1 - t) + 3 * a3 * t * t * (1 - t) + a4 * t * t * t;
    }
    /**
     * 返回外围圆圈的坐标
     * */
    private float getXY(float center ,float radius, float progress){
        return (float) (center + radius * cos(progress * 3.14 /180));
    }
    /**
     * 返回外围圆圈的坐标
     * */
    private float getYX(float center ,float radius, float progress){
        return (float) (center + radius * sin(progress * 3.14 /180));
    }
    /**
     * 计算指针的真实角度（默认0度不在正上方）
     * */
    private int getProgress(int progress){
        return progress<0?progress+270:progress-90;
    }
}
