package hello.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(generator = "users_u_id_seq")
    @Column(name = "u_id", unique = true)
    private int id;

    @Column(name = "u_name")
    private String name;

    @Column(name = "u_regdate")
    private Timestamp date;

    @Column(name = "u_login")
    private String login;

    @Column(name = "u_passwd")
    private String passwd;

    @Column(name = "u_group")
    private int groupId;

    @Column(name = "u_role")
    private int role;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return String.format("User:[id=%d, name=`%s`, date=`%s`, login=`%s`, passwd=`%s`, group=`%d`, role=`%s`", id, name, date, login, passwd, groupId, role);
    }
}
