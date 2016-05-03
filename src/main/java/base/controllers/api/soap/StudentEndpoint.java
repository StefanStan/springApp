package base.controllers.api.soap;

import base.beans.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

/**
 * Created by StefanS on 29.04.2016.
 */
@Endpoint(value = "/students")
public class StudentEndpoint {

    @Autowired
    @Qualifier("studentServiceJpaImpl")
    StudentService service;

//    @PayloadRoot(localPart = "StudentRequest", namespace = "http://mycompany.com/req/schemas")
//    public @ResponsePayload
//    StudentRequest getStudent(@RequestPayload StudentRequest request) {
//
//        int studentId = request.getId();
//        StudentResponse response = new StudentResponse();
//
//        Student student = service.findById(studentId);
//        if(student == null) {
//
//            response.setStudent(null);
//        }
//        response.setStudent(student);
//
//        return response;
//    }
}