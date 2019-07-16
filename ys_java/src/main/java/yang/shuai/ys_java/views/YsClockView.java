package yang.shuai.ys_java.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
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
 * 日期：2019/5/31 17:02
 * 邮箱：57125827@qq.com
 **/
public class YsClockView extends View {
    private Paint mPaint;//通用的刷子
    private int mProgressSecond = 0;//秒进度
    private int mProgressMin = 0;//分进度
    private int mProgressHour = 0;//时进度
    private int mCircleWidth = 5;//圆环的宽度
    private boolean isChange = false;
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

    private void setInit(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE); // 设置空心
        mPaint.setStrokeCap(Paint.Cap.ROUND);//作用于圆环结尾（圆润）
        mPaint.setColor(getContext().getResources().getColor(android.R.color.black));
        mPaint.setStrokeWidth(mCircleWidth); // 设置圆环的宽度
        mPaint.setAntiAlias(true); // 消除锯齿
        mPaint.setTextSize(dip2px(getContext(),30));//设置字体
        mPaint.setTextAlign(Paint.Align.CENTER);//设置居中
        // 绘图线程
        new Thread() {
            public void run() {
                while (true) {
                    //设置指针联动
                    mProgressSecond +=6;//秒针每秒跳动6度
                    if(mProgressSecond%60 == 0){
                        mProgressMin +=1;//秒针每转60度分针跳动1度
                        if(mProgressMin!=0&&mProgressMin%12 == 0){
                            mProgressHour += 1;//分针每转12度时针跳动1度
                        }
                    }
                    //设置指针重置
                    if(mProgressSecond == 360) mProgressSecond = 0;
                    if(mProgressMin == 360) mProgressMin = 0;
                    if(mProgressHour == 360)  mProgressHour = 0;
                    isChange = !isChange;
                    postInvalidate();//刷新view
                    try {
                        Thread.sleep(1000);//每秒循环一次
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    //根据传过来的时分秒，来确定时分秒针的角度
    public void setTime(int hour,int min,int second){
        if(hour>12) hour -=12;
        this.mProgressHour = 30*hour;
        this.mProgressMin = 6*min;
        this.mProgressSecond = 6*second;
    }
    @Override
    protected void onDraw(Canvas canvas) {
        int centre = getWidth() / 2; // 获取圆心的x坐标
        int radius = centre - mCircleWidth / 2;// 半径减去圆环宽度的一半
        //圆心的xy坐标
        float xCenter = centre;
        float yCenter = centre;
        mPaint.setStyle(Paint.Style.STROKE);// 共用一个刷子，需要每次都先设置实心
        /**
         * 画表盘背景色
         * */
        //渐变的颜色顺序
        int[] colors;
        float[] stops; //每个颜色结束的位置，中间为渐变
        if(isChange){
            colors= new int[]{
                    getResources().getColor(R.color.back_ground),
                    getResources().getColor(R.color.progress),
                    getResources().getColor(R.color.back_ground),
                    getResources().getColor(R.color.progress),
                    getResources().getColor(R.color.back_ground),
                    getResources().getColor(R.color.progress),
                    getResources().getColor(R.color.back_ground),
                    getResources().getColor(R.color.progress),
                    getResources().getColor(R.color.back_ground),
                    getResources().getColor(R.color.progress)
            };
            stops = new float[]{0f, 0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f};
        }else{
            colors= new int[]{
                    getResources().getColor(R.color.back_ground),
                    getResources().getColor(R.color.progress),
                    getResources().getColor(R.color.back_ground),
                    getResources().getColor(R.color.progress),
                    getResources().getColor(R.color.back_ground),
                    getResources().getColor(R.color.progress),
                    getResources().getColor(R.color.back_ground),
                    getResources().getColor(R.color.progress),
                    getResources().getColor(R.color.back_ground),
                    getResources().getColor(R.color.progress)
            };
            stops = new float[]{0.1f, 0.2f, 0.3f, 0.4f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f,1.0f};
        }
        LinearGradient gradient =
                new LinearGradient(
                        0,//着色器开始的x坐标
                        0,//着色器开始的y坐标
                        getWidth(),//着色器结束的x坐标
                        getHeight(),//着色器结束的y坐标
                        colors,//着色器的颜色集
                        stops,//着色器的颜色定位集
                        Shader.TileMode.CLAMP//明暗平衡模式
                );
        mPaint.setShader(gradient);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(centre, centre, radius, mPaint); // 画出圆环(实心)
        /**
         * 画表框
         * */
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setShader(null);
        mPaint.setColor(getResources().getColor(R.color.back_ground)); // 设置圆环的颜色
        canvas.drawCircle(centre, centre, radius, mPaint); // 画出圆环（空心圆）
        /**
         * 画时针
         * */
        mPaint.setColor(getResources().getColor(R.color.hour_color)); // 设置时针的颜色
        int progressHour = getProgress(mProgressHour);//计算出来时针的真实角度
        int lengthHour = radius/4;//时针长度
        //时针的终点坐标
        float xHour   = (float) (xCenter + lengthHour * cos(progressHour * 3.14 /180));
        float yHour   = (float) (yCenter + lengthHour * sin(progressHour * 3.14 /180));
        canvas.drawLine(xCenter,yCenter, xHour,yHour, mPaint);
        /**
         * 画分针
         * */
        mPaint.setColor(getResources().getColor(R.color.min_color)); // 设置分针的颜色
        int progressMin = getProgress(mProgressMin);//计算出来分针的真实角度
        int lengthMin = radius/3;//分针长度
        //分针的终点坐标
        float xMin   = (float) (xCenter + lengthMin * cos(progressMin * 3.14 /180));
        float yMin   = (float) (yCenter + lengthMin * sin(progressMin * 3.14 /180));
        canvas.drawLine(xCenter,yCenter, xMin,yMin, mPaint);
        /**
         * 画秒针
         * */
        mPaint.setColor(getResources().getColor(R.color.second_color)); // 设置秒针的颜色
        int progressSecond = getProgress(mProgressSecond);//计算出来秒针的真实角度
        int lengthSecond = radius/2;//秒针长度
        //秒针的终点坐标
        float xSecond   = (float) (xCenter + lengthSecond * cos(progressSecond * 3.14 /180));
        float ySecond   = (float) (yCenter + lengthSecond * sin(progressSecond * 3.14 /180));
        canvas.drawLine(xCenter,yCenter, xSecond,ySecond, mPaint);
        /**
         * 画刻度
         * */
        mPaint.setColor(getResources().getColor(R.color.back_ground)); // 设置刻度的颜色
        //十二个刻度
        for(int i = 0;i<12;i++){
            int start;//刻度开始的位置，0、3、6、9比较长，需要单独计算
            int end = radius;//刻度结束的位置为圆弧的终点
            if(i%3 == 0){//0、3、6、9
                start = radius/6*5;
            }else{
                start = radius/20*19;
            }
            int a = i*30;//每个刻度的实际角度
            //开始结束点的XY坐标点
            float xStart   = (float) (xCenter + start * cos(a * 3.14 /180 ));
            float yStart   = (float) (yCenter + start * sin(a * 3.14 /180 ));
            float xEnd   = (float) (xCenter + end * cos(a * 3.14 /180 ));
            float yEnd   = (float) (yCenter + end * sin(a * 3.14 /180 ));
            canvas.drawLine(xStart,yStart, xEnd,yEnd, mPaint);
            /**
             * 绘制数字
             * */
            int radiusNum = radius/3*2;//数字所占的圆弧的半径
            float xNum = (float) (xCenter + radiusNum * cos(a * 3.14 /180 ));
            float yNum = (float) (yCenter + radiusNum * sin(a * 3.14 /180 ));
            //获取text绘制区域顶部以及底部的拓展值，该拓展值是相对给定坐标的坐标。
            float textTop = mPaint.getFontMetrics().top;
            float textBottom = mPaint.getFontMetrics().bottom;
            int num;//计算显示的数字
            if(i<10){
                num = i+3;
            }else{
                num = i-9;
            }
            if(i%3 == 0) {//0、3、6、9
                mPaint.setColor(getResources().getColor(android.R.color.black));
                canvas.drawText(String.valueOf(num),xNum,yNum-(textTop+textBottom)/2, mPaint);
            }

        }
    }
    /**
     * 计算指针的真实角度（默认0度不在正上方）
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

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
