package demo.marvellous.marvellous_kotlin.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by leslied on 20/03/2018.
 */
class NetworkData {
    @SerializedName("offset")
    @Expose
    var offset: String? = null
    @SerializedName("limit")
    @Expose
    var limit: String? = null
    @SerializedName("total")
    @Expose
    var total: String? = null
    @SerializedName("count")
    @Expose
    var count: String? = null
    @SerializedName("results")
    @Expose
    var results: List<NetworkComic>? = null
}