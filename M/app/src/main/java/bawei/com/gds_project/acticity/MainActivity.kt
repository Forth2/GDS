package bawei.com.gds_project.acticity

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import bawei.com.gds_project.R
import bawei.com.gds_project.fragment.FragmentFind
import bawei.com.gds_project.fragment.FragmentHot
import bawei.com.gds_project.fragment.FragmentIndex
import bawei.com.gds_project.fragment.FragmentMine
import com.hjm.bottomtabbar.BottomTabBar

class MainActivity : AppCompatActivity() {

    lateinit var bottom : BottomTabBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom = findViewById(R.id.bottom) as BottomTabBar

        bottom.init(getSupportFragmentManager())
                .setImgSize(50F, 50F)
                .setFontSize(8F)
                .setTabPadding(4F, 6F, 10F)
                .setChangeColor(Color.BLACK,Color.GRAY)
                .addTabItem("首页",R.mipmap.home_selected,R.mipmap.home_normal, FragmentIndex::class.java)
                .addTabItem("发现",R.mipmap.find_selected,R.mipmap.find_normal, FragmentFind::class.java)
                .addTabItem("热门",R.mipmap.hot_selected,R.mipmap.hot_normal, FragmentHot::class.java)
                .addTabItem("我的",R.mipmap.mine_selected, R.mipmap.mine_normal, FragmentMine::class.java)

    }
}
