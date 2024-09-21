package infnet.edu.atddd.Domain.Errors;

import infnet.edu.atddd.Domain.Shared.Error;


public class NameDomainErrors {

    public static final Error Empty (){
        
        return new Error("Name.Empty", "Name is empty");
    } 

}
