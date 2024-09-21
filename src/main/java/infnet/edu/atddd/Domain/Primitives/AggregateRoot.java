package infnet.edu.atddd.Domain.Primitives;

public abstract class AggregateRoot extends EntityRoot{

    protected AggregateRoot(String id) {
        super(id);    
    }

    protected AggregateRoot()
    {}
}
