package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class CreatorItem {
    var resourceURI: String? = null
    var name: String? = null
    var role: String? = null

    constructor(resourceURI: String?, name: String?, role: String?) {
        this.resourceURI = resourceURI
        this.name = name
        this.role = role
    }
}