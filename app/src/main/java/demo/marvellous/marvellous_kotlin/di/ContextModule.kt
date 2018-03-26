package demo.marvellous.marvellous_kotlin.di

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by leslied on 26/03/2018.
 */
@Module
class ContextModule(context: Context) {

    private val context: Context

    init {
        this.context = context.applicationContext
    }

    @Provides
    fun context(): Context {
        return context
    }
}