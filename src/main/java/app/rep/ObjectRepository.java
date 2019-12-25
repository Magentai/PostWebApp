package app.rep;

import java.util.List;

public interface ObjectRepository<T> {
    List<T> findAll();

    T getById(int id);

    void save(T obj);

    void delete(T obj);
}
