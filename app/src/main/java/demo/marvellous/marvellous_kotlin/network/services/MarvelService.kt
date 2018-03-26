package demo.marvellous.marvellous_kotlin.network.services

import demo.marvellous.marvellous_kotlin.network.model.NetworkComics
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by leslied on 20/03/2018.
 */
interface MarvelService {
    @GET("/v1/public/comics")
    abstract fun getComicList(): Observable<NetworkComics>
}