package base.beans.services.jpa;

import base.beans.dao.GenericDAO;
import base.beans.dao.ProjectDAO;
import base.beans.dao.StudentDAO;
import base.beans.dao.StudentProjectRelDAO;
import base.beans.entities.Project;
import base.beans.entities.Student;
import base.beans.entities.StudentProjectRel;
import base.exceptions.ConflictException;
import base.exceptions.NotFoundException;
import base.exceptions.NotModifiedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by StefanS on 25.04.2016.
 */
@Repository
@Service
public class StudentProjectRelServiceJpaImpl extends GenericServiceJpaImpl<StudentProjectRel, Integer> implements base.beans.services.StudentProjectRelService {

    @Autowired
    @Qualifier("studentProjectRelDAOJpaImpl")
    private StudentProjectRelDAO dao;

    @Autowired
    @Qualifier("projectDAOJpaImpl")
    private ProjectDAO projectDAO;

    @Autowired
    @Qualifier("studentDAOJpaImpl")
    private StudentDAO studentDAO;

    @Override
    public GenericDAO getDao() {

        return dao;
    }

    @Override
    public void assignStudentToProject(int studId, int projId) {

        Student student = studentDAO.findById(studId);
        if(student == null) {

            throw new NotFoundException();
        }

        Project project = projectDAO.findById(projId);
        if(project == null) {

            throw new NotFoundException();
        }

        List<Student> students = dao.getStudentsOfProject(projId);

        if(students.size() >= project.getCapacity()) {

            throw new ConflictException();
        }

        try {
            dao.assignProjectToStudent(project, student);
        } catch (Exception exc) {

            throw new NotModifiedException();
        }
    }

    @Override
    public List<Student> getStudentsOfProject(int projId) {

        if(projectDAO.findById(projId) == null) {

            throw new NotFoundException();
        }
        return dao.getStudentsOfProject(projId);
    }

    @Override
    public void deleteStudentFromProjectList(int studId, int projId) {

        Student student = studentDAO.findById(studId);
        if(student == null) {

            throw new NotFoundException();
        }

        Project project = projectDAO.findById(projId);
        if(project == null) {

            throw new NotFoundException();
        }

        try {
            dao.deleteStudentFromProjectList(project, student);
        } catch (Exception exc) {

            throw new NotFoundException();
        }
    }
}