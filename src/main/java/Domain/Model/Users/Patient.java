package Domain.Model.Users;

import javax.persistence.Entity;

@Entity
public class Patient extends User{

    //PROPERTIES
    private int age;
    private String cpf;

    //GETTERS AND SETTERS
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
