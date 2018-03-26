package demo.marvellous.marvellous_kotlin.di.network

import android.content.Context
import dagger.Module
import dagger.Provides
import demo.marvellous.marvellous_kotlin.di.ContextModule
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import java.io.File

/**
 * Created by leslied on 26/03/2018.
 */

@Module(includes = arrayOf(ContextModule::class))
class NetworkModule {
    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message -> Timber.i(message) })
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    @Provides
    fun cache(cacheFile: File): Cache {
        return Cache(cacheFile, (10 * 1000 * 1000).toLong()) //10MB Cahe
    }

    @Provides
    fun cacheFile( context: Context): File {
        return File(context.cacheDir, "okhttp_cache")
    }

    @Provides
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build()
    }
}