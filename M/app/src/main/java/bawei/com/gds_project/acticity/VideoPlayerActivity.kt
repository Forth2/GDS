package bawei.com.gds_project.acticity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import bawei.com.gds_project.R
import bawei.com.gds_project.bean.FindSonBean
import bawei.com.gds_project.bean.HotBean
import bawei.com.gds_project.bean.IndexBean
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {

    var i : Intent ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        //获取视频播放组件
        i = intent
        val judge = i?.getStringExtra("judge")
        if(judge.equals("index")){
            val data : IndexBean.Data? = i?.getSerializableExtra("data") as IndexBean.Data
            gsyVideo.setUp(data?.playUrl,false,"  ")
            video_title.text = data?.title
            video_cate.text = data?.category+"/"+ data?.duration!! /60+"'"+data.duration%60+"'"+"'"
            video_desc.text = data?.description
        }else if(judge.equals("find")){
            val findData : FindSonBean.ItemListBean.DataBean? = i?.getSerializableExtra("findData") as FindSonBean.ItemListBean.DataBean
            gsyVideo.setUp(findData?.playUrl,false,"  ")
            video_title.text = findData?.title
            video_cate.text = findData?.category+"/"+ findData?.duration!! /60+"'"+findData.duration%60+"'"+"'"
            video_desc.text = findData?.description
        }else if(judge.equals("hot")){
            val hotData : HotBean.ItemListBean.DataBean? = i?.getSerializableExtra("hotdata") as HotBean.ItemListBean.DataBean
            gsyVideo.setUp(hotData?.playUrl,false,"  ")
            video_title.text = hotData?.title
            video_cate.text = hotData?.category+"/"+ hotData?.duration!! /60+"'"+hotData.duration%60+"'"+"'"
            video_desc.text = hotData?.description
        }
    }

    /**
     * 请求 获取背景图片
     */
    fun getRequestData(){

    }

}
