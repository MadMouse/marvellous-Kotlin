package demo.marvellous.marvellous_kotlin.utils

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import java.security.NoSuchAlgorithmException

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

/**
 * Created by leslied on 20/03/2018.
 */
class HashHelperSpek : Spek ({

    val SRC_PUBLIC_KEY          : String = "54306733de0f5cd1418aa05a85fa062a"
    val SRC_PRIVATE_KEY         : String = "5de1fabcda2ea08912bd8b09bca4321f50563655"
    val SRC_TIMESTAMP           : Long = 1521586012;
    val SRC_INPUT_STRING        : String = "input_string";

    val RESULT_HASH_EXCPECTED   : String = "7dcc26fc9666a42410543f1fd90fd47f";
    val RESULT_MD5_EXPECTED     : String = "c07c07c15b65a863eccf6151c9471cd6"

    given("API keys and TimeStamp"){
        on("Generate Hash"){
            var newApiKey : String? = HashHelper.generate(SRC_TIMESTAMP, SRC_PRIVATE_KEY, SRC_PUBLIC_KEY);
            it("Should return the MD5 hash of Timestamp + private key + public key") {
                assertEquals(newApiKey, RESULT_HASH_EXCPECTED);
            }
        }

        on("Generate MD5"){
            var newHash : String? = HashHelper.md5(SRC_INPUT_STRING);
            it("should return the MD5 hash of the input string") {
                assertEquals(newHash, RESULT_MD5_EXPECTED);
            }
        }
    }
})