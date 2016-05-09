package base.controllers.api.restful;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by StefanS on 06.05.2016.
 */
@RestController
public class AuthController {

    @RequestMapping(value = "/login",
            method = RequestMethod.POST
    )
    public ResponseEntity<Map> login(
            @RequestBody String username,
            @RequestBody String password
    ) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
