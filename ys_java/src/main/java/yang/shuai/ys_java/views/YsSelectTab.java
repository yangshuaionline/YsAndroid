package yang.shuai.ys_java.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.provider.CalendarContract;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
 * 日期：2019/7/5 17:08
 * 邮箱：57125827@qq.com
 **/
public class YsSelectTab extends View {

    private List<String> list = new ArrayList<>();//菜单文字
    private Paint mPaint;//画笔
    private int color = R.color.golden;//颜色
    private int size;//文字大小
    private int pressNumber = 1;//选择的item
    private static final int START = 0;
    private static final int END = 1;
    private static final int MIDDLE = 2;
    private int index = 0;//记录绘制的位置
    public YsSelectTab(Context context) {
        this(context,null);
    }

    public YsSelectTab(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public YsSelectTab(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setInit();
    }

    @SuppressLint("NewApi")
    public YsSelectTab(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setInit();
    }
    private void setInit(){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);//作用于圆环结尾（圆润）
        mPaint.setColor(getContext().getResources().getColor(color));
        mPaint.setAntiAlias(true); // 消除锯齿
        mPaint.setStrokeWidth(5f);
        mPaint.setTextAlign(Paint.Align.CENTER);//设置居中
    }
    public void setList(List<String> list){
        this.list.clear();
        this.list.addAll(list);
    }

    public void setColor(int color) {
        this.color = color;
    }
    /**
     * 设置选中的位置
     * */
    public void setPressNumber(int pressNumber) {
        this.pressNumber = pressNumber;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (list.size() >= 3) {
            /**
             * 绘制图形
             * */
            int MenuSize = list.size();//菜单数量
            float widthCircle = getHeight() * 0.6f;//圆圈的宽度
            float heightCircle = getHeight() * 0.6f;//圆圈的高度
            float width = getWidth();//宽度
            float height = getHeight();//高度
            float space = (width - widthCircle * MenuSize) / MenuSize;
            for (int i = 0; i < MenuSize; i++) {
                if(i == 0) index = 0;//重置
                /**
                 * 绘制文字
                 * */
                mPaint.setStyle(Paint.Style.FILL); // 设置空心
                float textSize = (int) (height * 0.4 * 0.5);
                mPaint.setTextSize(textSize);//设置字体大小
                float widthText = getHeight() * 0.6f;
                float heightText = getHeight() * 0.4f;
                //获取text绘制区域顶部以及底部的拓展值，该拓展值是相对给定坐标的坐标。
                float textTop = mPaint.getFontMetrics().top;
                float textBottom = mPaint.getFontMetrics().bottom;
                canvas.drawText(list.get(i),
                        widthText / 2 + space / 2+index*(widthText+space),
                        height + (textBottom + textTop) / 2, mPaint);
                /**
                 * 绘制图形
                 * */
                if (pressNumber == 1) {
                    if (i == 0) {
                        myDrawGraphical(canvas, MenuSize, widthCircle, heightCircle, width, height, space, MIDDLE);
                    } else {
                        myDrawGraphical(canvas, MenuSize, widthCircle, heightCircle, width, height, space, END);
                    }
                } else if (pressNumber == MenuSize) {
                    if (i == MenuSize - 1) {
                        myDrawGraphical(canvas, MenuSize, widthCircle, heightCircle, width, height, space, MIDDLE);
                    } else {
                        myDrawGraphical(canvas, MenuSize, widthCircle, heightCircle, width, height, space, START);
                    }
                } else {
                    if (i == 0 || i < pressNumber - 1) {
                        myDrawGraphical(canvas, MenuSize, widthCircle, heightCircle, width, height, space, START);
                    } else if (i == MenuSize - 1 || i > pressNumber - 1) {
                        myDrawGraphical(canvas, MenuSize, widthCircle, heightCircle, width, height, space, END);
                    } else if (i == pressNumber - 1) {
                        myDrawGraphical(canvas, MenuSize, widthCircle, heightCircle, width, height, space, MIDDLE);
                    }
                }
            }
        }
    }
    /**
     * 画图形
     * */
    @SuppressLint("NewApi")
    private void myDrawGraphical(Canvas canvas, int MenuSize,//菜单数量
                                 float widthCircle ,//圆圈的宽度
                                 float heightCircle ,//圆圈的高度
                                 float width ,//宽度
                                 float height ,//高度
                                 float space,
                                 int type){

        if(type == START){
            mPaint.setStyle(Paint.Style.STROKE); // 设置空心
            float leftArc = space/2+index*(widthCircle+space);
            float rightArc = space/2+widthCircle+index*(widthCircle+space);
            if(index == 0){//第一个开一个口
                //画未选择的空心圆弧
                canvas.drawArc(leftArc,0,rightArc,heightCircle,
                        15f,330f,false,mPaint);
            }else{//不是第一个开两个口
                //画未选择的空心圆弧
                canvas.drawArc(leftArc,0,rightArc,heightCircle,
                        15f,150f,false,mPaint);
                //画未选择的空心圆弧
                canvas.drawArc(leftArc,0,rightArc,heightCircle,
                        195f,150f,false,mPaint);
            }

            float lineStartX = widthCircle/2+space/2+index*(widthCircle+space);
            float lineEndX = widthCircle/2+space/2+(index+1)*(widthCircle+space);
            //画线1
            canvas.drawLine(
                    getX(lineStartX,heightCircle/2,-15f),
                    getY(heightCircle/2,heightCircle/2,-15f),
                    getX(lineEndX,heightCircle/2,195f),
                    getY(heightCircle/2,heightCircle/2,195f),
                    mPaint
            );
            //画线2
            canvas.drawLine(
                    getX(lineStartX,heightCircle/2,15f),
                    getY(heightCircle/2,heightCircle/2,15f),
                    getX(lineEndX,heightCircle/2,165f),
                    getY(heightCircle/2,heightCircle/2,165f),
                    mPaint
            );
        }else if(type == END){
            mPaint.setStyle(Paint.Style.FILL); // 设置实心
            float xCircle = (widthCircle+space)*index+widthCircle/2+space/2;
            //画已选中的实心圆
            canvas.drawCircle(xCircle,heightCircle/2,heightCircle/2,mPaint);
            float left = widthCircle/2+space/2+(widthCircle+space)*(index-1);
            float right = widthCircle/2+space/2+(widthCircle+space)*(index);
            //画方块
            canvas.drawRect(
                    getX(left,heightCircle/2,-15f),
                    getY(heightCircle/2,heightCircle/2,-15f),
                    getX(right,heightCircle/2,195f),
                    getY(heightCircle/2,heightCircle/2,15f),
                    mPaint
            );
        }else if(type == MIDDLE){
            mPaint.setStyle(Paint.Style.STROKE); // 设置空心
            float xCircle = (widthCircle+space)*index+widthCircle/2+space/2;
            //画正在选择的圆环
            canvas.drawCircle(xCircle,heightCircle/2,heightCircle/2,mPaint);
            //画圆环中间的图片
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher);
            RectF rectF = new RectF();
            rectF.left = xCircle-widthCircle/3;
            rectF.right = xCircle+widthCircle/3;
            rectF.top = heightCircle/2-heightCircle/3;
            rectF.bottom = heightCircle/2+heightCircle/3;
            canvas.drawBitmap(bitmap,null,rectF,mPaint);
        }
        index++;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x;
        float y;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_UP:
                x = event.getX();
                y = event.getY();
                int MenuSize = list.size();//菜单数量
                float widthCircle = getHeight() * 0.6f;//圆圈的宽度
                float heightCircle = getHeight() * 0.6f;//圆圈的高度
                float width = getWidth();//宽度
                float height = getHeight();//高度
                float space = (width - widthCircle * MenuSize) / MenuSize;
                int pressNumber = (int) (x/(widthCircle+space))+1;//获取点击的是第几份
                setPressNumber(pressNumber);
                break;
        }
        return true;
    }

    /**
     * 返回外围圆圈的坐标
     * */
    private float getX(float center ,float radius, float progress){
        return (float) (center + radius * cos(progress * 3.14 /180));
    }
    /**
     * 返回外围圆圈的坐标
     * */
    private float getY(float center ,float radius, float progress){
        return (float) (center + radius * sin(progress * 3.14 /180));
    }
}
