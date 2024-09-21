package infnet.edu.atddd.Contracts;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateProdutoRequest {
    
    @NotBlank
    @NotNull
    public String id;
    @NotBlank
    @NotNull
    public String name;
    @NotBlank
    @NotNull
    public double price;
    @NotBlank
    @NotNull
    public int type;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
