package base.controllers.api.restful;

import base.beans.entities.Project;
import base.beans.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * Created by StefanS on 26.04.2016.
 */
@RestController
public class ProjectController {

    @Autowired
    @Qualifier("projectServiceJpaImpl")
    ProjectService service;

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/projects",
            method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> createProject(
            @RequestBody Project project
            ) {

        Project result = service.saveProject(project);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/projects",
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> listAllProjects() {

        List<Project> projects = service.findAll();

        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/project/{id}",
            method = RequestMethod.GET,
            headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> getProject(
            @PathVariable("id") int id
    ) {

        Project project = service.findById(id);
        if(project == null) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/project/{id}",
            method = RequestMethod.DELETE,
            headers = "Accept=application/json")
    public ResponseEntity<Project> deleteProject(
            @PathVariable("id") int id
    ) {

        service.deleteProjectById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RolesAllowed({"ADMIN","user"})
    @RequestMapping(value = "/project/{id}",
            method = RequestMethod.PUT,
            headers = "Accept=application/json",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> updateProject(
            @PathVariable("id") int id,
            @RequestBody Project project
    ) {

        Project result = service.updateProjectById(id, project);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}