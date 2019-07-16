package yang.shuai.ysandroid.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import yang.shuai.ysandroid.R;
import yang.shuai.ysandroid.adapter.MainAdapter;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        List<String> list = new ArrayList<>();
        list.add("Flutter项目");
        list.add("Java项目");
        list.add("Kotlin项目");
        rv.setLayoutManager(manager);
        rv.setAdapter(new MainAdapter(this,list));
    }
}
