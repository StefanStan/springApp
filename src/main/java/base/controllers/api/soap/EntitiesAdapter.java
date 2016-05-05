package base.controllers.api.soap;

import base.beans.entities.Project;
import base.beans.entities.Student;
import base.controllers.api.soap.pojo.Students;

import java.util.List;

/**
 * Created by StefanS on 05.05.2016.
 */
public class EntitiesAdapter {

    public static Student convertStudentPOJO(base.controllers.api.soap.pojo.Student studentPOJO) {

        Student result = new Student();
        result.setId(studentPOJO.getId());
        result.setEmail(studentPOJO.getEmail());
        result.setName(studentPOJO.getName());

        return result;
    }

    public static base.controllers.api.soap.pojo.Student convertStudentEntity(Student studentEntity) {

        base.controllers.api.soap.pojo.Student result = new base.controllers.api.soap.pojo.Student();
        result.setId(studentEntity.getId());
        result.setEmail(studentEntity.getEmail());
        result.setName(studentEntity.getName());

        return result;
    }

    public static Project convertProjectPOJO(base.controllers.api.soap.pojo.Project projectPOJO) {

        Project result = new Project();
        result.setId(projectPOJO.getId());
        result.setName(projectPOJO.getName());
        result.setCapacity((double) projectPOJO.getCapacity());

        return result;
    }

    public static base.controllers.api.soap.pojo.Project convertProjectEntity(Project projectEntity) {

        base.controllers.api.soap.pojo.Project result = new base.controllers.api.soap.pojo.Project();
        result.setId(projectEntity.getId());
        result.setName(projectEntity.getName());
        result.setCapacity(projectEntity.getCapacity().intValue());

        return result;
    }

    public static Students convertStudentsEntities(List<Student> studentList) {

        Students students = new Students();
        studentList.forEach((elem) -> students.getStudent().add(convertStudentEntity(elem)));

        return students;
    }
}
