package infnet.edu.atddd.Domain.ValueObjects;

import java.util.List;

import infnet.edu.atddd.Domain.Errors.NameDomainErrors;
import infnet.edu.atddd.Domain.Primitives.ValueObject;
import infnet.edu.atddd.Domain.Shared.Result;

public class Quantidade extends ValueObject {

    public Integer value;

    private Quantidade(Integer value)
    {
        this.value = value;
    }

    public static Result<Quantidade> Create(Integer value) throws Exception
    {
        if(value == 0)
        {
            return Result.<Quantidade>Failure(NameDomainErrors.Empty());
        }
        
        return Result.<Quantidade>Success(new Quantidade(value)); 
    }


    @Override
    public List<Object> getAtomicValues() {
        return List.of(value);
    }

}
