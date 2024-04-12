package org.example

// HOW DO WE PARSE JSON STRINGS????
class ChoiceFactory {
    // Possibly helpful: https://stackoverflow.com/questions/40244386/format-json-strings-intellij
    public fun createSwitchProjectmonChoice(swapToIndex : Int) : Choice {
        return Choice("{\n" +
                "\"choice\" : \"switchPjmn\",\n" +
                "\"pjmnIdx\" : \"${swapToIndex}\"\n" +
                "}")
    }

    public fun createUseMoveChoice(moveIndex : Int) : Choice {
        return Choice("{\n" +
                "\"choice\" : \"useMove\",\n" +
                "\"pjmnIdx\" : \"${moveIndex}\"\n" +
                "}")
    }
}