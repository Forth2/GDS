package bawei.com.gds_project.adapter

import android.content.Context
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import bawei.com.gds_project.R
import bawei.com.gds_project.bean.FindBean
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.controller.AbstractDraweeController
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by 杨圆圆 on 2017/11/28.
 */
class MyFindAdapter(mContext:Context,mlist:List<FindBean>): RecyclerView.Adapter<MyFindAdapter.MyViewHolder>() {
    private var context:Context=mContext
    private var list:List<FindBean> =mlist


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        var v=LayoutInflater.from(context).inflate(R.layout.find_item,parent,false)

        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.textView?.setText(list.get(position).name)
//        Glide.with(context).load(list.get(position).bgPicture).into(holder?.simpleDrawee)
        var uri=Uri.parse(list.get(position).bgPicture)
        var contronal:AbstractDraweeController<*,*>?=Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setTapToRetryEnabled(true)
                .setOldController(holder?.simpleDrawee?.controller)
                .build()
        holder?.simpleDrawee?.controller=contronal

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View?):RecyclerView.ViewHolder(itemView){
        var textView:TextView= itemView?.findViewById(R.id.tv_titleFind)!!
//        var simpleDrawee:ImageView= itemView?.findViewById(R.id.fresco_find)!!
        var simpleDrawee:SimpleDraweeView= itemView?.findViewById(R.id.fresco_find)!!
    }
}