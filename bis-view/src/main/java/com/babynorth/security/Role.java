package com.babynorth.security;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/18.
 */
public class Role {

    private String id;
    private String type;
    private Set<User> userList = new HashSet<>();

    public Role() {

    }

    public Role(String id, String type, Set<User> userList) {
        this.id = id;
        this.type = type;
        this.userList = userList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<User> getUserList() {
        return userList;
    }

    public void setUserList(Set<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
