package infnet.edu.atddd;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import infnet.edu.atddd.Contracts.CreateProductRequest;
import infnet.edu.atddd.Domain.Enum.Type_Prod;
import infnet.edu.atddd.Domain.Models.Produto;
import infnet.edu.atddd.Domain.Models.ProdutoDTO;

@SpringBootTest
public class ProdutoTests {

    @Test
    void Should_Map_CreateProdutoRequest_To_Produto_and_set_type_prod_Correctly() throws Exception
    { 
        CreateProductRequest request = new CreateProductRequest();
        request.setName("teste");
        request.setPrice(2000);
        request.setType(2);

        Produto prod = Produto.MapCreateRequestToProduto(request);

        Assert.isTrue(prod.type == Type_Prod.Passeio, "Mapped Correctly");
    }

    @Test
    void Should_Map_Protudo_To_ProdutoDTO_and_set_type_prod_Correctly() throws Exception
    { 
        CreateProductRequest request = new CreateProductRequest();
        request.setName("teste");
        request.setPrice(2000);
        request.setType(2);

        Produto prod = Produto.MapCreateRequestToProduto(request);

        ProdutoDTO DTO = Produto.MapProdutoToProdutoDTO(prod);

        Assert.isTrue(DTO.type == Type_Prod.Passeio.getValue(), "Mapped Correctly");
    }
}
