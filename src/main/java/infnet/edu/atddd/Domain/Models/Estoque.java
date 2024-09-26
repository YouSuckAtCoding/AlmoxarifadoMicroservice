package infnet.edu.atddd.Domain.Models;

import java.util.UUID;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateLifecycle;

import infnet.edu.atddd.Contracts.CreateEstoqueRequest;
import infnet.edu.atddd.Contracts.UpdateEstoqueRequest;
import infnet.edu.atddd.Domain.Commands.Pedido_AlmoxarifadoCreateCommand;
import infnet.edu.atddd.Domain.Primitives.AggregateRoot;
import infnet.edu.atddd.Events.Pedido_AlmoxarifadoEvent;
import jakarta.persistence.Entity;

@Entity
public class Estoque extends AggregateRoot{

    public String produtoId;
    public int quantidade;

    public Estoque(){}

    public Estoque(String id, String produtoId, int quantidade) {
        super(id);
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Estoque(String produtoId, int quantidade) {
        this.id = UUID.randomUUID().toString();
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public static Estoque MapCreateRequestToEstoque(CreateEstoqueRequest request) {
        return new Estoque(request.produtoId,request.quantidade);
    }

    public static Estoque MapUpdateRequestToEstoque(UpdateEstoqueRequest request) {
        return new Estoque(request.id,request.produtoId,request.quantidade);
    }

    @CommandHandler
    public Estoque(Pedido_AlmoxarifadoCreateCommand command)
    {
        AggregateLifecycle.apply(
            new Pedido_AlmoxarifadoEvent(command.id, command.pedidoId, command.produtoId, command.quantidade)
        );
    }

    @EventSourcingHandler
    protected void on(Pedido_AlmoxarifadoEvent event)
    {
        this.id = event.id;
        this.produtoId = event.produtoId;
        this.quantidade =  event.quantidade;
    }

    public void processar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'processar'");
    }

}
