package bawei.com.gds_project.hotmvp.m

import android.content.Context
import bawei.com.gds_project.bean.HotBean
import bawei.com.gds_project.hotmvp.ShowListener

/**
 * Created by 999 on 2017/11/29.
 */

interface IHotModle {
    fun getData(context : Context,listener:ShowListener,strategy : String)
}
