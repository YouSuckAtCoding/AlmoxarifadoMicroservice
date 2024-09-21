package infnet.edu.atddd.Domain.ValueObjects;

import java.util.List;

import infnet.edu.atddd.Domain.Errors.NameDomainErrors;
import infnet.edu.atddd.Domain.Primitives.ValueObject;
import infnet.edu.atddd.Domain.Shared.Result;

public class NameValueObject extends ValueObject {

    public String value;

    private NameValueObject(String value)
    {
        this.value = value;
    }

    public static Result<NameValueObject> Create(String value) throws Exception
    {
        if(value.length() == 0)
        {
            return Result.<NameValueObject>Failure(NameDomainErrors.Empty());
        }
        
        return Result.<NameValueObject>Success(new NameValueObject(value)); 
    }


    @Override
    public List<Object> getAtomicValues() {
        return List.of(value);
    }

}
