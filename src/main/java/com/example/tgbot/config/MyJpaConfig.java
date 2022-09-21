package com.example.tgbot.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

// ���������, ��� ��� ������������, ������� ��������� �� �����-�� ����� � �����-�� config-����, ���� ��������� ��������� ������������
@Configuration
@EnableJpaRepositories
@PropertySource("application.properties")
@EnableTransactionManagement
public class MyJpaConfig {

    // ������ �������� ��������� (� ����������� � �.�.)
    @Autowired
    private Environment env;

    @Bean
    public DataSource dataSource() {
        // �����������, ������ �� ����� ����� ������: �����/�����/������/�������
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        return dataSource;
    }

    // ������ ����� ���������������� entityManagerFactory, transactionManager, ������� �������������� �������� Hibernate
}