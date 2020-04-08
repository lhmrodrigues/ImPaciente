package Infra.Repositories.Interfaces;

import Domain.Model.Users.Medic;

public interface IMedicRepository extends IBaseRepository<Medic> {
    Medic medicByCRM(Medic medic);
}
