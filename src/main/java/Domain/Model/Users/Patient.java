package Domain.Model.Users;

import javax.persistence.Entity;

@Entity
public class Patient extends User{

    //PROPERTIES
    private int age;


    //GETTERS AND SETTERS
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
