package infnet.edu.atddd.Domain.Models;

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

}
