package bawei.com.gds_project.hotmvp.m

import android.content.Context
import bawei.com.gds_project.api.Api
import bawei.com.gds_project.bean.FindBean
import bawei.com.gds_project.bean.FindSonBean
import bawei.com.gds_project.bean.HotBean
import bawei.com.gds_project.hotmvp.ShowListener
import bawei.com.gds_project.hotmvp.v.IHotView
import bawei.com.gds_project.utils.ApiRetrofit
import bawei.com.gds_project.utils.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 999 on 2017/11/29.
 */

class HotMpdle : IHotModle {


    var arr2 = ArrayList<List<HotBean.ItemListBean>>()

    override fun getData(context: Context, listener: ShowListener,strategy : String) {

        var hotData = ApiRetrofit.getInstance()
                .getClientApi(ApiService::class.java, Api.BASE_URL)
                .getHotData(10,strategy,"26868b32e808498db32fd51fb422d00175e179df",83)
          //http://baobab.kaiyanapp.com/api/v3/ranklist?num=10&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    //http://baobab.kaiyanapp.com/api/v3/ranklist?num=10&strategy=monthly&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
        //http://baobab.kaiyanapp.com/api/v3/ranklist?num=10&strategy=%25s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
        hotData?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { bean : HotBean ->
                    listener.getData(bean.itemList!!)
                }

    }
}




