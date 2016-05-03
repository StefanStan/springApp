package base.beans.dao.jpa;


import base.beans.dao.ProjectDAO;
import base.beans.entities.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Stefan Stan on 09/12/15.
 */
@Repository
@Transactional
public class ProjectDAOJpaImpl extends GenericDAOJpaImpl<Project, Integer> implements ProjectDAO {

    @Override
    public Project findById(Integer id) {

        return (Project) sessionFactory.getCurrentSession().get(Project.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Project> findAll() {

        return (List<Project>) sessionFactory.getCurrentSession().createQuery("from Project").list();
    }
}