package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class Characters {

    val available: String?
    val returned: String?
    var collectionURI: String?
    val items: List<CharacterItem>?

    constructor(available: String?, returned: String?, collectionURI: String?, items: List<CharacterItem>?) {
        this.available = available
        this.returned = returned
        this.collectionURI = collectionURI
        this.items = items
    }
}