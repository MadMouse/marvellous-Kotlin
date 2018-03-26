package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class CollectedIssue {

    val resourceURI: String?
    val name: String?

    constructor(resourceURI: String?, name: String?) {
        this.resourceURI = resourceURI
        this.name = name
    }
}