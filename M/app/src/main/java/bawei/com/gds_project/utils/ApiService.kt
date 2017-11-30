package bawei.com.gds_project.utils

import bawei.com.gds_project.bean.FindBean
import bawei.com.gds_project.bean.FindSonBean
import bawei.com.gds_project.bean.HotBean
import bawei.com.gds_project.bean.IndexBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by dell-pc on 2017/11/27.
 */
interface ApiService {

    /**
     * 获取首页的数据
     */
    @GET("v2/feed?num=1&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getIndexData() : Flowable<IndexBean.Bean>

    /**
     *  获取首页第一页之后的数据 ?date=1499043600000&num=2
     */
    @GET("v2/feed")
    fun getIndexMoreData(@Query("date") date :String,@Query("num") num :String) : Flowable<IndexBean>

    /**
     * 发现页面接口
     */
    @GET("v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83")
    fun getFindData() :Flowable<List<FindBean>>

    /**
     * 发现详情接口
     */
    @GET("v3/videos")
    fun getFindMoreData(@Query("strategy") strategy:String,
                        @Query("udid") udid:String,@Query("vc") vc:Int,
                        @Query("categoryName") categoryName : String,@Query("start") start : Int) : Flowable<FindSonBean>

    /**
     * 热门排行
     */
    @GET("v3/ranklist?strategy=%s")
    fun getHotData(@Query("num") num :Int,@Query("strategy") strategy : String,
                   @Query("udid") udid :String,@Query("vc") vc :Int) : Flowable<HotBean>

    /**
     * 关键词搜索
     */
    @GET("v1/search")
    fun getSearchData(@Query("num") num : Int,@Query("query") query : String,@Query("start") start : Int) : Flowable<HotBean>

}