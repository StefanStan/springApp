package base.beans.services;

import java.io.Serializable;
import java.util.List;

/**
 * Created by StefanS on 25.04.2016.
 */
public interface GenericService<T, Id extends Serializable> {

    void save(T entity);

    void update(T entity);

    T findById(Id id);

    void delete(Id id);

    List<T> findAll();
}