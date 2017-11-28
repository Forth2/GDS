package bawei.com.gds_project.utils

import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by dell-pc on 2017/11/28.
 */
class ApiRetrofitUtils {

    private var retrofit: Retrofit? = null
    //单例设计模式
    //懒汉 只声明不创建 私有的静态的成员变量
    private var apiRetrofitUtils: ApiRetrofitUtils? = null

    //私有的构造方法
    private constructor() {
    }

    //提供一个公共的返回实例的静态方法
    fun getInstance(): ApiRetrofitUtils? {
        if (apiRetrofitUtils == null) {
            synchronized(ApiRetrofitUtils::class.java) {
                if (apiRetrofitUtils == null) {
                    apiRetrofitUtils = ApiRetrofitUtils()
                }
            }
        }
        return this!!.apiRetrofitUtils
    }

    /**
     * 返回retrofit实例
     */
    fun getRetrofit(path : String) : Retrofit? {

        val httpLoggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
            //打印retrofit日志
            Log.i("RetrofitLog", "retrofitBack = " + message)
        })

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(15,TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .writeTimeout(15,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()

        retrofit = Retrofit.Builder()
                .baseUrl(path)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        return retrofit
    }

    //封装参数的接口对象
    fun <T> getClientApi(cla: Class<T>, path: String): T {
        val retrofit = getRetrofit(path)
        return retrofit!!.create(cla)
    }

}