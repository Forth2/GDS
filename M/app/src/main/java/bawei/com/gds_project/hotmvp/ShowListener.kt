package bawei.com.gds_project.hotmvp

import bawei.com.gds_project.bean.HotBean
import io.reactivex.Flowable

/**
 * Created by 999 on 2017/11/29.
 */

interface ShowListener{
    fun getData(hotBean: List<HotBean.ItemListBean>)
}
