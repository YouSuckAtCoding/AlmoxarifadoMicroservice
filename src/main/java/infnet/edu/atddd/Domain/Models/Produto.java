package infnet.edu.atddd.Domain.Models;

import infnet.edu.atddd.Contracts.CreateProductRequest;
import infnet.edu.atddd.Contracts.UpdateProdutoRequest;
import infnet.edu.atddd.Domain.Enum.Type_Prod;
import infnet.edu.atddd.Domain.Primitives.EntityRoot;
import infnet.edu.atddd.Domain.ValueObjects.NameValueObject;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;

@Entity
public class Produto extends EntityRoot {

    private static final Type_Prod[] myEnumValues = Type_Prod.values(); 

    public NameValueObject name;
    public double price;
    public Type_Prod type;

    public Produto(){}

    public Produto(String name, double price, Type_Prod type) throws Exception {
        this.name = NameValueObject.Create(name).Value();
        this.price = price;
        this.type = type;
    }
    public Produto(String id, String name, double price, Type_Prod type) throws Exception {
        super(id);
        this.name = NameValueObject.Create(name).Value();
        this.price = price;
        this.type = type;
    }

    public static Produto MapCreateRequestToProduto(CreateProductRequest request) throws Exception
    {
        if(request.type > myEnumValues.length)
            return new Produto();

        return new Produto(request.name,
        request.price,
        myEnumValues[request.type]);
    }

    public static Produto MapUpdateRequestToProduto(@Valid UpdateProdutoRequest request) throws Exception {
        if(request.type > myEnumValues.length)
            return new Produto();

        return new Produto(request.id,
        request.name,
        request.price,
        myEnumValues[request.type]);
    }

}
