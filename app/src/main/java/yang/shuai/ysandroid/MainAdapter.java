package yang.shuai.ysandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import yang.shuai.ysclock.YsClockMainActivity;
import yang.shuai.yslove.YsLoveMainActivity;

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
    private List<String> list = null;

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
                case 0://时钟
                    context.startActivity(new Intent(context, YsClockMainActivity.class));
                    break;
                case 1://爱心
                    context.startActivity(new Intent(context, YsLoveMainActivity.class));
                    break;
                case 2:
                    context.startActivity(new Intent(context,GlideTestActivity.class));
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
