package Domain.Model.Medicine;

import Domain.Shared.Entity;

@javax.persistence.Entity
public class Medicine extends Entity {

    //PROPERTIES
    private String name;

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
