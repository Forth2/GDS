package bawei.com.gds_project.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import bawei.com.gds_project.R
import bawei.com.gds_project.bean.IndexBean
import bawei.com.gds_project.index_presenter.IndexPresenterImpl
import bawei.com.gds_project.index_view.IndexView

/**
 * Created by dell-pc on 2017/11/27.
 */
class FragmentIndex : Fragment(),IndexView {

    override fun showData(indexbean: IndexBean) {

    }

    var indexPresenter : IndexPresenterImpl ?= null
    lateinit var index_title : TextView
    lateinit var rv_index : RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_index, container, false)

        indexPresenter = IndexPresenterImpl(this)

        indexPresenter!!.getIndexData()

        index_title = view.findViewById<TextView>(R.id.index_title)
        rv_index = view.findViewById<RecyclerView>(R.id.rv_index)



        return view
    }

}