package bawei.com.gds_project.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bawei.com.gds_project.R

/**
 *  1.类的用途
 *  2.@author棒棒糖：赵姗杉
 *  3.@date2017/11/27  16：46
 */
class FragmentMine :Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = View.inflate(context, R.layout.fragment_mine, null)

        imageData()
        return view
    }

    private fun imageData() {


    }

}