package demo.marvellous.marvellous_kotlin.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by leslied on 20/03/2018.
 */
class NetworkStoryItem {
    @SerializedName("resourceURI")
    @Expose
    var resourceURI: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
}