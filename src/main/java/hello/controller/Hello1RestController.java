package hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello1")
public class Hello1RestController {

    @RequestMapping("")
    public String index0() {
        return "Greetings from Spring Boot! (no slash)";
    }

    @RequestMapping("/")
    public String index1() {
        return "Greetings from Spring Boot! (slash)";
    }

    @RequestMapping(value="/item", produces = "application/json")
    public Person index2() {
        return new Person(33,"Alex");
    }

    @RequestMapping("/items")
    public List<Person> index3() {
        return new ArrayList<Person>(){{
            add(new Person(33,"Alex"));
            add(new Person(34,"Dima"));
            add(new Person(35,"Masha"));
            add(new Person(36,"Sergey"));
        }};
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return "Greetings, "+ name ;
    }
}