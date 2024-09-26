package infnet.edu.atddd.Contracts;

public class Pedido_AlmoxarifadoEventRecieved {

    public String pedidoId;
    public String produtoId;
    public int quantidade;
    
    public Pedido_AlmoxarifadoEventRecieved(String pedidoId, String produtoId, int quantidade) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public static Pedido_AlmoxarifadoEventRecieved Map(String fileBody) {
       return new Pedido_AlmoxarifadoEventRecieved("fileBody", "fileBody", 0);
    }
}
