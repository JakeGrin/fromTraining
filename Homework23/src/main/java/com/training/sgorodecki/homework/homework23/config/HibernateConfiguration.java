package com.training.sgorodecki.homework.homework23.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class HibernateConfiguration {

    private static final String HIBERNATE_HBM_2_DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_HBM_2_DDL_IMPORT_FILES = "hibernate.hbm2ddl.import_files";

    @Value("${dbUrl}")
    private String url;

    @Value("${user}")
    private String username;

    @Value("${pass}")
    private String password;

    @Value("${hibernate.hbm2ddl.auto}")
    private String hibernateAuto;

    @Value("${hibernate.dialect}")
    private String hibernateDialect;

    @Value("${hibernate.show_sql}")
    private String hibernateShowSql;

    @Value("${hibernate.hbm2ddl.import_files}")
    private String hibernateImport;


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.training.sgorodecki.homework.homework23.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
                = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
                HIBERNATE_HBM_2_DDL_AUTO, hibernateAuto);
        hibernateProperties.setProperty(
                HIBERNATE_DIALECT, hibernateDialect);
        hibernateProperties.setProperty(
                HIBERNATE_SHOW_SQL, hibernateShowSql);
        hibernateProperties.setProperty(
                HIBERNATE_HBM_2_DDL_IMPORT_FILES, hibernateImport);
        return hibernateProperties;
    }
}
