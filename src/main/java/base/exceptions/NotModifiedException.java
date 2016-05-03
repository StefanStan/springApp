package base.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by StefanS on 28.04.2016.
 */
@ResponseStatus(value = HttpStatus.NOT_MODIFIED)
public class NotModifiedException extends RuntimeException {

}
