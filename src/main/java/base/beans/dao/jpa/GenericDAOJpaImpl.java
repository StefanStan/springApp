package base.beans.dao.jpa;

import base.beans.dao.GenericDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by StefanS on 27.04.2016.
 */
@Transactional
public abstract class GenericDAOJpaImpl<T, Id extends Serializable> implements GenericDAO<T, Id> {

    @Autowired
    public SessionFactory sessionFactory;

    @Override
    public void persists(T entity) {

        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    public void update(T entity) {

        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    public void delete(T entity) {

        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    public void deleteAll() {

        List<T> list = findAll();
        list.forEach(this::delete);
    }
}
