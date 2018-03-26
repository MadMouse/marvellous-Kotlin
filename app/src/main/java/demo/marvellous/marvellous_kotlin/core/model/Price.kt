package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class Price {
    var type: String? = null
    var price: String? = null

    constructor(type: String?, price: String?) {
        this.type = type
        this.price = price
    }
}