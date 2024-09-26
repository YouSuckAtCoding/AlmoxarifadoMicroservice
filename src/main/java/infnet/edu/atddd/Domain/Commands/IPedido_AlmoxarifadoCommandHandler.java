package infnet.edu.atddd.Domain.Commands;

import java.util.concurrent.CompletableFuture;

import infnet.edu.atddd.Contracts.Pedido_AlmoxarifadoEventRecieved;

public interface IPedido_AlmoxarifadoCommandHandler {

    CompletableFuture<String> CreatePedido_AlmoxarifadoEvent(Pedido_AlmoxarifadoEventRecieved request);

}