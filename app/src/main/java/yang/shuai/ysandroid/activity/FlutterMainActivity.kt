package yang.shuai.ysandroid.activity

import android.os.Bundle
import android.widget.FrameLayout
import io.flutter.facade.Flutter
import android.view.View
import androidx.fragment.app.FragmentActivity
import kotlinx.android.synthetic.main.activity_flutter_main.*
import yang.shuai.ysandroid.R

class FlutterMainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_main)
        val flutterView = Flutter.createView(this,lifecycle,"route1")
        val layoutParams = FrameLayout.LayoutParams(-1,-1)
        ceshi_constraintLayout.addView(flutterView,layoutParams)
        flutterView.addFirstFrameListener {
            ceshi_constraintLayout.visibility = View.VISIBLE
        }

    }
}
