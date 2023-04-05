package com.dropbox.pokedex.common.client


// TODO(Follow up)
fun interface HttpClient {
    suspend fun call(url: String, headers: Map<String, String>): String
}

