package yang.shuai.ysandroid;

import androidx.appcompat.app.AppCompatActivity;
import yang.shuai.ysclock.YsClockView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        YsClockView view = findViewById(R.id.ys_view);
        Button bt = findViewById(R.id.bt);
        bt.setOnClickListener(view1->{
            view.setTime(5,30,24);
            Toast.makeText(this,String.valueOf(0%3),Toast.LENGTH_SHORT).show();
        });
    }
}
