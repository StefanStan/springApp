package base.controllers.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
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
            @RequestHeader(value = "X-Username") String username,
            @RequestHeader(value = "X-Password") String password
    ) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
