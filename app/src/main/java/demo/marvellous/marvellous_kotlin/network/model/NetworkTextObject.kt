package demo.marvellous.marvellous_kotlin.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by leslied on 20/03/2018.
 */
class NetworkTextObject {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("language")
    @Expose
    var language: String? = null
    @SerializedName("text")
    @Expose
    var text: String? = null
}