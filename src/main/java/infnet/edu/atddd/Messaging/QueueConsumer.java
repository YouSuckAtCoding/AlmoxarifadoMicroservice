package infnet.edu.atddd.Messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import infnet.edu.atddd.Contracts.Pedido_AlmoxarifadoEventRecieved;
import infnet.edu.atddd.Domain.Commands.IPedido_AlmoxarifadoCommandHandler;

@Component
public class QueueConsumer {

    @Autowired
    private IPedido_AlmoxarifadoCommandHandler handler;

    @RabbitListener(queues = "${queue.name}")
    public void reciever(@Payload String fileBody)
    {
        Pedido_AlmoxarifadoEventRecieved event = Pedido_AlmoxarifadoEventRecieved.Map(fileBody);
        handler.CreatePedido_AlmoxarifadoEvent(event);

        System.out.println("Message " + fileBody);
    }
}