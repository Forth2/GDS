package bawei.com.gds_project.acticity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import bawei.com.gds_project.R
import bawei.com.gds_project.bean.FindSonBean
import bawei.com.gds_project.findresult.FindResultPresenterImpl
import bawei.com.gds_project.findresult.FindResultView

class ResultfindActivity : AppCompatActivity(),FindResultView {
    var findResultPresenter:FindResultPresenterImpl?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultfind)
        //获取传过来的值
        val name = intent.getStringExtra("name")
        Toast.makeText(this,"haha"+name,Toast.LENGTH_SHORT).show()
        //查找组件
        val recycle_findResult = findViewById(R.id.recycle_findResult)
        //得到Presenter对象
        findResultPresenter= FindResultPresenterImpl(this)
        //调用Presenter对象
        findResultPresenter?.getVideoData(name)
    }
    override fun getData(bean: FindSonBean) {
        Log.i("xxx",bean.toString())

    }

}
