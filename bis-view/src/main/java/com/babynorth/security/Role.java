package com.babynorth.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/1/18.
 */
public class Role {

    private String id;
    private String type;
    private List<User> userList = new ArrayList<>();

    public Role() {

    }

    public Role(String id, String type, List<User> userList) {
        this.id = id;
        this.type = type;
        this.userList = userList;
    }

    public Role(String id, String type) {
        this.id = id;
        this.type = type;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
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
