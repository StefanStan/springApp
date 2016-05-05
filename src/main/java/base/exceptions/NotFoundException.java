package base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

/**
 * Created by StefanS on 28.04.2016.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{http://springApp.com/schemas}404", faultStringOrReason = "Not Found")
public class NotFoundException extends RuntimeException {

}
