package km.project.expandablelist

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)
        val resultString = intent.getStringExtra("string")
        text2.text = resultString
    }
}