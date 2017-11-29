package bawei.com.gds_project.index_model

import bawei.com.gds_project.bean.IndexBean
import io.reactivex.Flowable

/**
 * Created by dell-pc on 2017/11/28.
 */
interface IndexModel {

    fun getindexData() : Flowable<IndexBean.Bean>

}