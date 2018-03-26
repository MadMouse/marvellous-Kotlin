package demo.marvellous.marvellous_kotlin.presenters

import android.view.View
import demo.marvellous.marvellous_kotlin.core.model.Comic

/**
 * Created by leslied on 20/03/2018.
 */
interface ComicsPresenter : BasePresenter {
    interface View : BaseView {

        fun onComicList(comicList: List<Comic>)

        fun onNoComicsFound()

        fun onComicItemClicked(reference: String)

        fun onFavouriteButtonClicked(v: android.view.View?, comicItem: Comic)

    }

    //Fetch Comics
    fun fetchAllComics();
    /**
     * Comic Item Favourite Pressed.
     */
    fun onFavouriteButtonClicked(v : android.view.View?, comicItem : Comic);
    /**
     * Comic Item Selected.
     */
    fun onComicItemClicked(reference : String);

}