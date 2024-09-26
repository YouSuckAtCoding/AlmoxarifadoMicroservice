package infnet.edu.atddd.Domain.Commands;

import infnet.edu.atddd.Domain.Primitives.Command;

public class Pedido_AlmoxarifadoCreateCommand extends Command<String>{
    
    public String pedidoId;
    public String produtoId;
    public int quantidade;

    public Pedido_AlmoxarifadoCreateCommand(String id, String pedidoId, String produtoId, int quantidade) {
        super(id);
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }
    
}
