package Domain.Model.Users;

import javax.persistence.Entity;

@Entity
public class Patient extends User{

    private String cpf;

    //GETTERS AND SETTERS
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
