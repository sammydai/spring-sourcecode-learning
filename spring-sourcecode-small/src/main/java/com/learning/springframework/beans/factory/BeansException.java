package com.learning.springframework.beans.factory;

/**
 * @Package: com.learning.springframework.beans.factory
 * @Description: BeansException
 * @Author: Sammy
 * @Date: 2022/7/4 18:39
 */

public class BeansException extends Throwable {
	public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
