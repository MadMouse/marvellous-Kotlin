package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class StoryItem {
    var resourceURI: String? = null
    var name: String? = null
    var type: String? = null

    constructor(resourceURI: String?, name: String?, type: String?) {
        this.resourceURI = resourceURI
        this.name = name
        this.type = type
    }
}