package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class Comic {
    var id: String? = null
    var digitalId: String? = null
    var title: String? = null
    var issueNumber: String? = null
    var variantDescription: String? = null
    var description: String? = null
    var modified: String? = null
    var isbn: String? = null
    var upc: String? = null
    var diamondCode: String? = null
    var ean: String? = null
    var issn: String? = null
    var format: String? = null
    var pageCount: String? = null
    var textObjects: List<TextObject>? = null
    var resourceURI: String? = null
    var urls: List<Url>? = null
    var series: Series? = null
    var variants: List<Variant>? = null
    var collections: List<Collection>? = null
    var collectedIssues: List<CollectedIssue>? = null
    var dates: List<Date>? = null
    var prices: List<Price>? = null
    var thumbnail: Thumbnail? = null
    var images: List<Image>? = null
    var creators: Creators? = null
    var characters: Characters? = null
    var stories: Stories? = null
    var events: Events? = null

    constructor(id: String?, digitalId: String?, title: String?,
                issueNumber: String?, variantDescription: String?,
                description: String?, modified: String?, isbn: String?,
                upc: String?, diamondCode: String?, ean: String?, issn: String?,
                format: String?, pageCount: String?, textObjects: List<TextObject>?,
                resourceURI: String?, urls: List<Url>?, series: Series?, variants: List<Variant>?,
                collections: List<Collection>?, collectedIssues: List<CollectedIssue>?, dates: List<Date>?,
                prices: List<Price>?, thumbnail: Thumbnail?, images: List<Image>?, creators: Creators?,
                characters: Characters?, stories: Stories?, events: Events?) {
        this.id = id
        this.digitalId = digitalId
        this.title = title
        this.issueNumber = issueNumber
        this.variantDescription = variantDescription
        this.description = description
        this.modified = modified
        this.isbn = isbn
        this.upc = upc
        this.diamondCode = diamondCode
        this.ean = ean
        this.issn = issn
        this.format = format
        this.pageCount = pageCount
        this.textObjects = textObjects
        this.resourceURI = resourceURI
        this.urls = urls
        this.series = series
        this.variants = variants
        this.collections = collections
        this.collectedIssues = collectedIssues
        this.dates = dates
        this.prices = prices
        this.thumbnail = thumbnail
        this.images = images
        this.creators = creators
        this.characters = characters
        this.stories = stories
        this.events = events
    }
}