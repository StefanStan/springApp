package base.beans.services.jpa;

import base.beans.dao.GenericDAO;
import base.beans.services.GenericService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by StefanS on 26.04.2016.
 */
@Service
public abstract class GenericServiceJpaImpl<T, Id extends Serializable> implements GenericService <T, Id> {

    public abstract GenericDAO getDao() ;

    @Override
    public void save(T entity) {

        getDao().persists(entity);
    }

    @Override
    public void update(T entity) {

        getDao().update(entity);
    }

    @Override
    public T findById(Id id) {

        return (T) getDao().findById(id);
    }

    @Override
    public void delete(Id id) {

        getDao().delete(findById(id));
    }

    @Override
    public List<T> findAll() {

        return getDao().findAll();
    }
}
