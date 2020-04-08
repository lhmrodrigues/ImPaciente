package Domain.Model.Users;

import Domain.Shared.Entity;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@javax.persistence.Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User extends Entity {

    //PROPERTIES
    private String name;
    private String cpfCrm;
    private String password;

    //GETTERS AND SETTERS
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpfCrm() {
        return cpfCrm;
    }

    public void setCpfCrm(String cpfCrm) {
        this.cpfCrm = cpfCrm;
    }
}
