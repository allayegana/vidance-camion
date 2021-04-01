package br.com.camion.vidanceCamion;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;

@Configuration
public class DataConfiguration {

       @Bean
        public DataSource dataSource () {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
            dataSource.setUsername("System");
            dataSource.setPassword("Futuro2021");
            return dataSource;
    }


        @Bean
        public JpaVendorAdapter jpaVendorAdapter () {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setDatabase(Database.ORACLE);
        adapter.setShowSql(true);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform("org.hibernate.dialect.Oracle10gDialect");
        adapter.setPrepareConnection(true);
        return adapter;
    }

}



