package jdbc.manager;

public interface Manager<T ,E> {

    void create(T object);

    T getByHref(String href);

    T getById(E id);
}
