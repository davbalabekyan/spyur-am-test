package jdbc.manager;

import java.util.List;

public interface Manager<T, E> {

    void create(T object);

    T getByHref(String href);

    T getById(E id);

    List<T> getAll();

    void update(T object);

    void delete(E id);
}
