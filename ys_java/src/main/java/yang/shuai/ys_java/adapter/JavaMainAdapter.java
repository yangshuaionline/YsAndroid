package yang.shuai.ys_java.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import yang.shuai.ys_java.R;
import yang.shuai.ys_java.activity.YsClockMainActivity;
import yang.shuai.ys_java.activity.YsLoveMainActivity;
import yang.shuai.ys_java.activity.YsSelectTabMainActivity;

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
 * 日期：2019/6/13 15:44
 * 邮箱：57125827@qq.com
 **/
public class JavaMainAdapter extends RecyclerView.Adapter<JavaMainAdapter.MainHolder> {
    private Context context;
    private List<String> list = null;

    public JavaMainAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_java_main,parent,false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        TextView textView = holder.textView;
        textView.setText(list.get(position));
        textView.setOnClickListener(view ->{
            switch (position){
                case 0://时钟
                    context.startActivity(new Intent(context, YsClockMainActivity.class));
                    break;
                case 1://爱心
                    context.startActivity(new Intent(context, YsLoveMainActivity.class));
                    break;
                case 2://选择菜单
                    context.startActivity(new Intent(context, YsSelectTabMainActivity.class));
                    break;
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MainHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MainHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }
}
