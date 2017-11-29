package bawei.com.gds_project.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import bawei.com.gds_project.R
import bawei.com.gds_project.bean.FindSonBean
import com.bumptech.glide.Glide

/**
 * Created by 杨圆圆 on 2017/11/29.
 */
class FindResultAdapter(mBean:FindSonBean,mContext:Context): RecyclerView.Adapter<FindResultAdapter.MyViewHolder>() {



    private var bean:FindSonBean?=mBean
    private var context:Context?=mContext

    override fun getItemCount(): Int {
        return bean!!.itemList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        var list: List<FindSonBean.ItemListBean>? =bean!!.itemList
        if(list?.get(position)!!.type.equals("banner2")){
            return
        }
        holder?.tv_findResult?.setText(list?.get(position)!!.data!!.title)

        Glide.with(context).load(list?.get(position)!!.data!!.cover!!.detail).into(holder?.iv_findResult)
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.findresult_item, parent, false)
        var holder=MyViewHolder(view)
        holder?.itemView?.setOnClickListener {
            listener?.onClick(holder.position)
        }
        return holder
    }


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tv_findResult:TextView=itemView!!.findViewById(R.id.tv_findResult)
        var iv_findResult:ImageView=itemView!!.findViewById(R.id.iv_findResult)
    }
    interface OnItemClickListener{
        fun onClick(position: Int)
    }
    private var listener:OnItemClickListener?=null
    fun setOnItemClickListener(listener:OnItemClickListener){
        this.listener=listener
    }
}