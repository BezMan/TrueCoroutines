package com.example.truecallercoroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import java.net.URL

class NetworkUtils {

    companion object {

        suspend fun fetchHtml(endpointUrl: String): String {
            val res = CoroutineScope(Dispatchers.IO).async {
                try {
                    URL(endpointUrl).readText()
                } catch (e: Exception) {
                    ""
                }
            }
            return res.await()
        }

    }

}
