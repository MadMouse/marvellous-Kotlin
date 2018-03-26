package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class EventItem {
    var resourceURI: String? = null
    var name: String? = null

    constructor(resourceURI: String?, name: String?) {
        this.resourceURI = resourceURI
        this.name = name
    }
}