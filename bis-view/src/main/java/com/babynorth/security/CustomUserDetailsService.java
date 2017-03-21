package com.babynorth.security;

import com.babynorth.util.StringUtil;
import com.google.common.collect.Lists;
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


    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {

        System.out.println(userName);


        List<Role> roleList = new ArrayList<>();

        Role role = new Role();
        role.setId("1");
        role.setType("ROLE_ADMIN");
        roleList.add(role);

        Role role1 = new Role();
        role1.setId("2");
        role1.setType("ROLE_USER");
        roleList.add(role);

        User user = new User("1","123456","zhengbei","791151858@qq.com",roleList);
        List<GrantedAuthority> authorityList = getGrantedAuthorities(roleList);

        user.setAuthosList(authorityList);


        return user;

    }


    /**
     * 用户所拥有的权限
     * @return
     */
    private List<GrantedAuthority> getGrantedAuthorities( List<Role> roleList){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Role ro : roleList) {
            // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
            authorities.add(new SimpleGrantedAuthority(ro.getType()));
        }
        return authorities;
    }


}
