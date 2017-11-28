package bawei.com.gds_project.fragment

import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toolbar
import bawei.com.gds_project.R

/**
 * Created by 999 on 2017/11/27.
 */
class FragmentHot : Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var  a = inflater?.inflate(R.layout.fragment_hot,container,false)
        return a
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}