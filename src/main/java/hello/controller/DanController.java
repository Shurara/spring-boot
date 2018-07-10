package hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DanController {

    @RequestMapping("/dan")
    public String get00() {
        return "Hello, Dan.IT";
    }
}
