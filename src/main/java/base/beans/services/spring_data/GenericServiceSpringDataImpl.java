package base.beans.services.spring_data;

import base.beans.repositories.GenericRepository;
import base.beans.services.GenericService;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Created by StefanS on 26.04.2016.
 */
@Service
public abstract class GenericServiceSpringDataImpl<T, Integer extends Serializable> implements GenericService <T, Integer> {

    public abstract GenericRepository getRepository() ;

    @Override
    public void save(T entity) {

        getRepository().saveAndFlush(entity);
    }

    @Override
    public void update(T entity) {

        getRepository().saveAndFlush(entity);
    }

    @Override
    public T findById(Integer id) {

        return (T) getRepository().findOne(id);
    }

    @Override
    public void delete(Integer id) {

        getRepository().delete(id);
    }

    @Override
    public List<T> findAll() {

        return (List<T>) getRepository().findAll();
    }
}
