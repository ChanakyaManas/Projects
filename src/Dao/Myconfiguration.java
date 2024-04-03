package Dao;


import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@Configuration
@ComponentScan("First")
public class Myconfiguration {
@Bean
public	DataSource ds() {
	
	BasicDataSource bs=new BasicDataSource();
	bs.setUrl("jdbc:mysql://localhost:3306/");
	bs.setUsername("root");
	bs.setPassword("root");
	bs.setDriverClassName("com.mysql.cj.jdbc.Driver");
	return bs;
}
}
