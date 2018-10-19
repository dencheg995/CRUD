package project.UserDataSet;

import java.util.List;

public class User {
    private long id;
    private String name;
    private int age;
    private List<User> userList;


    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
