package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class Comics {
    var code: String? = null
    var status: String? = null
    var copyright: String? = null
    var attributionText: String? = null
    var attributionHTML: String? = null
    var data: Data? = null
    var etag: String? = null

    constructor(code: String?, status: String?, copyright: String?, attributionText: String?, attributionHTML: String?, data: Data?, etag: String?) {
        this.code = code
        this.status = status
        this.copyright = copyright
        this.attributionText = attributionText
        this.attributionHTML = attributionHTML
        this.data = data
        this.etag = etag
    }
}