package de.nebulit.todo.startsession.internal

import de.nebulit.todo.common.DelegatingCommandHandler
import de.nebulit.todo.startsession.internal.StartSessionCommand
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class StartsessionRessource(private var commandHandler: DelegatingCommandHandler) {



    @PostMapping("/startsession")
    fun processCommand(@RequestParam name:String,@RequestParam aggregateId:UUID) {
        commandHandler.handle(StartSessionCommand(name,aggregateId))
    }
}
