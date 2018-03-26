package demo.marvellous.marvellous_kotlin.storage

import com.google.gson.Gson
import demo.marvellous.marvellous_kotlin.network.model.NetworkComic

/**
 * Created by leslied on 20/03/2018.
 */
class StorageTestUtils {
    companion object {
        fun getComicSingle(): NetworkComic {
            var gson : Gson = Gson();
            var jsonString : String = this.javaClass.getResource("/raw/comic_item.json").readText()

            var comicObject : NetworkComic = gson.fromJson(jsonString, NetworkComic::class.java);
            return comicObject;
        }


        fun getComicList(): List<NetworkComic> {
            var gson : Gson = Gson();


            var jsonString : String = this.javaClass.getResource("/raw/comic_array.json").readText()


            var comicList: List<NetworkComic> = gson.fromJson(jsonString,Array<NetworkComic>::class.java).toList();

            return comicList;
        }
    }
}