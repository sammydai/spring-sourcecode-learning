package com.learning.context.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

/**
 * @Package: com.learning.service
 * @Description: UserService
 * @Author: Sammy
 * @Date: 2022/7/4 13:29
 */
@Component(value = "userService")
public class UserService implements InitializingBean {

	private OrderService orderService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private User admin;

	/**
	 * 当对象有多个有参数构造方法，选择无参构造方法
	 * 如果没有无参构造方法，直接报错
	 */
	public UserService() {
		System.out.println(0);
	}

	/**
	 * UserService的有参构造函数
	 * 当spring发现UserService只有这样一个构造方法，会寻找一个orderservice给注入
	 * @param orderService 当orderservice没有注解，spring也可以赋值
	 * 在Bean Map对象里面寻找order service Map<BeanName，Bean对象>
	 * 因为写的入参，不一定是beanName，比如 OrderService memberService，那byName寻找的时候，就会找到memberService的bean，注入错误
	 * 所以应该先按照类型去找，先byType，但是在map中可能，k1-v1，k2-v2，v1,v2是同一个类型
	 * 所以需要先byType 再byName
	 * 当查找到符合类型的bean只有一个的时候，就不会再根据Name寻找了
	 */
	@Autowired
	public UserService(OrderService orderService1) { //先byType 再byName
		this.orderService = orderService1;
		System.out.println(1);
	}

	/**
	 * UserService的第二个有参构造函数
	 * 当有多个有参构造函数，可以指定spring用哪一个构造方法
	 * 在该方法上加@Autowired注解，指定spring使用这个构造方法
	 * @param orderService
	 * @param orderService1
	 */
	// @Autowired
	// public UserService(OrderService orderService,OrderService orderService1) {
	// 	this.orderService = orderService;
	// 	System.out.println(2);
	// }

	//1-初始化前:admin变量 使用postconstruct注解
	@PostConstruct
	public void aVoid(){
		System.out.println("1-初始化前-post construct method ：a void");
	}

	@Transactional
	public void test() {
		System.out.println("orderService: "+orderService);
		jdbcTemplate.execute("INSERT INTO `bootdo`.`sys_user`( `username`, `name`, `password`, `dept_id`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `sex`, `birth`, `pic_id`, `live_address`, `hobby`, `province`, `city`, `district`) VALUES ( 'why', '王海洋', '3117dfced162cf6a34080259b83aa', 6, 'why@bootod.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);");
		a();
	}

	@Transactional(propagation = Propagation.NEVER)
	public void a() {
		System.out.println("orderService: "+orderService);
		jdbcTemplate.execute("INSERT INTO `bootdo`.`sys_user`( `username`, `name`, `password`, `dept_id`, `email`, `mobile`, `status`, `user_id_create`, `gmt_create`, `gmt_modified`, `sex`, `birth`, `pic_id`, `live_address`, `hobby`, `province`, `city`, `district`) VALUES ( 'wg', '王贵', '3117dfced162cf6a34080259b83aa', 6, 'why@bootod.com', NULL, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);");
	}

	//2-初始化-初始化的时候执行
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("2-初始化-初始化的时候执行afterPropertiesSet方法");
	}
}
