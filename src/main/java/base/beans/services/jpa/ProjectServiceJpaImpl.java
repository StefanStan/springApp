package base.beans.services.jpa;

import base.beans.dao.GenericDAO;
import base.beans.dao.ProjectDAO;
import base.beans.entities.Project;
import base.exceptions.BadRequestException;
import base.exceptions.ConflictException;
import base.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by StefanS on 25.04.2016.
 */
@Repository
@Service
public class ProjectServiceJpaImpl extends GenericServiceJpaImpl<Project, Integer> implements base.beans.services.ProjectService {

    @Autowired
    @Qualifier("projectDAOJpaImpl")
    private ProjectDAO dao;

    @Override
    public GenericDAO getDao() {

        return dao;
    }

    public Project saveProject(Project project) {

        if(project.isValid()) {

            try {

                save(project);
                Project res = new Project();
                res.setId(project.getId());
                return res;
            } catch (Exception exc) {

                throw new ConflictException();
            }
        }
        throw new BadRequestException();
    }

    public void deleteProjectById(int id) {

        try {
            delete(id);
        } catch (Exception exc) {

            throw new NotFoundException();
        }
    }

    public Project updateProjectById(int id, Project project) {

        if(project.isValid() && id == project.getId()) {

            try {

                update(project);
                return project;
            } catch (Exception exc) {

                if(exc.getCause() instanceof Exception) {

                    throw new NotFoundException();
                }
                throw new ConflictException();
            }
        }
        throw new BadRequestException();
    }
}
