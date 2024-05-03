package org.example

/*  FACTORY + COMMAND PATTERN
While this returns JSON data structures instead of concrete classes, the end functionality of this class
and its outputs generally follow the factory and command pattern ideologies. Unique network messages are
created with different commands and the NetworkMessage JSON data is later passed on into other functions
that vary their functionality depending on its contents.
 */
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