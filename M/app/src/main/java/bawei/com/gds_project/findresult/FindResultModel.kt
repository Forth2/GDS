package bawei.com.gds_project.findresult

import bawei.com.gds_project.bean.FindSonBean
import io.reactivex.Flowable

/**
 * Created by 杨圆圆 on 2017/11/29.
 */
interface FindResultModel {
    fun getViewData(name:String) :Flowable<FindSonBean>
}