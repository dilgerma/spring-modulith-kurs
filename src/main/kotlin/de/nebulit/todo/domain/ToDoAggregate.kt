package de.nebulit.todo.domain

import de.nebulit.todo.common.AggregateRoot
import de.nebulit.todo.common.persistence.InternalEvent
import de.nebulit.todo.events.SessionStartedEvent
import jakarta.persistence.*
import org.hibernate.annotations.JdbcTypeCode
import java.sql.Types
import java.time.LocalDate
import java.util.*
import kotlin.jvm.Transient

@Entity
@Table(name = "aggregates")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Discriminator", discriminatorType = DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("ToDoAggregate")
class ToDoAggregate(
    @JdbcTypeCode(Types.VARCHAR) @Id override var aggregateId: UUID
) : AggregateRoot {

    override var version: Long? = 0

    @Transient
    override var events: MutableList<InternalEvent> = mutableListOf()

    override fun applyEvents(events: List<InternalEvent>): AggregateRoot {
        return this
    }

    fun applyName(name: String) {
        //validierung
        events.add(InternalEvent().apply {
            this.aggregateId = this@ToDoAggregate.aggregateId
            this.value = SessionStartedEvent(name, this@ToDoAggregate.aggregateId)
        })
    }

    companion object {
        fun newSession(aggregateId: UUID): ToDoAggregate {
            return ToDoAggregate(aggregateId)
        }
    }
}
