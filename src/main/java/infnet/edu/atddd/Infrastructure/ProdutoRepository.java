package infnet.edu.atddd.Infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import infnet.edu.atddd.Domain.Models.ProdutoDTO;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoDTO, String> {

}
