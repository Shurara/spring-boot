package hello.controller;

import hello.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hello3")
public class Hello3RestController {

    @Autowired
    private SessionFactory factory;

    @RequestMapping("list")
    public List<User> get1() {
        try (Session s = factory.openSession()) {
            return s.createQuery("FROM User", User.class).list();
        }
    }

    @RequestMapping(value = "get/{id}")
    public User get2(@PathVariable Integer id) {
        try (Session s = factory.openSession()) {
            return s.get(User.class, id);
        }
    }

    @RequestMapping(value = "add/{name}")
    public User get3(@PathVariable String name) {
        try (Session s = factory.openSession()) {
            User user = new User();
            user.setName(name);
            Transaction t = s.beginTransaction();
            int uid = (int) s.save(user);
            t.commit();
            return s.get(User.class, uid);
        }
    }

    @RequestMapping(value = "remove/{id}")
    public List<User> get6(@PathVariable Integer id) {
        try (Session s = factory.openSession()) {
            Transaction t = s.beginTransaction();
            User user = s.get(User.class, id);
            s.delete(user);
            t.commit();
            return s.createQuery("FROM User", User.class).list();
        }
    }

    @RequestMapping(value = "edit/{id}/{name}")
    public List<User> get7(@PathVariable Integer id, @PathVariable String name) {
        try (Session s = factory.openSession()) {
            Transaction t = s.beginTransaction();
            User user = s.get(User.class, id);
            user.setName(name);
            s.update(user);
            t.commit();
            return s.createQuery("FROM User", User.class).list();
        }
    }
}
