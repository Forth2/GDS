package bawei.com.gds_project.findresult

import bawei.com.gds_project.api.Api
import bawei.com.gds_project.bean.FindSonBean
import bawei.com.gds_project.utils.ApiRetrofit
import bawei.com.gds_project.utils.ApiService
import io.reactivex.Flowable

/**
 * Created by 杨圆圆 on 2017/11/29.
 */
class FindResultModelImpl :FindResultModel{
    override fun getViewData(name: String): Flowable<FindSonBean> {
        val findMoreData = ApiRetrofit.getInstance()
                .getClientApi(ApiService::class.java, Api.BASE_URL)
                .getFindMoreData("date", "26868b32e808498db32fd51fb422d00175e179df", 83, name, 0)
        return findMoreData
    }
}