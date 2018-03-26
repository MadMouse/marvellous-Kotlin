package demo.marvellous.marvellous_kotlin.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by leslied on 20/03/2018.
 */
class NetworkDate {
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("date")
    @Expose
    var date: String? = null
}