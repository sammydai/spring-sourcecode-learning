package com.learning.springframework.core.io;

/**
 * @Package: com.learning.springframework.core.io
 * @Description: ResourceLoader
 * @Author: Sammy
 * @Date: 2022/7/12 10:33
 */

public interface ResourceLoader {

	String CLASSPATH_URL_PREFIX = "classpath:";

	Resource getResource(String location);
}
