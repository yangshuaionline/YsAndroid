package yang.shuai.ys_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import yang.shuai.ys_java.adapter.JavaMainAdapter;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class JavaMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_main);
        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        List<String> list = new ArrayList<>();
        list.add("时钟");
        list.add("爱心");
        list.add("选择菜单");
        rv.setLayoutManager(manager);
        rv.setAdapter(new JavaMainAdapter(this,list));
    }
}
