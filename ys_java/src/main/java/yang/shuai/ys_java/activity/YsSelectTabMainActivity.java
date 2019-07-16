package yang.shuai.ys_java.activity;

import androidx.appcompat.app.AppCompatActivity;
import yang.shuai.ys_java.R;
import yang.shuai.ys_java.views.YsSelectTab;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class YsSelectTabMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ys_select_tab_main);
        YsSelectTab selectTab = findViewById(R.id.ysSelectTab);
        List<String> list = new ArrayList<>();
        list.add("淡");
        list.add("中");
        list.add("浓");
        selectTab.setList(list);
        selectTab.setColor(R.color.golden);
    }
}
