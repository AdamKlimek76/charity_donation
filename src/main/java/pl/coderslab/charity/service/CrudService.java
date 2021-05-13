package pl.coderslab.charity.service;

import java.util.List;

public interface CrudService<T> {

    void add(T t);

    void update(T t);

    void delete(long id);

    List<T> showAll();

    T showById(long id);

}
