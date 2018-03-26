package demo.marvellous.marvellous_kotlin.core.model

/**
 * Created by leslied on 20/03/2018.
 */
class Data {

    var offset: String? = null
    var limit: String? = null
    var total: String? = null
    var count: String? = null
    var results: List<Comic>? = null

    constructor(offset: String?, limit: String?, total: String?, count: String?, results: List<Comic>?) {
        this.offset = offset
        this.limit = limit
        this.total = total
        this.count = count
        this.results = results
    }
}