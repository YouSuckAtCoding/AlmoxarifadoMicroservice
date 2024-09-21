package infnet.edu.atddd.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import infnet.edu.atddd.Contracts.CreateProductRequest;
import infnet.edu.atddd.Contracts.UpdateProdutoRequest;
import infnet.edu.atddd.Domain.Models.Produto;
import infnet.edu.atddd.Infrastructure.ProdutoRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class ProdutoController {

    public final static String Base = "api/Produto";
    public final static String GetAll = Base;
    public final static String Create = Base + "/create";
    public final static String Update = Base + "/update";

    @Autowired
    private ProdutoRepository _Repository;

    @GetMapping(GetAll)
    public ResponseEntity<List<Produto>> GetAll() {
        return new ResponseEntity<List<Produto>>(_Repository.findAll(), HttpStatus.OK);
    }

    @PostMapping(Create)
    public ResponseEntity<?> CreateProduto(@Valid @RequestBody CreateProductRequest request,
            BindingResult validation, HttpServletRequest httpServletRequest) throws Exception {

        if (validation.hasErrors()) {
            return ResponseEntity.badRequest().body(validation.getAllErrors().toString());
        }

        Produto prod = Produto.MapCreateRequestToProduto(request);
       
        Produto result;

        if (prod.name.value.length() > 0) {
            result = _Repository.save(prod);
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PutMapping(Update)
    public ResponseEntity<?> UpdateProduto(@Valid @RequestBody UpdateProdutoRequest request,
        BindingResult validation, HttpServletRequest httpServletRequest) throws Exception 
    {
        if (validation.hasErrors()) {
            return ResponseEntity.badRequest().body(validation.getAllErrors().toString());
        }

        Produto prod = Produto.MapUpdateRequestToProduto(request);
       
        Produto result;

        if (prod.name.value.length() > 0) {
            result = _Repository.save(prod);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
