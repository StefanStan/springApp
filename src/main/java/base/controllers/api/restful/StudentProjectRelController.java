package base.controllers.api.restful;

import base.beans.entities.Student;
import base.beans.services.StudentProjectRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Created by StefanS on 26.04.2016.
 */
@RestController
public class StudentProjectRelController {

    @Autowired
    @Qualifier("studentProjectRelServiceJpaImpl")
    StudentProjectRelService service;

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/project/{projId}/students",
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getStudentsOfProject(
            @PathVariable("projId") int projId
    ) {

        List<Student> result = service.getStudentsOfProject(projId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/student/{studId}/project/{projId}",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> assignStudentToProject(
            @PathVariable("studId") int studId,
            @PathVariable("projId") int projId
    ) {

        service.assignStudentToProject(studId, projId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/student/{studId}/project/{projId}",
            method = RequestMethod.DELETE,
            headers = "Accept=application/json")
    public ResponseEntity<Integer> deleteStudentFromProjectList(
            @PathVariable("studId") int studId,
            @PathVariable("projId") int projId
    ) {

        service.deleteStudentFromProjectList(studId, projId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}