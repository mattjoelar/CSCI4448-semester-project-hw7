package Projectmon

import org.example.Arena
import org.example.MoveEffects.MoveDecorator

data class EntryMove(
    val name : String,
    val type : ProjectmonType,
    val pp : Int,
    val components : Array<MoveDecorator>
) {
    fun use(user : Projectmon, against : Projectmon, arena : Arena) : Array<String> {
        var messages : Array<String> = arrayOf<String>("${user.getName()} used ${this.name}!")

        for(component in components) {
            messages += component.apply(user, against, arena, type)
        }

        return messages
    }
}
