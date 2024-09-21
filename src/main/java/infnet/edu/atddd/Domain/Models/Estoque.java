package infnet.edu.atddd.Domain.Models;

import java.util.UUID;

import infnet.edu.atddd.Contracts.CreateEstoqueRequest;
import infnet.edu.atddd.Contracts.UpdateEstoqueRequest;
import infnet.edu.atddd.Domain.Primitives.AggregateRoot;
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

}
