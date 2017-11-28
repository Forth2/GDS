package bawei.com.gds_project.utils

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import bawei.com.gds_project.R
import com.gyf.barlibrary.ImmersionBar

open class BaseActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base2)
        ImmersionBar.with(this)
                .init()
    }

    override fun onDestroy() {
        super.onDestroy()
        ImmersionBar.with(this).destroy()
    }
}
