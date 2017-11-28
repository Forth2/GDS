
package bawei.com.gds_project

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
/**
 *  1.类的用途
 *  2.@author棒棒糖：赵姗杉
 *  3.@date2017/11/28  09：07
 */
class MyApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}