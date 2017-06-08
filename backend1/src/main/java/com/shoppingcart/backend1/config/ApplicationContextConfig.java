	package com.shoppingcart.backend1.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shoppingcart.backend1.model.Author;
import com.shoppingcart.backend1.model.Category;
import com.shoppingcart.backend1.model.Product;
import com.shoppingcart.backend1.model.Supplier;
import com.shoppingcart.backend1.model.User;
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages="com.shoppingcart.backend1")
public class ApplicationContextConfig {
	@Bean(name="dataSource")
	public DataSource geth2DataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();	
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("shopping");
		dataSource.setPassword("shopping");
		return dataSource;
		
	}
	
	
	@Autowired
	@Bean(name="sessionFactory")
	public  SessionFactory getSessionFactory(DataSource dataSource)
	{
		LocalSessionFactoryBuilder sessionFactory=new LocalSessionFactoryBuilder(dataSource);
		sessionFactory.addAnnotatedClass(Category.class);
		sessionFactory.addAnnotatedClass(Supplier.class);
		sessionFactory.addAnnotatedClass(Product.class);
		sessionFactory.addAnnotatedClass(User.class);
		sessionFactory.addAnnotatedClass(Author.class);
		sessionFactory.addProperties(getHibernateProperties());
		return sessionFactory.buildSessionFactory();
			
		
	}
	public Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto","update");
		return properties;
	}
	@Autowired
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}

