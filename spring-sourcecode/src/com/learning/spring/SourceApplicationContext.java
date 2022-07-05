package com.learning.spring;

import java.io.File;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Package: com.learning.spring
 * @Description: 模仿SpringApplicationContext
 * @Author: Sammy
 * @Date: 2022/7/4 13:30
 */

public class SourceApplicationContext {

	private Class configClass;

	private ConcurrentHashMap<String,BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	public SourceApplicationContext(Class configClass) {
		this.configClass = configClass;

		//扫描
		if (configClass.isAnnotationPresent(ComponentScan.class)) {

			ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
			String path = componentScanAnnotation.value(); //扫描路径

			path = path.replace(".", "/");
			ClassLoader classLoader = SourceApplicationContext.class.getClassLoader();
			
			URL resource = classLoader.getResource(path);
			File file = new File(resource.getFile());

			if (file.isDirectory()) {
				File[] files = file.listFiles();
				for (File f : files) {
					String fileName = f.getAbsolutePath();
					if (fileName.endsWith(".class")) {
						String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
						className = className.replace("/", ".");
						System.out.println(className);
						try {
							Class<?> clazz = classLoader.loadClass(className);
							if (clazz.isAnnotationPresent(Component.class)) {
								//如何判断一个Bean是单例or多例

								Component componentAnnotation = clazz.getAnnotation(Component.class);

								String beanName = componentAnnotation.value();

								BeanDefinition beanDefinition = new BeanDefinition();
								beanDefinition.setType(clazz);

								if (clazz.isAnnotationPresent(Scope.class)) {
									Scope annotationScope = clazz.getAnnotation(Scope.class);
									beanDefinition.setScope(annotationScope.value());
								} else {
									beanDefinition.setScope("singleton");
								}

								beanDefinitionMap.put(beanName, beanDefinition);
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	public Object getBean(String beanName) {
		return null;
	}
}
