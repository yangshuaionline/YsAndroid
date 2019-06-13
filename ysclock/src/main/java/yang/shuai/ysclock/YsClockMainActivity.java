package yang.shuai.ysclock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class YsClockMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ys_clock_main);
        YsClockView view = findViewById(R.id.ys_view);
        Button bt = findViewById(R.id.bt);
        Button goBack = findViewById(R.id.goBack);
        goBack.setOnClickListener(v->finish());
        bt.setOnClickListener(view1->{
            Calendar calendar = Calendar.getInstance();
            view.setTime(calendar.get(Calendar.HOUR_OF_DAY),
                    calendar.get(Calendar.MINUTE),
                    calendar.get(Calendar.SECOND));
            Toast.makeText(this,
                    "当前时间"+
                            calendar.get(Calendar.HOUR_OF_DAY)+":"+
                            calendar.get(Calendar.MINUTE)+":"+
                            calendar.get(Calendar.SECOND),
                    Toast.LENGTH_SHORT).show();
        });
    }
}
