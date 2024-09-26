package infnet.edu.atddd.Domain.Commands;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import infnet.edu.atddd.Contracts.Pedido_AlmoxarifadoEventRecieved;

@Service    
public class Pedido_AlmoxarifadoCommandHandler implements IPedido_AlmoxarifadoCommandHandler {
@Autowired
    private CommandGateway _gateway;

    @Override
    public CompletableFuture<String> CreatePedido_AlmoxarifadoEvent(Pedido_AlmoxarifadoEventRecieved request)
    {
        return _gateway.send(new Pedido_AlmoxarifadoCreateCommand(
            UUID.randomUUID().toString(), 
            request.pedidoId,
            request.produtoId,
            request.quantidade));
    }
}   
