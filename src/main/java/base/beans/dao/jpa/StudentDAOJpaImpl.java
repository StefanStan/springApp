package base.beans.dao.jpa;


import base.beans.dao.StudentDAO;
import base.beans.entities.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Stefan Stan on 09/12/15.
 */
@Repository
@Transactional
public class StudentDAOJpaImpl extends GenericDAOJpaImpl<Student, Integer> implements StudentDAO {

    @Override
    public Student findById(Integer id) {

        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> findAll() {

        return (List<Student>) sessionFactory.getCurrentSession().createQuery("from Student").list();
    }
}