package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/hello2")
public class Hello2RestController {
    private List<Person> items= new ArrayList<>();
    private AtomicInteger counter = new AtomicInteger();

    @Autowired
    private MyPersistence persistence;

    @RequestMapping("")
    public String get0() {
        return "root "+persistence.name()+" "+persistence.val();
    }

    @RequestMapping("list")
    public List<Person> get1() {
        return items;
    }

    @RequestMapping(value = "get/{id}")
    public List<Person> get2(@PathVariable Integer id) {
        return items.stream().filter(p->p.getId()==id).collect(Collectors.toList());
    }

    @RequestMapping(value = "add1/{name}")
    public List<Person> get3(@PathVariable String name) {
        items.add(new Person(counter.incrementAndGet(), name));
        return items;
    }

    @RequestMapping(value = "add2/{name}/{name2}")
    public List<Person> get4(@PathVariable String name, @PathVariable String name2) {
        items.add(new Person(counter.incrementAndGet(), name));
        items.add(new Person(counter.incrementAndGet(), name2));
        return items;
    }

    @RequestMapping(value = "addmore/{names}", method=RequestMethod.GET)
    public List<Person> get5(@PathVariable String[] names) {
        Arrays.asList(names).forEach(name->items.add(new Person(counter.incrementAndGet(), name)));
        return items;
    }

    @RequestMapping(value = "remove/{id}")
    public List<Person> get6(@PathVariable Integer id) {
        items.stream().filter(p->p.getId()==id).findFirst().ifPresent(items::remove);
        return items;
    }

    @RequestMapping(value = "edit/{id}/{name}")
    public List<Person> get7(@PathVariable Integer id, @PathVariable String name) {
        items.stream().filter(p->p.getId()==id).findFirst().ifPresent(p->p.setName(name));
        return items;
    }
}
