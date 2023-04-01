package com.dropbox.pokedex.treehouse.presenter


// TODO(Follow up)
interface HttpClient {
    suspend fun call(url: String, headers: Map<String, String>): String
}
