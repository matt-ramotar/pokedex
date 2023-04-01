package com.dropbox.pokedex.treehouse.presenter

interface HttpClient {
    suspend fun call(url: String, headers: Map<String, String>): String
}
