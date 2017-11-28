package bawei.com.gds_project.index_model

import bawei.com.gds_project.api.Api
import bawei.com.gds_project.utils.ApiRetrofit
import bawei.com.gds_project.utils.ApiService
import io.reactivex.Flowable

/**
 * Created by dell-pc on 2017/11/28.
 */
class IndexModelImpl : IndexModel {
    //请求首页数据的方法
    override fun getIndexData(): Flowable<IndexBean> {
        val clientApi = ApiRetrofit.getInstance().getClientApi(ApiService::class.java, Api.BASE_URL)
        val indexData = clientApi.getIndexData();
        return indexData
    }
}