package sinx.com.helloespresso

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.ColorInt
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_set_one.setOnClickListener {
            changeTextOnTextView(R.string.one)
        }

        btn_set_two.setOnClickListener {
            changeTextOnTextView(R.string.two)
        }

        btn_set_three.setOnClickListener {
            changeTextOnTextView(R.string.three)
        }

        btn_clear.setOnClickListener {
            changeTextOnTextView(R.string.clear)
        }

        switch_view.setOnCheckedChangeListener { _, isCheck ->
            changeTextColor(if (isCheck) android.R.color.holo_red_dark
            else android.R.color.holo_blue_dark)
        }
    }

    fun changeTextColor(color: Int) {
        tv_result.setTextColor(ContextCompat.getColor(tv_result.context, color))
    }

    fun changeTextOnTextView(@StringRes res: Int) {
        tv_result.text = resources.getText(res)
    }
}
