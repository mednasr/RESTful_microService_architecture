package rest.dao.entities;

import java.util.List;

public interface UserDAO<T>
{
    List<T> get();
    T get(Long id);
    T add(T entity) throws Exception;
    T update(T entity) throws Exception;
    boolean delete(Long id) throws Exception;
}
