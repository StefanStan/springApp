package base.beans.dao.jpa;


import base.beans.dao.StudentProjectRelDAO;
import base.beans.entities.Project;
import base.beans.entities.Student;
import base.beans.entities.StudentProjectRel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Stefan Stan on 01/12/15.
 */
@Repository
@Transactional
public class StudentProjectRelDAOJpaImpl extends GenericDAOJpaImpl<StudentProjectRel, Integer> implements StudentProjectRelDAO {

    @Override
    public StudentProjectRel findById(Integer id) {

        return (StudentProjectRel) sessionFactory.getCurrentSession().get(StudentProjectRel.class, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<StudentProjectRel> findAll() {

        return (List<StudentProjectRel>) sessionFactory.getCurrentSession().createQuery("from StudentProjectRel").list();
    }

    public void assignProjectToStudent(Project project, Student student) {

        StudentProjectRel spr = new StudentProjectRel();
        spr.setStudent(student);
        spr.setProject(project);
        persists(spr);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> getStudentsOfProject(int projId) {

        return sessionFactory.getCurrentSession()
                .createQuery("select o.student from StudentProjectRel o where o.project.id = :projId")
                .setParameter("projId", projId).list();
    }

    @Override
    public void deleteStudentFromProjectList(Project project, Student student) {

        sessionFactory.getCurrentSession()
                .createQuery("delete from StudentProjectRel o where o.project = :project and o.student = :student")
                .setParameter("project", project).setParameter("student", student).executeUpdate();
    }
}