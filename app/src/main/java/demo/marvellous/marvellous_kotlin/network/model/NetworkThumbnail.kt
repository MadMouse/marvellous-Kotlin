package demo.marvellous.marvellous_kotlin.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by leslied on 20/03/2018.
 */
class NetworkThumbnail {
    @SerializedName("path")
    @Expose
    var path: String? = null
    @SerializedName("extension")
    @Expose
    var extension: String? = null
}