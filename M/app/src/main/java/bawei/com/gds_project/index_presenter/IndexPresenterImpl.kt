package bawei.com.gds_project.index_presenter

import android.util.Log
import bawei.com.gds_project.bean.IndexBean
import bawei.com.gds_project.index_model.IndexModel
import bawei.com.gds_project.index_model.IndexModelImpl
import bawei.com.gds_project.index_view.IndexView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 李蓉 on 2017/11/28.
 */
class IndexPresenterImpl : IndexPresenter {

    var indexView : IndexView ?= null
    var indexModel : IndexModel ?= null

    constructor(indexView: IndexView?) {
        this.indexView = indexView
        indexModel = IndexModelImpl()
    }

    override fun getIndex() {
        Log.i("sss","逻辑判断")
        val flowable = indexModel!!.getindexData()
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ s : IndexBean.Bean ->
                    indexView?.showData(s)
                }
    }
}