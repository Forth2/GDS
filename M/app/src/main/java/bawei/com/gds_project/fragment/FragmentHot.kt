package bawei.com.gds_project.fragment

import android.os.Build
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toolbar
import bawei.com.gds_project.R
import bawei.com.gds_project.fragment.hot_fragments.FragmentYue
import bawei.com.gds_project.fragment.hot_fragments.FragmentZhou
import bawei.com.gds_project.fragment.hot_fragments.FragmentZong
import bawei.com.gds_project.utils.BaseFragment

/**
 * Created by 999 on 2017/11/27.
 */

class FragmentHot : BaseFragment(){

    override fun getLayoutResources(): Int {
        return R.layout.fragment_hot
    }

    override fun initView() {
        var tabs = view?.findViewById<TabLayout>(R.id.fragment_hot_tabs)
        var tab_list = listOf<String>("周排行", "月排行", "总排行")

        for ( s  in tab_list.toList()) {
            tabs?.addTab(tabs?.newTab().setText(s))
        }

        var vp = view?.findViewById<ViewPager>(R.id.fragment_hot_vp)
        var fragments = listOf<Fragment>(FragmentZhou(),FragmentYue(),FragmentZong())
        vp?.adapter = PageAdapter(fragmentManager,fragments,tab_list)
        tabs?.setupWithViewPager(vp)
    }

    class PageAdapter (fm : FragmentManager?, var list : List<Fragment>, var tablist : List<String>): FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return list.get(position)
        }

        override fun getCount(): Int {
            return list.size
        }

        override fun getPageTitle(position: Int): CharSequence {
            return tablist.get(position)
        }
    }

    /* override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

         var  a = inflater?.inflate(R.layout.fragment_hot,container,false)
         return a
     }

     override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
         super.onViewCreated(view, savedInstanceState)
         var tabs = view?.findViewById<TabLayout>(R.id.fragment_hot_tabs)
         var tab_list = listOf<String>("周排行", "月排行", "总排行")
         for ( s  in tab_list.toList()) {
             tabs?.addTab(tabs?.newTab().setText(s))
         }
         var vp = view?.findViewById<ViewPager>(R.id.fragment_hot_vp)
         var fragments = listOf<Fragment>(FragmentZhou(),FragmentYue(),FragmentZong())
         vp?.adapter = PageAdapter(fragmentManager,fragments,tab_list)
 //        vp?.setOffscreenPageLimit(3)
         //未关联 viewpage tablayout
         tabs?.setupWithViewPager(vp)
     }

     class PageAdapter (fm : FragmentManager?, var list : List<Fragment>, var tablist : List<String>): FragmentPagerAdapter(fm) {

         override fun getItem(position: Int): Fragment {
             return list.get(position)
         }

         override fun getCount(): Int {
             return list.size
         }

         override fun getPageTitle(position: Int): CharSequence {
             return tablist.get(position)
         }
     }*/
}