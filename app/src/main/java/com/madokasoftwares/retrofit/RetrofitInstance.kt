package com.madokasoftwares.retrofit

import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities.*
import android.net.NetworkInfo
import android.os.Build
import androidx.core.content.ContextCompat.getSystemService
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//create an instance to make the actual requests
object RetrofitInstance {
    val api:TodoApi by lazy{ //by lazy meaning it will be intialized when we access this Api

            Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
               // .client(OkHttpClient())
                .build()
                .create(TodoApi::class.java) //class of our API

}



//fun getOkHttpClient(context: Context): OkHttpClient {
//    val cacheSize = (5 * 1024 * 1024).toLong()
//    val myCache = Cache(context.cacheDir, cacheSize)
//
//    return OkHttpClient.Builder()
//        .cache(myCache)
//        .addInterceptor { chain ->
//            var request = chain.request()
//            request = if (isNetworkAvailable(context)!!)
//                request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
//            else
//                request.newBuilder().header(
//                    "Cache-Control",
//                    "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
//                ).build()
//            chain.proceed(request)
//        }
//        .build()
//}
//

//private fun isNetworkAvailable(context: Context) : Boolean{ //checking for network
//    val connectivityManager = context
//        .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){ //for API above 26
//        val activeNetwork =connectivityManager.activeNetwork ?: return false
//        val capabilities = connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
//         return when {
//             capabilities.hasTransport(TRANSPORT_WIFI) -> true
//             capabilities.hasTransport(TRANSPORT_CELLULAR) -> true
//             capabilities.hasTransport(TRANSPORT_ETHERNET) -> true
//             else -> false
//         }
//    } else{ //for API below 26
//        connectivityManager.activeNetworkInfo?.run {
//            return when(type){
//                TYPE_WIFI -> true
//                TYPE_MOBILE -> true
//                TYPE_ETHERNET -> true
//
//                else -> false
//            }
//        }
//    }
//    return false
//}
//


   }




/**
fun isNetworkAvailable(context: Context): Boolean? {

    var isConnected: Boolean? = false // Initial Value
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
    if (activeNetwork != null && activeNetwork.isConnected)
        isConnected = true
    return isConnected

}
**/