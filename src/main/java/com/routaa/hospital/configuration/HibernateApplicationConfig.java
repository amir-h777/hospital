//package com.routaa.hospital.configuration;
//
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.hibernate5.HibernateTransactionManager;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.util.Properties;
//
//@Configuration
//@EnableTransactionManagement
//public class HibernateApplicationConfig {
//
//    @Bean
//    SessionFactory sessionFactory(){
//        LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
//        sfb.setDataSource(dataSource());
//        sfb.setPackagesToScan("com.routaa.hospital.entity");
//        sfb.setHibernateProperties(properties());
//        try {
//            sfb.afterPropertiesSet();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return sfb.getObject();
//    }
//
//    @Bean
//    DataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/hospital");
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
//    HibernateTransactionManager transactionManager(SessionFactory sessionFactory){
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//        return transactionManager;
//    }
//
//}
