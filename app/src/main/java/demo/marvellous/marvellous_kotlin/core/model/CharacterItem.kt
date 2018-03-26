package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class CharacterItem {
    val resourceURI: String?
    val name: String?
    val role: String?

    constructor(resourceURI: String?, name: String?, role: String?) {
        this.resourceURI = resourceURI
        this.name = name
        this.role = role
    }


}