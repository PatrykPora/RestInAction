package pl.patrykpora.restinaction;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/hello")
    public Message sayHello() {
        return new Message("sayHello");
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/hi")
    public String sayHI() {
        return "sayHi";
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, path = "/api/hello/{id}")
    public Message sayHelloWithId(@PathVariable(name = "id") final Integer id){
        return new Message("sayHello " + id);
    }

}
