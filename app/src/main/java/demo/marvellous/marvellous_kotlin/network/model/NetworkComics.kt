package demo.marvellous.marvellous_kotlin.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by leslied on 20/03/2018.
 */
class NetworkComics {
    @SerializedName("code")
    @Expose
    var code: String? = null
    @SerializedName("status")
    @Expose
    var status: String? = null
    @SerializedName("copyright")
    @Expose
    var copyright: String? = null
    @SerializedName("attributionText")
    @Expose
    var attributionText: String? = null
    @SerializedName("attributionHTML")
    @Expose
    var attributionHTML: String? = null
    @SerializedName("data")
    @Expose
    var data: NetworkData? = null
    @SerializedName("etag")
    @Expose
    var etag: String? = null
}