package efeeney.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "efeeney")
@EnableTransactionManagement
@PropertySource("classpath:db/jdbc.properties")
public class AdvanceConfig {

	private static Logger logger = LoggerFactory.getLogger(AdvanceConfig.class);

	@Value("${driverClassName}")
	private String driverClassName;

	@Value("${url}")
	private String url;

	@Value("${username}")
	private String username;

	@Value("${password}")
	private String password;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource dataSource() {
		try {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			return dataSource;
		}catch (Exception e) {
			logger.error("DBCP DataSource bean cannot bе created!");
			return null;
		}
	}

	private Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
		hibernateProp.put("hibernate.connection.driver_class", "org.postgresql.Driver");
		hibernateProp.put("hibernate.connection.url", "jdbc:postgresql://localhost/springtest");
		hibernateProp.put("hibernate.connection.username", "postgres");
		hibernateProp.put("hibernate.connection.password", "koch2912");
		hibernateProp.put("hibernate.hbm2ddl.auto", "create");
		hibernateProp.put("hibernate.format_sql", true);
		hibernateProp.put("hibernate.use_sql_comments", true);
		hibernateProp.put("hibernate.show_sql", true);
		hibernateProp.put("hibernate.max_fetch_depth", 3);
		hibernateProp.put("hibernate.jdbc.batch_size", 10);
		hibernateProp.put("hibernate.jdbc.fetch_size", 50);
		return hibernateProp;
	}

	@Bean
	public SessionFactory sessionFactory() throws IOException {
		/*LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan("efeeney");
		sessionFactoryBean.setHibernateProperties(hibernateProperties());
		sessionFactoryBean.afterPropertiesSet();
		return sessionFactoryBean.getObject();*/
		return new LocalSessionFactoryBuilder(dataSource())
				.scanPackages("efeeney.entities")
				.addProperties(hibernateProperties())
				.buildSessionFactory();
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws IOException {
		return new HibernateTransactionManager(sessionFactory());
	}


}
