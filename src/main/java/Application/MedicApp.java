package Application;

import Application.Interfaces.IMedicApp;
import Domain.Model.Users.Medic;
import Infra.Repositories.MedicRepository;

public class MedicApp extends BaseApp<Medic> implements IMedicApp {

    private MedicRepository _medicRepository;

    public MedicApp(){
        _medicRepository = new MedicRepository();
    }

    public Medic medicLogin(Medic medic) throws Exception {
        Medic sqlMedic =  _medicRepository.medicByCRM(medic);

        if(sqlMedic == null || !sqlMedic.getPassword().equals(medic.getPassword())){
            throw new Exception("CRM e/ou senha inválidos");
        }
        else{
            return sqlMedic;
        }
    }
}
