package org.example

import netscape.javascript.JSObject

// This should return a JSON of player choice
/* Examples:

{
    Choice: SwitchPokemon
    Data: {
            swapToIdx: 3
    }
}

{
    Choice: UseItem
    Data: {
            itemIdx: 3
            pjmnIdx: 0
    }
}
 */
class ChoiceFactory {
    // Generate a choice from user input or something
    public fun createChoice() : JSObject {
        throw Exception("Not yet implemented!")
    }
}