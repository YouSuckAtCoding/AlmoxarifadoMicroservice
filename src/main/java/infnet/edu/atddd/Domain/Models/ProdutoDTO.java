package infnet.edu.atddd.Domain.Models;

import infnet.edu.atddd.Domain.Primitives.EntityRoot;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class ProdutoDTO  extends EntityRoot  {

    public String name;
    public double price;
    public int type;

    public ProdutoDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    

}
