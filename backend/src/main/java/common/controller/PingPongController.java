package common.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingPongController {

    record PingPong(String name){};

    @GetMapping("/Ping")
    PingPong getPingPong(){
        return new PingPong("Pong");
    }

}
