package bawei.com.gds_project.fragment.hot_fragments

import android.support.v7.widget.RecyclerView
import bawei.com.gds_project.R
import bawei.com.gds_project.utils.BaseFragment
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import bawei.com.gds_project.adapter.HotZhouAdapter
import bawei.com.gds_project.adapter.MyIndexAdapter
import bawei.com.gds_project.bean.HotBean
import bawei.com.gds_project.bean.IndexBean
import bawei.com.gds_project.hotmvp.p.HotPresenter
import bawei.com.gds_project.hotmvp.p.IHotPresenter
import bawei.com.gds_project.hotmvp.v.IHotView
import io.reactivex.Flowable
import kotlinx.android.synthetic.main.fragments_hot_zhou.*


/**
 * Created by 巩雨松 on 2017/11/28
 * 周热门
 */
class FragmentZhou : BaseFragment(),IHotView {


    lateinit var recycle : RecyclerView

    override fun getLayoutResources(): Int {

        return R.layout.fragments_hot_zhou
    }

    override fun initView() {
        recycle = view!!.findViewById<RecyclerView>(R.id.fragment_hot_zhou_recycle)
        var presenter :IHotPresenter?= HotPresenter(this)
        presenter?.relevance(context)

    }
    override fun showData(hotarr: List<HotBean.ItemListBean>) {
        //得到数据
        val indexAdapter = HotZhouAdapter(hotarr, activity)
        recycle.layoutManager = LinearLayoutManager(activity)
        recycle.adapter = indexAdapter
        Log.i("ss","走了"+hotarr.size)
    }

}

