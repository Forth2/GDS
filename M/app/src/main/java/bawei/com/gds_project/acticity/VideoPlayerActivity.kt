package bawei.com.gds_project.acticity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import bawei.com.gds_project.R
import bawei.com.gds_project.bean.FindSonBean
import bawei.com.gds_project.bean.HotBean
import bawei.com.gds_project.bean.IndexBean
import com.bumptech.glide.Glide
import com.shuyu.gsyvideoplayer.utils.OrientationUtils
import kotlinx.android.synthetic.main.activity_video_player.*

class VideoPlayerActivity : AppCompatActivity() {

    var i : Intent ?= null
    lateinit var orientationUtils : OrientationUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        //获取视频播放组件
        i = intent
        val judge = i?.getStringExtra("judge")
        val view = View.inflate(this, R.layout.find_player_view, null)
        val iv_bottom_feng = view.findViewById<ImageView>(R.id.iv_bottom_feng)
        if(judge.equals("index")){
            val data : IndexBean.Data? = i?.getSerializableExtra("data") as IndexBean.Data
            gsyVideo.setUp(data?.playUrl,false,"  ")
            video_title.text = data?.title
            video_cate.text = data?.category+"/"+ data?.duration!! /60+"'"+data.duration%60+"'"+"'"
            video_desc.text = data?.description
            Glide.with(this@VideoPlayerActivity).load(data.cover.blurred).into(iv_bottom_bg)
            Glide.with(this@VideoPlayerActivity).load(data.cover.feed).into(iv_bottom_feng)

        }else if(judge.equals("find")){
            val findData : FindSonBean.ItemListBean.DataBean? = i?.getSerializableExtra("findData") as FindSonBean.ItemListBean.DataBean
            gsyVideo.setUp(findData?.playUrl,false,"  ")
            video_title.text = findData?.title
            video_cate.text = findData?.category+"/"+ findData?.duration!! /60+"'"+findData.duration%60+"'"+"'"
            video_desc.text = findData?.description
            Glide.with(this@VideoPlayerActivity).load(findData?.cover?.blurred).into(iv_bottom_bg)
            Glide.with(this@VideoPlayerActivity).load(findData.cover?.feed).into(iv_bottom_feng)
        }else if(judge.equals("hot")){
            val hotData : HotBean.ItemListBean.DataBean? = i?.getSerializableExtra("hotdata") as HotBean.ItemListBean.DataBean
            gsyVideo.setUp(hotData?.playUrl,false,"  ")
            video_title.text = hotData?.title
            video_cate.text = hotData?.category+"/"+ hotData?.duration!! /60+"'"+hotData.duration%60+"'"+"'"
            video_desc.text = hotData?.description
            Glide.with(this@VideoPlayerActivity).load(hotData?.cover?.blurred).into(iv_bottom_bg)
            Glide.with(this@VideoPlayerActivity).load(hotData.cover?.feed).into(iv_bottom_feng)
        }

        gsyVideo.thumbImageViewLayout
        gsyVideo.setThumbImageView(view)
        gsyVideo.setIsTouchWiget(true)

//        CutVideo()

    }

    /**
     * 全屏切换
     */
    private fun CutVideo() {

        //设置全屏布局的容器
        orientationUtils = OrientationUtils(this, gsyVideo)
        gsyVideo.setIsTouchWiget(true)
        //关闭自动旋转
        gsyVideo.isRotateViewAuto = false;
        gsyVideo.isLockLand = false;
        gsyVideo.isShowFullAnimation = false;
        gsyVideo.isNeedLockFull = true;
        gsyVideo.fullscreenButton.setOnClickListener {
            //直接横屏

            orientationUtils.resolveByClick()
            //第一个true是判断是否隐藏ActionBar  第二个true判断是否隐藏statusbar
            gsyVideo.startWindowFullscreen(this@VideoPlayerActivity, true, true)
        }

    }

}
