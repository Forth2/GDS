package bawei.com.gds_project.acticity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import bawei.com.gds_project.R
import bawei.com.gds_project.bean.IndexBean
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        //获取视频播放组件
        val judge = intent.getStringExtra("judge")
        if(judge.equals("index")){
            val data : IndexBean.Data? = intent.getSerializableExtra("data") as IndexBean.Data
            gsyVideo.setUp(data?.playUrl,false,"  ")
            video_title.text = data?.title
            video_cate.text = data?.category+"/"+ data?.duration!! /60+"'"+data.duration%60+"'"+"'"
            video_desc.text = data?.description
        }
    }
}
