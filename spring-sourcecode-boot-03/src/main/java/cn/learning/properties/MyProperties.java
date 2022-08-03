package cn.learning.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Package: cn.learning
 * @Description: MyProperties
 * 场景：如果多个bean同时需要获取配置文件里的数据
 * 单个应用使用：@Value（"${password}"）这种方式来获取配置文件里的数据
 * 多个应用使用：把这个配置抽出来，作为公共配置,使用@ConfigurationProperties
 * @ConfigurationProperties 是springboot提供读取配置文件的一个注解，
 * 可以使用prefix,允许配置和类变量进行绑定
 * @Author: Sammy
 * @Date: 2022/8/1 11:07
 */
@ConfigurationProperties(prefix = "zhouyu")
// @Component 方法1:使用component注解，把它当作一个bean 一般不使用这个方法
public class MyProperties {

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
