package com.babynorth.security;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/18.
 */
public class User {

    private String id;
    private String password;
    private String name;
    private String email;
    private Set<Role> roleList= new HashSet<Role>();

    public User() {

    }

    public User(String id, String password, String name, String email, Set<Role> roleList) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.roleList = roleList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(Set<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
