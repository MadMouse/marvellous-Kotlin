package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class Creators {
    var available: String? = null
    var returned: String? = null
    var collectionURI: String? = null
    var items: List<CreatorItem>? = null

    constructor(available: String?, returned: String?, collectionURI: String?, items: List<CreatorItem>?) {
        this.available = available
        this.returned = returned
        this.collectionURI = collectionURI
        this.items = items
    }
}