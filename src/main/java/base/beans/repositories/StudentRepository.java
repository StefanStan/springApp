package base.beans.repositories;

import base.beans.entities.Student;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by StefanS on 11.05.2016.
 */
@Transactional
public interface StudentRepository extends GenericRepository<Student, Integer> {

}
