package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class Stories {

    var available: String? = null
    var returned: String? = null
    var collectionURI: String? = null
    var items: List<StoryItem>? = null

    constructor(available: String?, returned: String?, collectionURI: String?, items: List<StoryItem>?) {
        this.available = available
        this.returned = returned
        this.collectionURI = collectionURI
        this.items = items
    }
}