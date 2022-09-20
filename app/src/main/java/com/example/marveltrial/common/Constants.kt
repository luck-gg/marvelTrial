package com.example.marveltrial.common

import com.example.marveltrial.BuildConfig
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        const val BASE_URL = "https://gateway.marvel.com/"
        val timestamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = BuildConfig.API_KEY
        const val PRIVATE_KEY = BuildConfig.PRIVATE_KEY
        const val LIMIT = 20
        fun hash(): String {
            val input = "$timestamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
        }
    }
}
