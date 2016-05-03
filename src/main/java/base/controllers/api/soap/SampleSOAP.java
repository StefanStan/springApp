package base.controllers.api.soap;

import base.beans.entities.Student;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by StefanS on 29.04.2016.
 */
@Endpoint(value = "/api/soap/sample")
public class SampleSOAP {
    public SampleSOAP() {
        System.out.println("baloooo");
    }

    @PayloadRoot(localPart = "SampleStudent", namespace = "http://www.example.org/SampleStudent")
    //public @ResponsePayload JAXBElement<SampleItem> getStudents(/*@RequestPayload Student stud,*/ MessageContext messageContext) {
    public @ResponsePayload Student getStudents(/*@RequestPayload Student stud,*/ MessageContext messageContext) {
        /*JAXBElement<SampleItem> jax = new JAXBElement(new QName("http://springApp.com/data/schemas"), SampleItem.class, new SampleItem(1,"Gigel"));
        return jax;*/

        return new Student();//(1,"Gigel");
    }
}
