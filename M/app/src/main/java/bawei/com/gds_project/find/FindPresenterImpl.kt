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
    //有参构造得到View
    constructor(findView: FindView?) {
        this.findView = findView
        //多态的方式得到Model
        findModel= FindModelImpl()
    }

    override fun getFind() {
        //调用Model的方法
        val server = findModel?.getFindBean()
        server  ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe{bean:List<FindBean> ->
                    findView?.getBean(bean)
                }


    }
}