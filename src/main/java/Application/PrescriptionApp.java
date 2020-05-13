package Application;

import Application.Interfaces.IPrescriptionApp;
import Domain.Model.Prescription.Prescription;
import Domain.Model.Users.User;
import Infra.Repositories.PrescriptionRepository;

import java.util.List;

public class PrescriptionApp extends BaseApp<Prescription> implements IPrescriptionApp {

    private PrescriptionRepository _prescriptionRepository;

    public PrescriptionApp() {
        _prescriptionRepository = new PrescriptionRepository();
    }

    public List<Prescription> getByPatient(User usuarioLogado) throws Exception {
        return _prescriptionRepository.getByPatient(usuarioLogado.id);
    }
}
