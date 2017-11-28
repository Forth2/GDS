package bawei.com.gds_project.index_view

import bawei.com.gds_project.bean.IndexBean

/**
 * Created by dell-pc on 2017/11/28.
 */
open interface IndexView {

    //展示数据
    fun showData(indexbean : IndexBean)

}