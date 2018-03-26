package demo.marvellous.marvellous_kotlin.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by leslied on 20/03/2018.
 */
class NetworkStories {
    @SerializedName("available")
    @Expose
    var available: String? = null
    @SerializedName("returned")
    @Expose
    var returned: String? = null
    @SerializedName("collectionURI")
    @Expose
    var collectionURI: String? = null
    @SerializedName("items")
    @Expose
    var items: List<NetworkStoryItem>? = null
}