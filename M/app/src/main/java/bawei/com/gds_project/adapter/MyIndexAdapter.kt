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
import bawei.com.gds_project.bean.IndexBean
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by 李蓉 on 2017/11/28.
 */
class MyIndexAdapter(issueList: List<IndexBean.Item>, con: Context) : RecyclerView.Adapter<MyIndexAdapter.MyViewHolder>() {


    var list : List<IndexBean.Item> = issueList
    var context : Context = con

    override fun getItemCount(): Int {
        return list!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {

        val itemList = list!!.get(position)

        holder?.index_title?.text = itemList.data.title
        holder?.index_category?.text = itemList.data.category
        val parse = Uri.parse(itemList.data.cover.detail)
        holder?.index_img?.setImageURI(parse)

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.index_item, parent, false)
        val myViewHolder = MyViewHolder(view)
        Log.i("sss","创建布局")
        return myViewHolder
    }

    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var index_img = itemView!!.findViewById<SimpleDraweeView>(R.id.id_img)
        var index_title = itemView!!.findViewById<TextView>(R.id.id_title)
        var index_category = itemView!!.findViewById<TextView>(R.id.id_category)
    }

}