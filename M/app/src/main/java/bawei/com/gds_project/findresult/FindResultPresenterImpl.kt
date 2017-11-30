package bawei.com.gds_project.findresult

import bawei.com.gds_project.bean.FindSonBean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 杨圆圆 on 2017/11/29.
 */
class FindResultPresenterImpl :FindResultPresenter{
    var findResultView:FindResultView?=null
    var findResultModel:FindResultModelImpl?=null
    constructor(findResultView: FindResultView?) {
        this.findResultView = findResultView
        findResultModel= FindResultModelImpl()
    }

    override fun getVideoData(name: String) {
        val flowable = findResultModel?.getViewData(name)
        flowable?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe { bean:FindSonBean ->
                    findResultView?.getData(bean)
                }

    }
}