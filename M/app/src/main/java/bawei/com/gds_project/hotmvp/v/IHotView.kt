package bawei.com.gds_project.hotmvp.v

import bawei.com.gds_project.bean.HotBean
import io.reactivex.Flowable

/**
 * Created by 999 on 2017/11/29.
 */

interface IHotView{
    fun showData(hotBean: List<HotBean.ItemListBean>)
}
