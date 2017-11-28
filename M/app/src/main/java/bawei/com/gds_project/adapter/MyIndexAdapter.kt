package bawei.com.gds_project.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import bawei.com.gds_project.bean.IndexBean

/**
 * Created by dell-pc on 2017/11/28.
 */
class MyIndexAdapter(list: List<IndexBean.IssueListBean>, context: Context?) : RecyclerView.Adapter<MyIndexAdapter.MyViewHolder>() {

    var list : List<IndexBean.IssueListBean> ?= null
    var context : Context ?= null

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        TODO("not i mplemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }

}