package base.controllers.api.soap;

import base.beans.services.StudentService;
import base.controllers.api.soap.pojo.*;
import base.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.annotation.security.RolesAllowed;

/**
 * Created by StefanS on 04.05.2016.
 */
@Endpoint(value = "/api/soap/students")
public class StudentEndpoint {

    @Autowired
    @Qualifier("studentServiceJpaImpl")
    StudentService service;

    @RolesAllowed({"ADMIN","user"})
    @PayloadRoot(localPart = "createStudentReq", namespace = "http://springApp.com/schemas")
    public @ResponsePayload CreateStudentResp createStudent(@RequestPayload CreateStudentReq createStudentReq) {

        base.beans.entities.Student result =
                service.saveStudent(EntitiesAdapter.convertStudentPOJO(createStudentReq.getStudent()));
        CreateStudentResp resp = new CreateStudentResp();
        resp.setStudent(EntitiesAdapter.convertStudentEntity(result));
        return resp;
    }

    @RolesAllowed({"ADMIN","user"})
    @PayloadRoot(localPart = "getStudents", namespace = "http://springApp.com/schemas")
    public @ResponsePayload GetStudentsResp getStudents() {

        GetStudentsResp resp = new GetStudentsResp();
        resp.setStudents(EntitiesAdapter.convertStudentsEntities(service.findAll()));
        return resp;
    }

    @RolesAllowed({"ADMIN","user"})
    @PayloadRoot(localPart = "getStudentReq", namespace = "http://springApp.com/schemas")
    public @ResponsePayload GetStudentResp getStudent(@RequestPayload GetStudentReq getStudentReq) {

        base.beans.entities.Student student = service.findById(getStudentReq.getId());
        if(student == null) {

            throw new NotFoundException();
        }
        GetStudentResp studentResp = new GetStudentResp();
        studentResp.setStudent(EntitiesAdapter.convertStudentEntity(student));
        return studentResp;
    }
}
