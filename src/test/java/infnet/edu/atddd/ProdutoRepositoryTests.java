package infnet.edu.atddd;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import infnet.edu.atddd.Contracts.CreateProductRequest;
import infnet.edu.atddd.Domain.Models.Produto;
import infnet.edu.atddd.Infrastructure.ProdutoRepository;

@SpringBootTest
public class ProdutoRepositoryTests {
    
    @Autowired
    private ProdutoRepository _ProdutoRepository;
    @Test
    void SHould_Create_Produto() throws Exception
    {

        CreateProductRequest request = new CreateProductRequest();
        request.setName("teste");
        request.setPrice(2000);
        request.setType(2);

        Produto prod = Produto.MapCreateRequestToProduto(request);

        var result = _ProdutoRepository.save(Produto.MapProdutoToProdutoDTO(prod));

        Assert.isTrue(result.id != "","Created");

    }

    @Test
    void Should_Update_Produto() throws Exception
    {

        CreateProductRequest request = new CreateProductRequest();
        request.setName("teste");
        request.setPrice(2000);
        request.setType(2);

        Produto prod = Produto.MapCreateRequestToProduto(request);

        var saved = _ProdutoRepository.save(Produto.MapProdutoToProdutoDTO(prod));

        String newName = "Updated123";
        saved.setName(newName);

        var result = _ProdutoRepository.save(saved);

        Assert.isTrue(result.name == newName && result.id == saved.id ,"Updated");

    }
}
