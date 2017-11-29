package bawei.com.gds_project.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import bawei.com.gds_project.R
import bawei.com.gds_project.bean.HotBean
import bawei.com.gds_project.bean.IndexBean
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by 巩雨松 on 2017/11/29.
 */

class HotZhouAdapter(issueList: List<HotBean.ItemListBean>, con: Context) : RecyclerView.Adapter<HotZhouAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val hotbean = list!!.get(position)

        val parse = Uri.parse(hotbean.data!!.cover!!.detail)
        holder?.index_img?.setImageURI(parse)
    }


    var list : List<HotBean.ItemListBean> = issueList
    var context : Context = con

    override fun getItemCount(): Int {
        return list!!.size
    }



    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_hot_fragment, parent, false)
        val myViewHolder = MyViewHolder(view)
        //Log.i("sss","创建布局")
        return myViewHolder
    }

    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var index_img = itemView!!.findViewById<SimpleDraweeView>(R.id.fresco_test)

    }

    interface OnItemClickListen{
        fun onItemClick(position : Int)
    }

    var onItemClickListen : OnItemClickListen ?= null

    fun setItemClick(onItemClickListen: OnItemClickListen){
        this.onItemClickListen = onItemClickListen
    }

}

