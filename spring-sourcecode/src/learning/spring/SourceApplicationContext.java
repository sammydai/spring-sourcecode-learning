package learning.spring;

/**
 * @Package: com.learning.spring
 * @Description: 模仿SpringApplicationContext
 * @Author: Sammy
 * @Date: 2022/7/4 13:30
 */

public class SourceApplicationContext {

	private Class configClass;

	public SourceApplicationContext(Class configClass) {
		this.configClass = configClass;
	}

	public Object getBean(String beanName) {
		return null;
	}
}
