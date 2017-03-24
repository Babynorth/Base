package com.babynorth.security;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;
import org.springframework.security.web.util.RequestMatcher;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

/**
 * 主要责任就是当访问一个url时返回这个url所需要的访问权限
 * Created by babynorth on 2017/3/13.
 */
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private static final Logger logger = LoggerFactory.getLogger(CustomFilterInvocationSecurityMetadataSource.class);

    /*@Resource
    private ModuleService moduleService;*/

    private Map<String, Collection<ConfigAttribute>> resourceMap;


    /**
     * 返回本次访问需要的权限 当你在security.xml 配置为none将不会在被拦截
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();
        System.err.println(url);
        Map<String, Collection<ConfigAttribute>> resourceMap = autoRefreshResourceMap();

        return resourceMap.get(url);
    }

    @PostConstruct
    public Map<String, Collection<ConfigAttribute>> autoRefreshResourceMap() {
        Map<String, Collection<ConfigAttribute>> map = new HashMap<>();

      /*  Map<String, String> configMap = moduleService.getResourcesConfig();*/
        Map<String, String> configMap = new HashMap<>();
       /* configMap.put("/test!test","/test!test");*/
        configMap.put("11","/login/login!main.action");
        configMap.put("/test!testAcess","ROLE_ADMIN");
        Collection<ConfigAttribute> list = null;
        String[] vals = null;

        for (Map.Entry<String,String> entry : configMap.entrySet()) {
            list = new ArrayList<ConfigAttribute>();
            vals = entry.getValue().split(",");
            for (String val : vals) {
                ConfigAttribute config = new SecurityConfig(val);
                list.add(config);
            }
            map.put(entry.getKey(), list);
        }

        return map;
    }



    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


}
