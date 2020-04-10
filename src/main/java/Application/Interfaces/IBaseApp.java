package Application.Interfaces;

import Domain.Shared.Entity;

import java.util.List;

public interface IBaseApp<T extends Entity> {
    void Add(T entity) throws Exception;

    List<T> getAll(Class<T> tClass) throws Exception;

    T getById(int id) throws Exception;

    void update(T entity) throws Exception;

    void delete(int id) throws Exception;

    void delete(T entity) throws Exception;
}
