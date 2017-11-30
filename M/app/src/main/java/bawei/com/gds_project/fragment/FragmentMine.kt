package bawei.com.gds_project.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AlertDialog
import android.support.v7.app.AlertDialog.*
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import bawei.com.gds_project.R
import bawei.com.gds_project.acticity.SettingActivity
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.fragment_mine.*
import android.widget.Toast
import bawei.com.gds_project.acticity.MainActivity
import bawei.com.gds_project.R.mipmap.ic_launcher



/**
 *  1.类的用途
 *  2.@author棒棒糖：赵姗杉
 *  3.@date2017/11/27  16：46
 */
class FragmentMine :Fragment() ,View.OnClickListener {


    lateinit var mine_setting : ImageView
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
        mine_setting = view.findViewById<ImageView>(R.id.mine_setting)
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
              startActivity(intent)
          }
          R.id.mine_fresco ->{
              //创建数据
              val items = arrayOf("从相册选择图片", "打开相机")
              var alertDialogBuilder = AlertDialog.Builder(activity)
              alertDialogBuilder.setIcon(R.mipmap.icon_setting).setTitle("提示")
                      .setItems(items, DialogInterface.OnClickListener {
                          dialogInterface, i ->
                          Log.i("zss",items[i])
              })
              alertDialogBuilder.create().show()


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