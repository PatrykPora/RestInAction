package pl.patrykpora.restinaction;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MessageController {

    @RequestMapping(method = RequestMethod.GET, path = "/api/hello")
    public ResponseEntity<Message> sayHello(){
        return ResponseEntity.ok().body(new Message("sayHello"));
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/hi")
    public ResponseEntity<String> sayHi(){
        return ResponseEntity.ok().body("sayHi");
    }
}
