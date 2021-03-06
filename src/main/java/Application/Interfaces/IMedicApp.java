package Application.Interfaces;

import Domain.Model.Users.Medic;

public interface IMedicApp extends IBaseApp<Medic> {
    Medic medicLogin(Medic medic) throws Exception;
}
