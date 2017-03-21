package com.babynorth.security;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

/**
 * Created by babynorth on 2017/3/13.
 */
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private static final Logger logger = LoggerFactory.getLogger(CustomFilterInvocationSecurityMetadataSource.class);

    /*@Resource
    private ModuleService moduleService;*/

    private Map<String, Collection<ConfigAttribute>> resourceMap;


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //取得ServletPath,即contextPath之后？号之前的部分
        String url = ((FilterInvocation) object).getHttpRequest().getServletPath();

        //取得要通过此权限需要的code集合
        Collection<ConfigAttribute> ca = resourceMap.get(url.replace(".action", ""));

        if(ca == null) {
            List l = new ArrayList<>();
            l.add(new SecurityConfig("not found"));
            return l;
        }

        return ca;
    }

    /**
     *初始化后执行一次，以后quartz轮询执行
     */
    @PostConstruct
    public void autoRefreshResourceMap() {
        Map<String, Collection<ConfigAttribute>> map = new HashMap<>();

       /* Map<String, String> configMap = moduleService.getResourcesConfig();*/
        Map<String, String> configMap = new HashMap<>();

        Collection<ConfigAttribute> list = null;
        String[] vals = null;
        for (String key : configMap.keySet()) {
            list = Lists.newArrayList();
            vals = configMap.get(key).split(",");
            for (String val : vals) {
                ConfigAttribute config = new SecurityConfig(val);
                list.add(config);
            }

            map.put(key, list);
        }

        resourceMap = map;
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
