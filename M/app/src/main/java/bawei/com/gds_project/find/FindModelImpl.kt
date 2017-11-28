package bawei.com.gds_project.find

import bawei.com.gds_project.api.Api
import bawei.com.gds_project.bean.FindBean
import bawei.com.gds_project.utils.ApiRetrofit
import bawei.com.gds_project.utils.ApiService
import io.reactivex.Flowable

/**
 * Created by 杨圆圆 on 2017/11/28.
 */
class FindModelImpl:FindModel {

    override fun getFindBean(): Flowable<List<FindBean>> {
        var findData = ApiRetrofit.getInstance()
                .getClientApi(ApiService::class.java, Api.BASE_URL)
                .getFindData()
        return findData

    }
}