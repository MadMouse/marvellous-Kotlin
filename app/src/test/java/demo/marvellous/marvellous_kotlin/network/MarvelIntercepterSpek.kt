package demo.marvellous.marvellous_kotlin.network

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.junit.Assert.assertEquals


/**
 * Created by leslied on 25/03/2018.
 */
class MarvelIntercepterSpek : Spek ({

    val SRC_PUBLIC_KEY          : String = "54306733de0f5cd1418aa05a85fa062a"
    val SRC_PRIVATE_KEY         : String = "5de1fabcda2ea08912bd8b09bca4321f50563655"
    val SRC_TIMESTAMP           : Long = 1521586012;
    val SRC_HASH_EXCPECTED      : String = "7dcc26fc9666a42410543f1fd90fd47f";
    val BASE_URL                : String = "https://gateway.marvel.com"

    val RESULT_EXPECTED_PATH   : String = "/?apikey=" + SRC_PUBLIC_KEY + "&hash=" + SRC_HASH_EXCPECTED + "&ts=" + SRC_TIMESTAMP;


    given("API keys and TimeStamp to Test Intercepter"){
        val mockWebServer : MockWebServer = MockWebServer()
        beforeGroup {
            mockWebServer.start()
            mockWebServer.enqueue(MockResponse())
        }

        on("Run Marvel Interceptor"){

            val okHttpClient = OkHttpClient().newBuilder()
                    .addInterceptor(MarvelIntercepter(timeStamp = SRC_TIMESTAMP, privateKey = SRC_PRIVATE_KEY, publicKey = SRC_PUBLIC_KEY)).build()
            okHttpClient.newCall(Request.Builder().url(mockWebServer.url("/")).build()).execute()

            val request = mockWebServer.takeRequest()

            it("Should return URL with parameters hash, apikey, ts") {
                assertEquals(request.path, RESULT_EXPECTED_PATH);
            }
        }

        afterGroup {
            mockWebServer.shutdown();
        }

    }
})