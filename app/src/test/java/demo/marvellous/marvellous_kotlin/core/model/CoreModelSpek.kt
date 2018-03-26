package demo.marvellous.marvellous_kotlin.core.model

import demo.marvellous.marvellous_kotlin.utils.HashHelper
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.*

/**
 * Created by leslied on 26/03/2018.
 */
class CoreModelSpek : Spek ({

    //TODO LHD Test Objects for Models need to be completed - Demo indicates intent and needs to be completed for Production Code.

    given("TextObject Model") {
        val SRC_TYPE        : String = "TYPE";
        val SRC_LANGUAGE    : String = "language";
        val SRC_TEXT        : String = "TextObject TextObject TextObject TextObject";

        on("Create Url") {
            var testItem: TextObject = TextObject(SRC_TYPE, SRC_LANGUAGE, SRC_TEXT);
            it("Should return same TYPE") {
                assertEquals(testItem.type, SRC_TYPE);
            }
            it("Should return same LANGUAGE") {
                assertEquals(testItem.language, SRC_LANGUAGE);
            }
            it("Should return same TEXT") {
                assertEquals(testItem.text, SRC_TEXT);
            }
        }
    }

    given("Thumbnail Model") {
        val SRC_EXTENSION   : String = "extension";
        val SRC_PATH        : String = "http://www.test.com";

        on("Create Url") {
            var testItem: Thumbnail = Thumbnail(SRC_PATH, SRC_EXTENSION);
            it("Should return same PATH") {
                assertEquals(testItem.path, SRC_PATH);
            }
            it("Should return same EXTENSION") {
                assertEquals(testItem.extension, SRC_EXTENSION);
            }
        }
    }

    given("Url Model") {
        val SRC_TYPE    : String = "type";
        val SRC_URL     : String = "http://www.test.com";

        on("Create Url") {
            var testItem: Url = Url(SRC_TYPE,SRC_URL);
            it("Should return same TYPE") {
                assertEquals(testItem.type, SRC_TYPE);
            }
            it("Should return same URL") {
                assertEquals(testItem.url, SRC_URL);
            }
        }
    }

    given("Variant Model") {
        val SRC_NAME          : String = "name";
        val SRC_RESOURCEURL   : String = "resourceUrl";

        on("Create Variant") {
            var testItem: Variant = Variant(SRC_RESOURCEURL,SRC_NAME);
            it("Should return same name") {
                assertEquals(testItem.name, SRC_NAME);
            }
            it("Should return same resoureUrl") {
                assertEquals(testItem.resourceURI, SRC_RESOURCEURL);
            }
        }
    }



})