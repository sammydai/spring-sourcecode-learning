package com.learning.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Package: com.learning.springframework.test.bean
 * @Description: UserDao Test
 * @Author: Sammy
 * @Date: 2022/7/5 09:59
 */

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
