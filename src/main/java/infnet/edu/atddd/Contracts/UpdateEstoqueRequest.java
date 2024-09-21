package infnet.edu.atddd.Contracts;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateEstoqueRequest {
   
    @NotBlank
    @NotNull
    public String id;
    
    @NotBlank
    @NotNull
    public String produtoId;
    
    @NotBlank
    @NotNull
    @Min(1)
    public int quantidade;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getProdutoId() {
        return produtoId;
    }
    public void setProdutoId(String produtoId) {
        this.produtoId = produtoId;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
}
