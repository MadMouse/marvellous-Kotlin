package demo.marvellous.marvellous_kotlin.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by leslied on 20/03/2018.
 */
class NetworkComic {
    @SerializedName("id")
    @Expose
    var id: String? = null
    @SerializedName("digitalId")
    @Expose
    var digitalId: String? = null
    @SerializedName("title")
    @Expose
    var title: String? = null
    @SerializedName("issueNumber")
    @Expose
    var issueNumber: String? = null
    @SerializedName("variantDescription")
    @Expose
    var variantDescription: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("modified")
    @Expose
    var modified: String? = null
    @SerializedName("isbn")
    @Expose
    var isbn: String? = null
    @SerializedName("upc")
    @Expose
    var upc: String? = null
    @SerializedName("diamondCode")
    @Expose
    var diamondCode: String? = null
    @SerializedName("ean")
    @Expose
    var ean: String? = null
    @SerializedName("issn")
    @Expose
    var issn: String? = null
    @SerializedName("format")
    @Expose
    var format: String? = null
    @SerializedName("pageCount")
    @Expose
    var pageCount: String? = null
    @SerializedName("textObjects")
    @Expose
    var textObjects: List<NetworkTextObject>? = null
    @SerializedName("resourceURI")
    @Expose
    var resourceURI: String? = null
    @SerializedName("urls")
    @Expose
    var urls: List<NetworkUrl>? = null
    @SerializedName("series")
    @Expose
    var series: NetworkSeries? = null
    @SerializedName("variants")
    @Expose
    var variants: List<NetworkVariant>? = null
    @SerializedName("collections")
    @Expose
    var collections: List<NetworkCollection>? = null
    @SerializedName("collectedIssues")
    @Expose
    var collectedIssues: List<NetworkCollectedIssue>? = null
    @SerializedName("dates")
    @Expose
    var dates: List<NetworkDate>? = null
    @SerializedName("prices")
    @Expose
    var prices: List<NetworkPrice>? = null
    @SerializedName("thumbnail")
    @Expose
    var thumbnail: NetworkThumbnail? = null
    @SerializedName("images")
    @Expose
    var images: List<NetworkImage>? = null
    @SerializedName("creators")
    @Expose
    var creators: NetworkCreators? = null
    @SerializedName("characters")
    @Expose
    var characters: NetworkCharacters? = null
    @SerializedName("stories")
    @Expose
    var stories: NetworkStories? = null
    @SerializedName("events")
    @Expose
    var events: NetworkEvents? = null

}