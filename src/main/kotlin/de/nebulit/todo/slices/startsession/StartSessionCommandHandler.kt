package de.nebulit.todo.slices.startsession

import de.nebulit.todo.common.*
import de.nebulit.todo.common.persistence.InternalEvent
import org.springframework.stereotype.Component
import org.springframework.context.ApplicationEventPublisher
import de.nebulit.todo.domain.ToDoAggregate
import java.util.UUID


@Component
class StartSessionCommandCommandHandler(
    private var aggregateService: AggregateService<ToDoAggregate>,
    private var applicationEventPublisher: ApplicationEventPublisher
) : BaseCommandHandler<ToDoAggregate>(aggregateService) {

    override fun handle(inputCommand: Command): List<InternalEvent> {
        assert(inputCommand is StartSessionCommand)
        val command = inputCommand as StartSessionCommand
        val aggregate = findAggregate(command.aggregateId)
        // TODO process logic
        aggregateService.persist(aggregate)
        aggregate.events.forEach {
             applicationEventPublisher.publishEvent(it.value as Any)
        }
        return aggregate.events
    }

    override fun supports(command: Command): Boolean {
        return command is StartSessionCommand
    }

}
