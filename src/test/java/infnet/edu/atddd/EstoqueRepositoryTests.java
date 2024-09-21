package infnet.edu.atddd;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import infnet.edu.atddd.Domain.Models.Estoque;
import infnet.edu.atddd.Infrastructure.EstoqueRepository;

@SpringBootTest
public class EstoqueRepositoryTests {

    @Autowired
    private EstoqueRepository repository;

    @Test
    void Should_Create_Estoque()
    {
        Estoque estoque = new Estoque(UUID.randomUUID().toString(), 2);

        var result = repository.save(estoque);

        Assert.isTrue(result.id != "", "Created");

    }

    @Test
    void Should_Update_Estoque()
    {
        Estoque estoque = new Estoque(UUID.randomUUID().toString(), 2);

        var saved = repository.save(estoque);

       var newQtd = 6;
       
       saved.quantidade = newQtd;

       var result = repository.save(saved);

       Assert.isTrue(result.quantidade == newQtd && result.id == saved.id ,"Updated");

    }
}
