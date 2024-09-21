package infnet.edu.atddd.Domain.Models;

import infnet.edu.atddd.Contracts.CreateEstoqueRequest;
import infnet.edu.atddd.Contracts.UpdateEstoqueRequest;
import infnet.edu.atddd.Domain.Primitives.AggregateRoot;
import jakarta.persistence.Entity;

@Entity
public class Estoque extends AggregateRoot{

    public String produtoId;
    public int Qquantidade;

    public Estoque(){}

    public Estoque(String id, String produtoId, int qquantidade) {
        super(id);
        this.produtoId = produtoId;
        Qquantidade = qquantidade;
    }

    public Estoque(String produtoId, int qquantidade) {
        this.produtoId = produtoId;
        Qquantidade = qquantidade;
    }

    public static Estoque MapCreateRequestToEstoque(CreateEstoqueRequest request) {
        return new Estoque(request.produtoId,request.quantidade);
    }

    public static Estoque MapUpdateRequestToEstoque(UpdateEstoqueRequest request) {
        return new Estoque(request.id,request.produtoId,request.quantidade);
    }

}
