package demo.marvellous.marvellous_kotlin.storage

import demo.marvellous.marvellous_kotlin.core.model.Comic
import demo.marvellous.marvellous_kotlin.network.model.NetworkComic
import demo.marvellous.marvellous_kotlin.utils.HashHelper
import io.kotlintest.matchers.haveSize
import org.hamcrest.Matchers.hasSize
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.*

/**
 * Created by leslied on 26/03/2018.
 */
class StorageNetworkToCoreConverterSpek : Spek({
    //TODO LHD Tests for all public methods need tests and
    given("Array of Network Comics"){
        val networkComics : List<NetworkComic> = StorageTestUtils.getComicList();
        on("Convert to Core Comics Array"){
            val coreComics : List<Comic> = StorageNetworkToCoreConverter.convertNetworkToCoreComics(networkComics)
            it("Should return Same number of items") {
                assertThat(coreComics, hasSize(networkComics.size));
            }

            it("should return with redumentry check") {
                val networkComic : NetworkComic = networkComics.get(0);
                val comic : Comic = coreComics.get(0);
                assertEquals(networkComic.id, comic.id);
                assertEquals(networkComic.title, comic.title);
            }
        }
    }

})