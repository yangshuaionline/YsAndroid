package yang.shuai.ysandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_test);
        ImageView iv = findViewById(R.id.iv);
        Glide
                .with(this)
                .load("")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher)
                .into(iv);
    }
}
