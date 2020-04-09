package Application.Interfaces;

import Domain.Model.Prescription.Prescription;
import Domain.Model.Users.User;

import java.util.List;

public interface IPrescriptionApp extends IBaseApp<Prescription> {
    List<Prescription> getByPatient(User usuarioLogado) throws Exception;
}
