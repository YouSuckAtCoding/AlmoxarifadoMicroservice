package infnet.edu.atddd.Domain.Primitives;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntityRoot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;

    // Jpa required
    protected EntityRoot() {
    }

    protected EntityRoot(String id) {
        this.id = id;
    }

    public boolean Equals(EntityRoot obj) {
        if (obj != null) {
            if (obj.getClass() != this.getClass()) {
                return false;
            }
            return obj.id == this.id;
        }

        return true;
    }

}