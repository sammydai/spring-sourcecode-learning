package com.learning.service;

import com.learning.spring.*;

/**
 * @Package: com.learning.service
 * @Description: UserService
 * @Author: Sammy
 * @Date: 2022/7/4 13:29
 */
@Component(value = "userService")
// @Scope(value = "prototype")
// @Scope(value = "singleton")
public class UserService implements BeanNameAware,InitializingBean,UserInterface {

	@Autowired
	private OrderService orderService;

	private String xxx;

	//想要获取自己的beanName，依靠spring容器告知自己的beanName是什么
	//把某个bean的名字告知给调用者
	private String beanName;


	public void test() {
		System.out.println("orderService: "+orderService);
		System.out.println("beanName: "+beanName);
	}

	//不是使用者来调用这个方法，是spring来调用这个方法，告知当前的beanName，传递给这个beanName参数
	//spring什么时候会调用这个方法？
	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	@Override
	public void afterPropertiesSet() {
		//
		System.out.println("abcdefghijkl");
	}
}
