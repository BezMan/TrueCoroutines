package com.example.truecallercoroutines

import java.net.URL

class NetworkUtils {

    internal companion object {

        fun fetchHtml(endpointUrl: String): String {
            val res = try {
                URL(endpointUrl).readText()
            } catch (e: Exception) {
                ""
            }
            return res
        }

    }

}
