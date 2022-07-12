package com.learning.springframework.beans;

/**
 * @Package: com.learning.springframework.beans.factory
 * @Description: BeansException
 * @Author: Sammy
 * @Date: 2022/7/4 18:39
 */

public class BeansException extends RuntimeException {

	public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
