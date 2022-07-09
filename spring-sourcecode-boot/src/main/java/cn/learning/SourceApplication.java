package cn.learning;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class SourceApplication {
    public static void main( String[] args ) {
		ConfigurableApplicationContext configApplicationContext = SpringApplication.run(SourceApplication.class);
		DataSource dataSource = configApplicationContext.getBean(DataSource.class);
		System.out.println(dataSource);
		System.out.println( "Hello World!" );
    }
}
