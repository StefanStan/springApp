package base.controllers.api.restful;

import base.beans.entities.Student;
import base.beans.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Created by StefanS on 25.04.2016.
 */
@RestController
public class StudentController {

    @Autowired
    @Qualifier("studentServiceJpaImpl")
    StudentService service;

    // Spring annotation virtually equivalent with @RolesAllowed - except for...
    // WARNING: @Secured by default works only with roles starting with ROLE_ prefix, see this for more:
    // I don't want to mess with this route - that's why ADMIN does NOT have access to this page
//    @Secured({"ROLE_SPECIAL", "ADMIN"})
    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/students",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student
    ) {

        Student result = service.saveStudent(student);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/students",
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> listAllStudents() {

        List<Student> students = service.findAll();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/student/{id}",
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> getStudent(
            @PathVariable("id") int id
    ) {

        Student student = service.findById(id);
        if(student == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/student/{id}",
            method = RequestMethod.DELETE,
            headers = "Accept=application/json")
    public ResponseEntity<Student> deleteStudent(
            @PathVariable("id") int id
    ) {

        service.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/student/{id}",
            method = RequestMethod.PUT,
            headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudent(
            @PathVariable("id") int id,
            @RequestBody Student student
    ) {

        Student result = service.updateStudentById(id, student);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}