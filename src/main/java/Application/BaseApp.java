package Application;

import Application.Interfaces.IBaseApp;
import Domain.Shared.Entity;
import Infra.Repositories.BaseRepository;

import java.util.List;

public abstract class BaseApp<T extends Entity> implements IBaseApp<T> {

    private BaseRepository<T> _baseRepository;

    public BaseApp() {
        _baseRepository = new BaseRepository<T>();
    }

    public void Add(T entity) throws Exception {
        _baseRepository.add(entity);
    }

    public List<T> getAll(Class<T> tClass) throws Exception {
        return _baseRepository.getAll(tClass);
    }

    public T getById(int id) throws Exception {
        return _baseRepository.getById(id);
    }

    public void update(T entity) throws Exception {
        _baseRepository.update(entity);
    }

    public void delete(int id) throws Exception {
        T entity = _baseRepository.getById(id);
        _baseRepository.delete(entity);
    }

    public void delete(T entity) throws Exception {
        _baseRepository.delete(entity);
    }
}
