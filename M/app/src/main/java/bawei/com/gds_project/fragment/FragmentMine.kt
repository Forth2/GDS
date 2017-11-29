package bawei.com.gds_project.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import bawei.com.gds_project.R
import bawei.com.gds_project.acticity.SettingActivity
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.fragment_mine.*

/**
 *  1.类的用途
 *  2.@author棒棒糖：赵姗杉
 *  3.@date2017/11/27  16：46
 */
class FragmentMine :Fragment() ,View.OnClickListener {


    lateinit var mine_setting : TextView
    lateinit var mine_fresco : SimpleDraweeView
    lateinit var mine_cache : TextView
    lateinit var mine_look : TextView
    lateinit var mine_message : TextView
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = View.inflate(context, R.layout.fragment_mine, null)
        initId(view)
        return view
    }

    private fun initId(view: View) {
        mine_setting = view.findViewById<TextView>(R.id.mine_setting)
        mine_fresco=view.findViewById<SimpleDraweeView>(R.id.mine_fresco)
        mine_cache=view.findViewById<TextView>(R.id.mine_cache)
        mine_look=view.findViewById<TextView>(R.id.mine_look)
        mine_message=view.findViewById<TextView>(R.id.mine_message)
        mine_setting.setOnClickListener(this)
        mine_fresco.setOnClickListener(this)
        mine_cache.setOnClickListener(this)
        mine_look.setOnClickListener(this)
        mine_message.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
      when(p0?.id){
          R.id.mine_setting ->{
            var intent=Intent(activity,SettingActivity::class.java)

          }
          R.id.mine_fresco ->{

          }
          R.id.mine_look ->{

          }
          R.id.mine_message ->{

          }
          R.id.mine_cache ->{

          }
      }

    }

}