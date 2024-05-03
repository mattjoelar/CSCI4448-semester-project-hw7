package org.example

import com.google.gson.Gson

class NetworkMessage {
    private lateinit var message : String

    constructor(data : Map<*, *>) {
        message = Gson().toJson(data)
    }
    constructor(data : String) {
        message = data
    }

    fun getData() : String {
        return message
    }
    public fun asMap() : Map<*, *> {
        return Gson().fromJson(message, Map::class.java)
    }
}