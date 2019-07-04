package yang.shuai.yslove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class YsLoveMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ys_love_main);
        YsLoveView ysLoveView = findViewById(R.id.ysLoveView);
    }
}
