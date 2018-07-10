package hello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@ResponseBody
@RequestMapping("/hello0")
public class Hello0Controller {
    private final AtomicInteger counter = new AtomicInteger();

    @RequestMapping("")
    public String rootpage() {
        return "Hello from Controller";
    }

    @RequestMapping(value = "/{name}.txt", method = RequestMethod.GET, produces = "text/plain")
    public String plain (@PathVariable String name) {
        return new Person(counter.incrementAndGet(), name).toString();
    }

    @RequestMapping(value = "/{name}.txt1", produces = "application/text")
    public String plainDownloadable (@PathVariable String name) {
        return new Person(counter.incrementAndGet(), name).toString();
    }

    @RequestMapping(value = "/{name}", produces = "application/json")
    public Person json (@PathVariable String name) {
        return new Person(counter.incrementAndGet(), name);
    }

    @GetMapping(value = "/{name}.xml", produces = "application/xml")
    public Person xml (@PathVariable String name) {
        return new Person(counter.incrementAndGet(), name);
    }
}
