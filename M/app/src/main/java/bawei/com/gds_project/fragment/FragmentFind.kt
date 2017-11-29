package bawei.com.gds_project.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import bawei.com.gds_project.R
import bawei.com.gds_project.acticity.ResultfindActivity
import bawei.com.gds_project.adapter.MyFindAdapter
import bawei.com.gds_project.bean.FindBean
import bawei.com.gds_project.find.FindPresenterImpl
import bawei.com.gds_project.find.FindView


/**
 * Created by 杨圆圆 on 2017/11/27.
 */
class FragmentFind:Fragment(),FindView {

    var recycle_find:RecyclerView ?=null
    var presenter :FindPresenterImpl?=null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //加载布局
        val v = inflater!!.inflate(R.layout.fragment_find, container, false)
        //查找组件
         recycle_find = v.findViewById<RecyclerView>(R.id.recycle_find)
        //初始化Presenter
        presenter= FindPresenterImpl(this)
        //调用Presenter方法
        presenter?.getFind()
        return v
    }
    override fun getBean(bean: List<FindBean>) {
        //给RecycleView设置布局管理器
        recycle_find!!.layoutManager= GridLayoutManager(context, 2) as RecyclerView.LayoutManager?
        //初始化适配器
        var myFindAdapter=MyFindAdapter(context,bean)
        //给RecycleView添加适配器
        recycle_find?.adapter=myFindAdapter
        myFindAdapter?.setOnItemClickListener(object : MyFindAdapter.OnItemClickListener{
            override fun onClick(position: Int) {
                Toast.makeText(activity,"haha"+position,Toast.LENGTH_SHORT).show()
                val name = bean.get(position).name
                var intent=Intent(activity,ResultfindActivity::class.java)
                intent.putExtra("name",name)
                startActivity(intent)
            }
        })
    }

}