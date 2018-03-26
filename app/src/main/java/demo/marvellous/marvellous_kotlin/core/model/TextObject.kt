package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class TextObject {
    var type: String? = null
    var language: String? = null
    var text: String? = null

    constructor(type: String?, language: String?, text: String?) {
        this.type = type
        this.language = language
        this.text = text
    }
}