package bawei.com.gds_project.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bawei.com.gds_project.R
import bawei.com.gds_project.bean.FindBean
import bawei.com.gds_project.find.FindView


/**
 * Created by 杨圆圆 on 2017/11/27.
 */
class FragmentFind:Fragment(),FindView {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_find, container, false)
        val recycle_find = v.findViewById<RecyclerView>(R.id.recycle_find)

        return v
    }
    override fun getBean(bean: List<FindBean>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

}