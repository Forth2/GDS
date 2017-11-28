package bawei.com.gds_project.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

/**
 * Created by dell-pc on 2017/11/28.
 */
class MyIndexAdapter : RecyclerView.Adapter<MyIndexAdapter.MyViewHolder>() {
    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {

        return MyViewHolder()

    }

    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }

}