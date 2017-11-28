package bawei.com.gds_project.acticity

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import bawei.com.gds_project.R
import bawei.com.gds_project.service.ClockService
import bawei.com.gds_project.service.ClockService.Bind
import bawei.com.gds_project.utils.BaseActivity2

class ClockActivity : BaseActivity2() {

    private var bind: Bind? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clock)

        val conn = object : ServiceConnection {

            //解除绑定
            override fun onServiceDisconnected(name: ComponentName) {
                // TODO Auto-generated method stub

            }

            //IBinder 中间人
            //绑定成功
            override fun onServiceConnected(name: ComponentName, service: IBinder) {
                // TODO Auto-generated method stub
                bind = service as ClockService.Bind
                bind!!.onstart()
                Log.i("TAG", "service")
                Thread(Runnable(function = {
                    Thread.sleep(5000)
                    bind!!.onstop()
                    val intent = Intent()
                    //获取intent对象
                    intent.setClass(this@ClockActivity,MainActivity::class.java)
                    // 获取class是使用::反射
                    startActivity(intent)
                    finish()
                })).start()
            }
        }

        val service = Intent(this@ClockActivity, ClockService::class.java)


        /**
         * 第一个参数: service  intent
         * 第二个参数: conn
         * 第三个参数: flags
         */
        //进行绑定
        bindService(service, conn, Context.BIND_AUTO_CREATE)

    }
}
