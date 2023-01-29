//package com.routaa.hospital.configuration;
//
//import org.hibernate.jpa.HibernatePersistenceProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManagerFactory;
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//public class ApplicationConfig {
//
//    @Bean
//    EntityManagerFactory entityManagerFactory(){
//        LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
//        lfb.setDataSource(dataSource());
//        lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
//        lfb.setPackagesToScan("com.routaa.hospital.entity");
//        lfb.setJpaProperties(properties());
//        lfb.afterPropertiesSet();
//        return lfb.getObject();
//    }
//
//    @Bean
//    DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("postgres");
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        return dataSource;
//    }
//
//    Properties properties(){
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect","org.hibernate.dialect.PostgreSQLDialect");
//        properties.put("hibernate.show_sql","true");
//        properties.put("hibernate.hbm2ddl.auto","update");
//        return properties;
//    }
//
//    @Bean
//    @Autowired
//    JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory);
//        return transactionManager;
//    }
//
//}
