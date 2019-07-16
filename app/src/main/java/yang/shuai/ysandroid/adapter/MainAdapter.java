package yang.shuai.ysandroid.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import yang.shuai.ys_java.JavaMainActivity;
import yang.shuai.ys_kotlin.KotlinMainActivity;
import yang.shuai.ysandroid.activity.FlutterMainActivity;
import yang.shuai.ysandroid.R;

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
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainHolder> {
    private Context context;
    private List<String> list;

    public MainAdapter(Context context,List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MainHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_main,parent,false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainHolder holder, int position) {
        TextView textView = holder.textView;
        textView.setText(list.get(position));
        textView.setOnClickListener(view ->{
            switch (position){
                case 0://Flutter
                    context.startActivity(new Intent(context, FlutterMainActivity.class));
                    break;
                case 1://Java
                    context.startActivity(new Intent(context, JavaMainActivity.class));
                    break;
                case 2://Kotlin
                    context.startActivity(new Intent(context, KotlinMainActivity.class));
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
