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

import infnet.edu.atddd.Contracts.CreateEstoqueRequest;
import infnet.edu.atddd.Contracts.UpdateEstoqueRequest;
import infnet.edu.atddd.Domain.Models.Estoque;
import infnet.edu.atddd.Infrastructure.EstoqueRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
public class EstoqueController {

    public final static String Base = "api/Estoque";
    public final static String GetAll = Base;
    public final static String Create = Base + "/create";
    public final static String Update = Base + "/update";

    @Autowired
    private EstoqueRepository _Repository;

    @GetMapping(GetAll)
    public ResponseEntity<List<Estoque>> GetAll() {
        return new ResponseEntity<List<Estoque>>(_Repository.findAll(), HttpStatus.OK);
    }

    @PostMapping(Create)
    public ResponseEntity<?> CreateEstoque(@Valid @RequestBody CreateEstoqueRequest request,
            BindingResult validation, HttpServletRequest httpServletRequest) throws Exception {

        if (validation.hasErrors()) {
            return ResponseEntity.badRequest().body(validation.getAllErrors().toString());
        }

        Estoque estoq = Estoque.MapCreateRequestToEstoque(request);

        Estoque result;

        result = _Repository.save(estoq);
        return new ResponseEntity<>(result, HttpStatus.CREATED);

    }

    @PutMapping(Update)
    public ResponseEntity<?> UpdateEstoque(@Valid @RequestBody UpdateEstoqueRequest request,
            BindingResult validation, HttpServletRequest httpServletRequest) throws Exception {
        if (validation.hasErrors()) {
            return ResponseEntity.badRequest().body(validation.getAllErrors().toString());
        }

        Estoque estoq = Estoque.MapUpdateRequestToEstoque(request);

        Estoque result;

        result = _Repository.save(estoq);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
