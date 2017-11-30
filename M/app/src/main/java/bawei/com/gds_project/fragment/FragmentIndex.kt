package bawei.com.gds_project.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import bawei.com.gds_project.R
import bawei.com.gds_project.acticity.VideoPlayerActivity
import bawei.com.gds_project.adapter.MyIndexAdapter
import bawei.com.gds_project.bean.IndexBean
import bawei.com.gds_project.index_presenter.IndexPresenterImpl
import bawei.com.gds_project.index_view.IndexView

/**
 * Created by 李蓉 on 2017/11/27.
 */
class FragmentIndex : Fragment(),IndexView {

    var typeList = ArrayList<IndexBean.Item>()

    override fun showData(indexbean: IndexBean.Bean) {
       // Log.i("sss","展示页面"+indexbean.issueList)
        val issueList = indexbean.issueList
        for (i in issueList.indices){
            for (j in issueList.get(i).itemList.indices) {
                val type = issueList.get(i).itemList.get(j).type
                if(type.equals("video")){
                    typeList.add(issueList.get(i).itemList.get(j))
                }
            }
        }
        //创建适配器
        rv_index.layoutManager = LinearLayoutManager(activity)
        val indexAdapter = MyIndexAdapter(typeList, activity)
        rv_index.adapter = indexAdapter
       // Log.i("sss","创建适配器成功")
        //点击监听
        indexAdapter?.setItemClick(object : MyIndexAdapter.OnItemClickListen{
            override fun onItemClick(position: Int) {
                var intent = Intent(activity,VideoPlayerActivity::class.java)
                intent.putExtra("judge","index")
                intent.putExtra("data",typeList.get(position).data)
                startActivity(intent)
            }
        })

    }

    var indexPresenter : IndexPresenterImpl ?= null
    lateinit var index_tv : TextView
    lateinit var rv_index : RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_index, container, false)

        index_tv = view.findViewById<TextView>(R.id.index_tv)
        rv_index = view.findViewById<RecyclerView>(R.id.rv_index)

        indexPresenter = IndexPresenterImpl(this)

        indexPresenter!!.getIndex()

        return view
    }

}