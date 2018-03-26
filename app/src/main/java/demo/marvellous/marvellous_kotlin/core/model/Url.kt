package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class Url {
    var type: String? = null
    var url: String? = null

    constructor(type: String?, url: String?) {
        this.type = type
        this.url = url
    }
}