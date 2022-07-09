package com.learning.context.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Package: com.learning.service
 * @Description: AppConfig
 * @Author: Sammy
 * @Date: 2022/7/4 13:32
 */

@ComponentScan("com.learning.context")
// @EnableAspectJAutoProxy
@EnableTransactionManagement
@Configuration
public class AppConfig {

	/**
	 * 这里的orderservice1，和 orderservice2是两个不同名称，类型相同的bean
	 * 是两个独立的bean对象，按照名称注入的
	 * 是单例bean，不是单例对象
	 *
	 * @return
	 */
	// @Bean
	// public OrderService orderService1() {
	// 	return new OrderService();
	// }
	//
	// @Bean
	// public OrderService orderService2() {
	// 	return new OrderService();
	// }
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public PlatformTransactionManager platformTransactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/bootdo?useSSL=true&useUnicode=true&characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("kangta27");
		return dataSource;
	}
}
