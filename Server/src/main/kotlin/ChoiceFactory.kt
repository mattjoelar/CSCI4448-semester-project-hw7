package org.example

object ChoiceFactory {
    // Possibly helpful: https://stackoverflow.com/questions/40244386/format-json-strings-intellij
    public fun createSwitchProjectmonChoice(swapToIndex : Int) : NetworkMessage {
        return NetworkMessage("{\n" +
                "\"choice\" : \"switchPjmn\",\n" +
                "\"pjmnIdx\" : \"${swapToIndex}\"\n" +
                "}")
    }

    public fun createUseMoveChoice(moveIndex : Int) : NetworkMessage {
        return NetworkMessage("{\n" +
                "\"choice\" : \"useMove\",\n" +
                "\"moveIdx\" : \"${moveIndex}\"\n" +
                "}")
    }

    public fun forfeit() : NetworkMessage {
        return NetworkMessage("{\n" +
            "\"choice\" : \"forfeit\",\n" +
            "}")
    }
}