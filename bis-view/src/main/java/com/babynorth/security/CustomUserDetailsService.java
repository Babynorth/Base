package com.babynorth.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by Administrator on 2017/1/17.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {


    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

       Map<Object,Object> map =  getMapData();
        Set<Role> roleList = (Set<Role>)map.get("roleList");
        Set<User> userList = (Set<User>) map.get("userList");

        Iterator<User> it = userList.iterator();
        User user = it.next();
        if(user==null){
            System.out.println("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getId(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user,userName));
    }


    private List<GrantedAuthority> getGrantedAuthorities(User user,String userName){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        if(user.getName().equals(userName)) {
            for(Role role : user.getRoleList()){
                authorities.add(new SimpleGrantedAuthority(role.getType()));
            }
        }
        System.out.print("authorities :"+authorities);
        return authorities;
    }


    private Map<Object,Object> getMapData() {

        Map<Object,Object> map = new HashMap<>();

        Set<Role> roleList = new HashSet<>();
        Set<User> userList = new HashSet<>();

        User user = new User();
        Role role = new Role();

        user.setId("1");
        user.setPassword("123456");
        user.setEmail("791151858@qq.com");
        user.setName("zhengbei");
        user.setRoleList(roleList);
        userList.add(user);

        role.setId("1");
        role.setType("ROLE_ADMIN");
        role.setUserList(userList);
        roleList.add(role);

        map.put("roleList",roleList);
        map.put("userList",userList);
        return map;
    }
}
