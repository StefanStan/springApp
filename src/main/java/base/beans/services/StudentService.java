package base.beans.services;

import base.beans.entities.Student;

/**
 * Created by StefanS on 26.04.2016.
 */
public interface StudentService extends GenericService<Student, Integer> {

    Student saveStudent(Student student);

    void deleteStudentById(int id);

    Student updateStudentById(int id, Student student);
}
