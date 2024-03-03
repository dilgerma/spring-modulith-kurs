package de.nebulit.todo.events

import de.nebulit.todo.common.Event
import java.util.UUID


data class SessionStartedEvent(var name:String,var aggregateId:UUID) : Event
