package bawei.com.gds_project.find

import bawei.com.gds_project.bean.FindBean
import io.reactivex.Flowable

/**
 * Created by 杨圆圆 on 2017/11/28.
 */
interface FindModel {
    fun getFindBean():Flowable<List<FindBean>>
}