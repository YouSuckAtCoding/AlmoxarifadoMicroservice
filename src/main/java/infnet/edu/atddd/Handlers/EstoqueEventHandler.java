package infnet.edu.atddd.Handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import infnet.edu.atddd.Domain.Models.Estoque;
import infnet.edu.atddd.Domain.Primitives.Event;
import infnet.edu.atddd.Events.Pedido_AlmoxarifadoEvent;
import infnet.edu.atddd.Infrastructure.EstoqueRepository;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingRepository;

public class EstoqueEventHandler {

    @Autowired
    private EstoqueRepository _repository;

    @Autowired
    @Qualifier("estoqueAggregateEventSourcingRepository")
    private EventSourcingRepository<Estoque> EstoqueEventSourcingRepository;

    @EventHandler
    void on(Pedido_AlmoxarifadoEvent event) {
        TratarRequisicao(event);
    }
    //Meramente ilustrativo, apenas para simbolizar onde seriam tratados os eventos.
    private Estoque TratarRequisicao(Event event) {

        var agregado = EstoqueEventSourcingRepository.load(event.id.toString()).getWrappedAggregate().getAggregateRoot();
        agregado.processar();
        _repository.save(agregado);
        return new Estoque();
    }

}
