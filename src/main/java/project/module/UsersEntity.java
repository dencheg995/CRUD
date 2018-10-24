package project.module;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "db_users", catalog = "")
public class UsersEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "age")
    private int age;
    @Column(name = "role")
    private String role;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;



    public UsersEntity(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UsersEntity(String name, int age, String login, String password, String role) {
        this.role = role;
        this.name = name;
        this.age = age;
        this.login = login;
        this.password = password;
    }




    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersEntity(String userName, Integer userAge) {
        this.name = userName;
        this.age = userAge;
    }



    public UsersEntity() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String userName) {
        this.name = userName;
    }


    public int getAge() {
        return age;
    }

    public void setAge(Integer userAge) {
        this.age = userAge;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(age, that.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
