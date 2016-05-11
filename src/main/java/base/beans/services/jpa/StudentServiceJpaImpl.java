package base.beans.services.jpa;

import base.beans.dao.GenericDAO;
import base.beans.dao.StudentDAO;
import base.beans.entities.Student;
import base.exceptions.BadRequestException;
import base.exceptions.ConflictException;
import base.exceptions.NotFoundException;
import org.hibernate.StaleStateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by StefanS on 25.04.2016.
 */
@Repository
@Service
public class StudentServiceJpaImpl extends GenericServiceJpaImpl<Student, Integer> implements base.beans.services.StudentService {

    @Autowired
    @Qualifier("studentDAOJpaImpl")
    private StudentDAO dao;

    @Override
    public GenericDAO getDao() {

        return dao;
    }

    public Student saveStudent(Student student) {

        if(student.isValid()) {

            try {

                save(student);
                Student res = new Student();
                res.setId(student.getId());
                return res;
            } catch (Exception exc) {

                throw new ConflictException();
            }
        }
        throw new BadRequestException();
    }

    public void deleteStudentById(int id) {

        try {
            delete(id);
        } catch (Exception exc) {

            throw new NotFoundException();
        }
    }

    public Student updateStudentById(int id, Student student) {

        if(student.isValid() && id == student.getId()) {

            try {

                update(student);
                return student;
            } catch (Exception exc) {

                if(exc.getCause() instanceof StaleStateException) {

                    throw new NotFoundException();
                }
                throw new ConflictException();
            }
        }
        throw new BadRequestException();
    }
}
