package de.nebulit.todo.startsession.internal

import de.nebulit.todo.events.SessionStartedEvent
import mu.KotlinLogging
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.modulith.events.CompletedEventPublications
import org.springframework.modulith.events.IncompleteEventPublications
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class DummyListener {

    private var logger = KotlinLogging.logger {}


    @ApplicationModuleListener
    fun onEvent(sessionStartedEvent: SessionStartedEvent) {
        logger.info { "Listener notified" }
        throw RuntimeException("Processing Failed")
    }
}
