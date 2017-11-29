package bawei.com.gds_project.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log


/**
 * Created by dell-pc on 2017/11/23.
 */
class ClockService : Service() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate() {
        // TODO Auto-generated method stub
        super.onCreate()

        //第一个参数：上下文  第二个参数：获取音乐
        mediaPlayer = MediaPlayer()
        Log.i("TAG", "创建MediaPlayer")

    }

    //绑定成功
    override fun onBind(intent: Intent): IBinder? {
        // TODO Auto-generated method stub
        Log.i("TAG", "返回bind")
        return Bind()
    }

    //解除绑定
    override fun onUnbind(intent: Intent): Boolean {
        // TODO Auto-generated method stub
        return true
    }

    fun stop() {
        if(mediaPlayer != null){
            mediaPlayer!!.stop()
            Log.i("TAG","音乐暂停播放")
        }
    }

    //音乐开始播放
    fun start() {

        try {
            val openFd = assets.openFd("music.mp3")
            mediaPlayer!!.setDataSource(openFd.getFileDescriptor(),openFd.getStartOffset(),
                    openFd.getStartOffset())
            mediaPlayer!!.prepare()
            mediaPlayer!!.start()
            Log.i("TAG", "音乐开始播放")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    internal inner class Bind : Binder() {
        fun onstart() {
            start()
            Log.i("TAG", "音乐开始播放方法成功")
        }
        fun onstop(){
            stop()
            Log.i("TAG","音乐暂停播放方法成功")
        }
    }

    override fun onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy()
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }

}