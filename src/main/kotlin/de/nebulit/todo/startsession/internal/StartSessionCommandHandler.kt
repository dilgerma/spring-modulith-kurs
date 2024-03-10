package de.nebulit.todo.startsession.internal

import de.nebulit.todo.common.*
import de.nebulit.todo.common.persistence.InternalEvent
import org.springframework.stereotype.Component
import org.springframework.context.ApplicationEventPublisher
import de.nebulit.todo.domain.ToDoAggregate
import org.springframework.transaction.annotation.Transactional
import java.util.UUID


@Component
class StartSessionCommandCommandHandler(
    private var aggregateService: AggregateService<ToDoAggregate>,
    private var applicationEventPublisher: ApplicationEventPublisher
) : BaseCommandHandler<ToDoAggregate>(aggregateService) {

    @Transactional
    override fun handle(inputCommand: Command): List<InternalEvent> {
        assert(inputCommand is StartSessionCommand)
        val command = inputCommand as StartSessionCommand
        val aggregate = ToDoAggregate.newSession(command.aggregateId)
        aggregate.applyName(command.name)
        aggregateService.persist(aggregate)
        aggregate.events.forEach {
            it.value?.let { it1 -> applicationEventPublisher.publishEvent(it1) }
        }
        return aggregate.events
    }

    override fun supports(command: Command): Boolean {
        return command is StartSessionCommand
    }

}
