package com.learning.spring;

import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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
	private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();


	public SourceApplicationContext(Class configClass) {
		this.configClass = configClass;

		//1、扫描ComponentScan注解下的路径--》.class文件
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
						// System.out.println(className); //com.learning.service.UserService
						try {
							//2、扫描有Component注解的对象
							Class<?> clazz = classLoader.loadClass(className);
							if (clazz.isAnnotationPresent(Component.class)) {
								//如何判断一个Bean是单例or多例
								Component componentAnnotation = clazz.getAnnotation(Component.class);

								String beanName = componentAnnotation.value();

								if (beanName.equals("")) {
									beanName = Introspector.decapitalize(clazz.getSimpleName());
								}

								BeanDefinition beanDefinition = new BeanDefinition();
								beanDefinition.setType(clazz);
								//如果有scope注解使用注解的value值，如果没有，默认设置为单例
								if (clazz.isAnnotationPresent(Scope.class)) {
									Scope annotationScope = clazz.getAnnotation(Scope.class);
									beanDefinition.setScope(annotationScope.value());
								} else {
									beanDefinition.setScope("singleton");
								}
								//把扫描出来的bean，组装成beanDefinition，然后放到map集合中
								beanDefinitionMap.put(beanName, beanDefinition);
							}
						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
		//3、遍历所有beanDefinitionMap，create bean对象
		for (String beanName : beanDefinitionMap.keySet()) {
			BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
			if (beanDefinition.getScope().equals("singleton")) {
				Object bean = createBean(beanName, beanDefinition);
				singletonObjects.put(beanName, bean);
			}
		}
	}

	private Object createBean(String beanName, BeanDefinition beanDefinition) {
		Class clazz = beanDefinition.getType();
		try {
			Object instance = clazz.getConstructor().newInstance();
			for (Field field : clazz.getDeclaredFields()) {
				if (field.isAnnotationPresent(Autowired.class)) {
					field.setAccessible(true);
					//对这个实例对象instance的这个field（变量）赋值value
					// 赋值的value是一个对象，比如orderservice对象，所以从getBean方法中获取
					field.set(instance,getBean(field.getName()));
				}
			}
			//Aware
			if (instance instanceof BeanNameAware) {
				System.out.println("回调这个beannameaware的方法");
				((BeanNameAware)instance).setBeanName(beanName);
			}

			return instance;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Object getBean(String beanName) {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (beanDefinition == null) {
			throw new NullPointerException();
		} else {
			String scope = beanDefinition.getScope();
			if ("singleton".equals(scope)) {
				Object bean = singletonObjects.get(beanName);
				if (bean==null) {
					Object o = createBean(beanName, beanDefinition);
					singletonObjects.put(beanName, o);
				}
				return bean;
			} else {
				//多例
				return createBean(beanName, beanDefinition);
			}
		}
	}
}
