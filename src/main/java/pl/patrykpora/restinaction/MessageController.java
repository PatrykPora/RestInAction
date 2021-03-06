package pl.patrykpora.restinaction;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {

    private final List<Message> messages = new ArrayList<>();

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

    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    @RequestMapping(value = "/api/messages", method = RequestMethod.POST)
    public void createMessage(@RequestBody final Message message){
        messages.add(message);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    @RequestMapping(value = "api/messages/{index}", method = RequestMethod.PUT)
    public void updateMessage(@RequestBody final Message message, @PathVariable final Integer index){
        messages.get(index).setText(message.getText());
    }

}
