package bawei.com.gds_project.index_presenter

import bawei.com.gds_project.index_model.IndexModel
import bawei.com.gds_project.index_model.IndexModelImpl
import bawei.com.gds_project.index_view.IndexView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by dell-pc on 2017/11/28.
 */
class IndexPresenterImpl : IndexPresenter {

    var indexView : IndexView ?= null
    var indexModel : IndexModel ?= null

    constructor(indexView: IndexView?) {
        this.indexView = indexView
        indexModel = IndexModelImpl()
    }

    override fun getIndexData() {
        val flowable = indexModel!!.getIndexData()
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe{ s : IndexBean ->
                    indexView!!.showData()
                }
    }
}