package com.project.sampleapp.config;



	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.context.annotation.PropertySource;
	import org.springframework.context.support.ResourceBundleMessageSource;
	import org.springframework.core.env.Environment;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;
	import org.springframework.orm.hibernate5.HibernateTransactionManager;
	import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
	import org.springframework.transaction.annotation.EnableTransactionManagement;
	import org.springframework.web.multipart.commons.CommonsMultipartResolver;
	import org.springframework.web.servlet.view.InternalResourceViewResolver;
	
	import java.util.Properties;
	import javax.sql.DataSource;
	import org.hibernate.SessionFactory;

	@Configuration
	@ComponentScan("com.project.sampleapp")
	@EnableTransactionManagement
	public class HibernateConfig {

		@Autowired
		Environment env;
		/*@Bean(name="viewResolver")
		public InternalResourceViewResolver getViewResolver() {
			InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
			viewResolver.setPrefix("/WEB-INF/views/");
			viewResolver.setSuffix("*.jsp");
			return viewResolver;
		}*/
//		@Bean(name="multipartResolver")
		//public CommonsMultipartResolver multipartResolver() {
		//	CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
			//set Max size
			//CommonsMultipartResolver.setMaxUploadSize("..)
		//	return commonsMultipartResolver;
		//}
		
		@Bean(name="dataSource")
		public DataSource getDataSource() {
			DriverManagerDataSource dataSource=new 		DriverManagerDataSource();
			
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://10.100.4.113:3306/javacoe_pool");
			dataSource.setUsername("javacoe");
			dataSource.setPassword("admin@123");
			
			return dataSource;
		}
		
		@Autowired
		@Bean(name="SessionFactory")
		public SessionFactory getSessionFactory(DataSource dataSource) throws Exception{
			Properties properties=new Properties();
			//refer ds-hibernate-cgf.properties
			properties.put("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
			properties.put("hibernate.show_sql",true);
			properties.put("current_session_context_class","thread");
			
			LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
			factoryBean.setPackagesToScan(new String[] {"com.project.sampleapp.model"});
			factoryBean.setDataSource(dataSource);
			factoryBean.setHibernateProperties(properties);
			factoryBean.afterPropertiesSet();
			
			SessionFactory sf=factoryBean.getObject();
			return sf;
		}
		@Autowired
		@Bean(name="transactionManager")
		public HibernateTransactionManager getTransactionManager(SessionFactory sf) {
			HibernateTransactionManager hibTransMgr=new HibernateTransactionManager(sf);
			return hibTransMgr;
		}
		
		//@Bean(name="productDao")
		//public ProductDao getProductDao() {
		//	return new ProductDaoImpl();
		//}
		
	}

