package bawei.com.gds_project.fragment.hot_fragments

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import bawei.com.gds_project.R
import bawei.com.gds_project.acticity.VideoPlayerActivity
import bawei.com.gds_project.adapter.HotZhouAdapter
import bawei.com.gds_project.bean.HotBean
import bawei.com.gds_project.hotmvp.p.HotPresenter
import bawei.com.gds_project.hotmvp.p.IHotPresenter
import bawei.com.gds_project.hotmvp.v.IHotView
import bawei.com.gds_project.utils.BaseFragment

/**
 * Created by 999 on 2017/11/28.
 */
class FragmentZong : BaseFragment(), IHotView {

    lateinit var recycle : RecyclerView
    override fun getLayoutResources(): Int {
        return R.layout.fragments_hot_zong
    }

    override fun initView() {
        recycle = view!!.findViewById<RecyclerView>(R.id.fragment_hot_zong_recycle)
        var presenter : IHotPresenter?= HotPresenter(this)
        presenter?.relevance(context,"historical")
    }


    override fun showData(hotBean: List<HotBean.ItemListBean>) {
        //得到数据
        val indexAdapter = HotZhouAdapter(hotBean, activity)
        recycle.layoutManager = LinearLayoutManager(activity)
        recycle.adapter = indexAdapter
        Log.i("ss","走了"+hotBean.size)

        //点击监听
        indexAdapter?.setItemClick(object : HotZhouAdapter.OnItemClickListen{
            override fun onItemClick(position: Int) {
                var intent = Intent(activity, VideoPlayerActivity::class.java)
                intent.putExtra("judge","hot")
                intent.putExtra("hotdata",hotBean.get(position).data!!.date)
                startActivity(intent)
            }
        })
    }
}