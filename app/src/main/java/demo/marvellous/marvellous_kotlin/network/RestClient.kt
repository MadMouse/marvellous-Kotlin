package demo.marvellous.marvellous_kotlin.network

import android.content.Context
import demo.marvellous.marvellous_kotlin.utils.HashHelper
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

/**
 * Created by leslied on 23/03/2018.
 */
class RestClient {

    companion object {

        fun <S> getClient(baseUrl: String, privateKey : String, publicKey : String, serviceClass: Class<S>): S {

            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)

            val timeStamp = Date().time;
            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(MarvelIntercepter(timeStamp, privateKey, publicKey))
                    .addInterceptor(logging)
                    .build()

            val retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            return retrofit.create(serviceClass)
        }
    }


}


