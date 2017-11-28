package bawei.com.gds_project.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import bawei.com.gds_project.R

/**
 * Created by dell-pc on 2017/11/27.
 */
class FragmentIndex : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_index, container, false)

        val index_title = view.findViewById<TextView>(R.id.index_title)
        val rv_index = view.findViewById<RecyclerView>(R.id.rv_index)


        return view
    }

}