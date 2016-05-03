package base.beans.services;

import base.beans.entities.Student;
import base.beans.entities.StudentProjectRel;

import java.util.List;

/**
 * Created by StefanS on 26.04.2016.
 */
public interface StudentProjectRelService extends GenericService<StudentProjectRel, Integer> {

    void assignStudentToProject(int studId, int projId);

    List<Student> getStudentsOfProject(int projId);

    void deleteStudentFromProjectList(int studId, int projId);
}
