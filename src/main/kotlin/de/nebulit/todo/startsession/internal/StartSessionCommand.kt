package de.nebulit.todo.startsession.internal

import de.nebulit.todo.common.Command
import java.util.UUID

data class StartSessionCommand(var name:String,override var aggregateId:UUID) : Command
