package yang.shuai.ys_java.activity;

import androidx.appcompat.app.AppCompatActivity;
import yang.shuai.ys_java.R;
import yang.shuai.ys_java.views.YsLoveView;

import android.os.Bundle;

public class YsLoveMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ys_love_main);
        YsLoveView ysLoveView = findViewById(R.id.ysLoveView);
    }
}
