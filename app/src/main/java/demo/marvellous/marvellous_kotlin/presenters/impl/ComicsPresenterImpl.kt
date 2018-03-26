package demo.marvellous.marvellous_kotlin.presenters.impl

import android.view.View
import demo.marvellous.marvellous_kotlin.core.model.Comic
import demo.marvellous.marvellous_kotlin.network.RestClient
import demo.marvellous.marvellous_kotlin.network.model.NetworkComic
import demo.marvellous.marvellous_kotlin.network.model.NetworkComics
import demo.marvellous.marvellous_kotlin.network.services.MarvelService
import demo.marvellous.marvellous_kotlin.presenters.BasePresenter
import demo.marvellous.marvellous_kotlin.presenters.ComicsPresenter
import demo.marvellous.marvellous_kotlin.storage.StorageNetworkToCoreConverter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by leslied on 20/03/2018.
 */
class ComicsPresenterImpl(private val comicPresenterView : ComicsPresenter.View) : BasePresenter, ComicsPresenter {
    override fun fetchAllComics() {
        val restClient = RestClient.getClient(BASE_URL,SRC_PRIVATE_KEY,SRC_PUBLIC_KEY, MarvelService::class.java);
        comicPresenterView.showProgress()
        compositeDisposable.add(
                restClient.getComicList().observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .doOnComplete({
                            comicPresenterView.hideProgress()
                        })
                        .subscribe({ networkComics: NetworkComics ->
                            var netResults: List<NetworkComic>? = networkComics.data?.results
                            comicPresenterView.onComicList(StorageNetworkToCoreConverter.convertNetworkToCoreComics(netResults));
                        }, { error ->
                            comicPresenterView.showError(error.message);
                            comicPresenterView.hideProgress()
                        })

        )
    }

    //TODO LHD  To be added to secure store and passed in via method paramters (Shared Preferences)
    val SRC_PUBLIC_KEY          : String = "c3013e6978433ba945d2d0a9b31a7cd7"
    val SRC_PRIVATE_KEY         : String = "616917b5d9014f7c4a5a7240a0ca4cecd8c773ad"
    val BASE_URL                : String = "https://gateway.marvel.com:443"


    //Marl the Comic as favourite
    override fun onFavouriteButtonClicked(v: View?, comicItem: Comic) {
        comicPresenterView.onFavouriteButtonClicked(v, comicItem)
    }

    //handle On Item click get Details and display Detail Page.
    override fun onComicItemClicked(reference: String) {
        comicPresenterView.onComicItemClicked(reference)
    }

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun resume() {
        fetchAllComics();
    }

    override fun pause() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun destroy() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}