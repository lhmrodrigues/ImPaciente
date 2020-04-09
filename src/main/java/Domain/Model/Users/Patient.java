package Domain.Model.Users;

import Domain.Model.Prescription.Prescription;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Patient extends User{

    @OneToOne(mappedBy = "patient")
    private Prescription prescription;
}
