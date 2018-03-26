package demo.marvellous.marvellous_kotlin.network

import demo.marvellous.marvellous_kotlin.utils.HashHelper
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by leslied on 25/03/2018.
 */
class MarvelIntercepter (private val timeStamp : Long, private val privateKey : String , private val publicKey : String): Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response? {
        val original = chain?.request()
        val originalHttpUrl = original?.url()

        val url = originalHttpUrl?.newBuilder()?.addQueryParameter("apikey", publicKey)?.addQueryParameter("hash", HashHelper.generate(timeStamp, privateKey, publicKey))?.addQueryParameter("ts", timeStamp.toString())?.build()

        // Request customization: add request headers
        val requestBuilder = original?.newBuilder()?.url(url)

        val request = requestBuilder?.build()
        return chain?.proceed(request)
    }
}