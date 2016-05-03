package base.beans.dao;

import base.beans.entities.Project;
import base.beans.entities.Student;
import base.beans.entities.StudentProjectRel;

import java.util.List;

/**
 * Created by Stefan Stan on 09/12/15.
 */
public interface StudentProjectRelDAO extends GenericDAO<StudentProjectRel, Integer> {

    void assignProjectToStudent(Project project, Student student);

    List<Student> getStudentsOfProject(int projId);

    void deleteStudentFromProjectList(Project project, Student student);
}
