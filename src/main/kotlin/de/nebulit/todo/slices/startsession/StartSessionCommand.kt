package de.nebulit.todo.slices.startsession

import de.nebulit.todo.common.Command
import java.util.UUID

data class StartSessionCommand(var name:String,override var aggregateId:UUID) : Command
