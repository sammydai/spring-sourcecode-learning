package com.learning.springframework.core.io;

import cn.hutool.core.lang.Assert;
import org.springframework.core.io.*;

import java.net.MalformedURLException;
import java.net.URL;


/**
 * @Package: com.learning.springframework.core.io
 * @Description: DefaultResourceLoader
 * @Author: Sammy
 * @Date: 2022/7/12 10:30
 */

public class DefaultResourceLoader implements ResourceLoader{

	@Override
	public Resource getResource(String location) {
		Assert.notNull(location, "Location must not be null");
		if (location.startsWith(CLASSPATH_URL_PREFIX)) {
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
		}
		else {
            try {
                URL url = new URL(location);
                return new UrlResource(url);
            } catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }
	}

	@Override
	public ClassLoader getClassLoader() {
		return null;
	}
}
