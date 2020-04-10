package Infra.Repositories.Interfaces;

import Domain.Shared.Entity;

import java.util.List;

public interface IBaseRepository<T extends Entity> {

    List<T> getAll(Class<T> entity) throws Exception;

    T getById(int id) throws Exception;

    T add(T entity) throws Exception;

    void update(T entity) throws Exception;

    void delete(T entity) throws Exception;
}
