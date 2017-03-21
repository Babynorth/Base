package com.babynorth.security;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by babynorth on 2017/3/17.
 */
public class Cache {


    /** 缓存登录失败的IP地址、累计失败次数及最后一次登录失败时间 */
    private static Map<String, LoginFailRecord> userLoginFailRecord = new HashMap<String, LoginFailRecord>();

    public static Map<String, LoginFailRecord> getUserLoginFailRecord() {
        return userLoginFailRecord;
    }

    public static void setUserLoginFailRecord(Map<String, LoginFailRecord> userLoginFailRecord) {
        Cache.userLoginFailRecord = userLoginFailRecord;
    }

}
