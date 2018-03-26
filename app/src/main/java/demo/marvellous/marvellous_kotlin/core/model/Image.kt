package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class Image {
    var path: String? = null
    var extension: String? = null

    constructor(path: String?, extension: String?) {
        this.path = path
        this.extension = extension
    }
}