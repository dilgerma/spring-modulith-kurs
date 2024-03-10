package de.nebulit.todo.activesessions.internal

import de.nebulit.todo.startsession.internal.StartSessionCommandCommandHandler
import org.springframework.stereotype.Component

@Component
class TestService(var startSessionCommandCommandHandler: StartSessionCommandCommandHandler) {

}
