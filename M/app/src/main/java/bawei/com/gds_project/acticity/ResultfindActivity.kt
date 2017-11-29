package bawei.com.gds_project.acticity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import bawei.com.gds_project.R
import bawei.com.gds_project.adapter.FindResultAdapter
import bawei.com.gds_project.bean.FindSonBean
import bawei.com.gds_project.findresult.FindResultPresenterImpl
import bawei.com.gds_project.findresult.FindResultView
import kotlinx.android.synthetic.main.activity_resultfind.*

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
        tv_findResultTitle.setText(name)
        iv_findResultBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }
    override fun getData(bean: FindSonBean) {
        //初始化适配器
        var findResultAdapter=FindResultAdapter(bean,this@ResultfindActivity)
        //加载布局管理器
        recycle_findResult.layoutManager=LinearLayoutManager(this@ResultfindActivity)
        //设置适配器
        recycle_findResult.adapter=findResultAdapter
        //设置条目点击监听
        findResultAdapter.setOnItemClickListener(object:FindResultAdapter.OnItemClickListener{
            override fun onClick(position: Int) {
                val listBean = bean.itemList?.get(position)
                Toast.makeText(this@ResultfindActivity,"下标—>"+position , Toast.LENGTH_SHORT).show()
                //初始化Intent对象
                var intent= Intent(this@ResultfindActivity,VideoPlayerActivity::class.java)
                //传值
                intent.putExtra("judge","find")
                intent.putExtra("data",listBean)
                //跳转
                startActivity(intent)
            }

        })
    }

}
