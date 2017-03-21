package com.babynorth.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

/**
 * Created by Administrator on 2017/1/18.
 */
public class User implements UserDetails{

    private String id;

    private String empassword;
    private String name;
    private String email;
    private List<Role> roles = new ArrayList<>();
    private List<GrantedAuthority> authosList;

    public User() {

    }

    public User(String id, String empassword, String name, String email, List<Role> roles) {
        this.id = id;
        this.empassword = empassword;
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    public User(String id, String password, String name, String email) {
        this.id = id;
        this.empassword = password;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthosList(List<GrantedAuthority> authosList) {
        this.authosList = authosList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authosList;
    }

    @Override
    public String getPassword() {
        return empassword;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    public String getEmpassword() {
        return empassword;
    }

    public void setEmpassword(String empassword) {
        this.empassword = empassword;
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

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }




    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", password='" + empassword + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
