package de.nebulit.todo.activesessions.internal

import de.nebulit.todo.common.ReadModel
import de.nebulit.todo.common.persistence.InternalEvent
import java.util.*
import java.util.UUID


class ActiveSessionReadModel : ReadModel<ActiveSessionReadModel> {

	var name:String? = null;
	var sessionId:UUID? = null;

    override fun applyEvents(events: List<InternalEvent>): ActiveSessionReadModel {
        events.forEach({
            //TODO
        })
        return this
    }

}



