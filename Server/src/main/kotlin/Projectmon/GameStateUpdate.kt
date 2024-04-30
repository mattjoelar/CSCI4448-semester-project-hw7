package org.example.Projectmon

import org.example.Creatures.ProjectmonData
import org.example.NetworkMessage

data class GameStateUpdate(
    val projectmonDataPlayerOne : ProjectmonData,
    val projectmonDataPlayerTwo : ProjectmonData
) {

    // This needs to be written out
    fun toNetworkMessage() : NetworkMessage {
        return NetworkMessage("JSON string goes here")
    }
}