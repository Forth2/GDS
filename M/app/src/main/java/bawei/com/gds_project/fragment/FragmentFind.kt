package bawei.com.gds_project.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bawei.com.gds_project.R
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
        val v = inflater!!.inflate(R.layout.fragment_find, container, false)
         recycle_find = v.findViewById<RecyclerView>(R.id.recycle_find)
        presenter= FindPresenterImpl(this)
        presenter?.getFind()
        return v
    }
    override fun getBean(bean: List<FindBean>) {
        recycle_find!!.layoutManager=GridLayoutManager(context, 2)
        var myFindAdapter=MyFindAdapter(context,bean)
        recycle_find?.adapter=myFindAdapter
    }

}