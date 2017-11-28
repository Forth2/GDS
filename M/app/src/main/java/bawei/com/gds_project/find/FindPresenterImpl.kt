package bawei.com.gds_project.find

import bawei.com.gds_project.bean.FindBean
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by 杨圆圆 on 2017/11/28.
 */
class FindPresenterImpl:FindPresenter {
    var findView:FindView?=null
    var findModel:FindModelImpl?=null

    constructor(findView: FindView?) {
        this.findView = findView
        findModel= FindModelImpl()
    }

    override fun getFind() {
        val server = findModel?.getFindBean()
        server  ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe{bean:List<FindBean> ->
                    findView?.getBean(bean)
                }


    }
}