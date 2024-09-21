package infnet.edu.atddd;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import infnet.edu.atddd.Controllers.ProdutoController;
import infnet.edu.atddd.Domain.Models.Produto;

@SpringBootTest
public class ProdutoControllerTests {
  
    @Autowired
    private ProdutoController _Controller;
    @Test
    void Should_Get_All_Produtos_And_Return_200() {
        
        ResponseEntity<List<Produto>> result= _Controller.GetAll();

        Assert.isTrue(result.getStatusCode() == HttpStatus.OK, "oK");
    }
}
