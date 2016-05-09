package base.controllers;

/**
 * Created by StefanS on 20.04.2016.
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HTMLController {

    @RequestMapping(value = "/",
            method = RequestMethod.GET
    )
    public String index() {

        return login();
    }

    @RequestMapping(value = "/login",
            method = RequestMethod.GET
    )
    public String login() {

        return "static/login.html";
    }
}