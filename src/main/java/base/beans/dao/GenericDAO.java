package base.beans.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by StefanS on 25.04.2016.
 */
public interface GenericDAO<T, Id extends Serializable> {

    void persists(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(T entity);

    List<T> findAll();

    void deleteAll();
}
