package infnet.edu.atddd.Events;

import infnet.edu.atddd.Domain.Primitives.Event;

public class Pedido_AlmoxarifadoEvent extends Event<String> {

    public String pedidoId;
    public String produtoId;
    public int quantidade;

    public Pedido_AlmoxarifadoEvent(String id, String pedidoId, String produtoId, int quantidade) {
        super(id);
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public static Pedido_AlmoxarifadoEvent Map(String fileBody) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Map'");
    }

}
