package cn.learning;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Package: cn.learning
 * @Description: SourceApplicationContextInitializer
 * @Author: Sammy
 * @Date: 2022/7/31 20:36
 */

public class SourceApplicationContextInitializer implements ApplicationContextInitializer {

	@Override
	public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
		configurableApplicationContext.getBeanFactory().registerSingleton("sourceTypeExcludeFilter",new SourceTypeExcludeFilter());
	}
}
