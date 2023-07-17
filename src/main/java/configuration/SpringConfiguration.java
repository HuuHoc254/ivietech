package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "repository")
@EnableTransactionManagement
//@ComponentScan(basePackages = "service")
public class SpringConfiguration {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_order");
        dataSource.setUsername("root");
        dataSource.setPassword("nguyenhuuhoc25042003");
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        //Refer to dataSource()
        entityManager.setDataSource(dataSource());
        //Initialize our configuration with default settings Hibernate
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        //Packe to scan for entity class
        entityManager.setPackagesToScan("entity");

        //JPA properties
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("hibernate","org.hibernate.dialect.MySQLDialect");
        jpaProperties.setProperty("hibernate.hbm2ddl.auto","update");
        /*
         * update: update existing DB, data will be keep
         * create: drop all DB, then re-create. All data will be loss
         * RECOMMEND: create -> DB structure -> update
         * */

        entityManager.setJpaProperties(jpaProperties);
        return entityManager;
    }

    @Bean
    public JpaTransactionManager transactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        //Refer to entityManagerFactory()
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return jpaTransactionManager;
    }
}