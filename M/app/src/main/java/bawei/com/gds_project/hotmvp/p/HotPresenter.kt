package bawei.com.gds_project.hotmvp.p

import android.content.Context
import bawei.com.gds_project.bean.HotBean
import bawei.com.gds_project.hotmvp.ShowListener
import bawei.com.gds_project.hotmvp.m.HotMpdle
import bawei.com.gds_project.hotmvp.m.IHotModle
import bawei.com.gds_project.hotmvp.v.IHotView
import io.reactivex.Flowable

/**
 * Created by 999 on 2017/11/29.
 */
class HotPresenter:IHotPresenter,ShowListener {


    var hotview : IHotView? = null
    var hotmodle : IHotModle? =null

    constructor(hotview: IHotView?) {
        this.hotview = hotview
        hotmodle = HotMpdle()
    }

    override fun relevance(context: Context,weekly : String) {
        hotmodle?.getData(context,this,weekly)
    }

    override fun getData(hotBean :List<HotBean.ItemListBean>) {
       hotview?.showData(hotBean)
    }
}