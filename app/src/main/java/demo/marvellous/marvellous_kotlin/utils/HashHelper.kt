package demo.marvellous.marvellous_kotlin.utils

import android.provider.SyncStateContract.Helpers.update
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


/**
 * Created by leslied on 20/03/2018.
 */
class HashHelper {
    companion object {

        fun generate(timestamp: Long, privateKey: String, publicKey: String): String? {
            val concatResult = timestamp.toString() + privateKey + publicKey
            return md5(concatResult)
        }


        @Throws(NoSuchAlgorithmException::class)
        fun md5(s: String): String {
            // Create MD5 Hash
            val digest = MessageDigest.getInstance("MD5")
            digest.update(s.toByteArray())
            val messageDigest = digest.digest()
            val bigInt = BigInteger(1, messageDigest)
            var hashText = bigInt.toString(16)
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashText.length < 32) {
                hashText = "0" + hashText
            }
            return hashText
        }


    }
}