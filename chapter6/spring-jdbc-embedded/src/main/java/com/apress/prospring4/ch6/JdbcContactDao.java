package com.apress.prospring4.ch6;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by bobby on 4/24/2017.
 */
public class JdbcContactDao implements ContactDao, InitializingBean {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Override
    public String findFirstNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT FIRST_NAME FROM CONTACT WHERE ID = ?",
                new Object[]{id}, String.class);
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        MySQLErrorCodesTranslator errorTranslator =
                new MySQLErrorCodesTranslator();

        errorTranslator.setDataSource(dataSource);

        jdbcTemplate.setExceptionTranslator(errorTranslator);

        this.jdbcTemplate = jdbcTemplate;
    }

    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Must set dataSource on ContactDao");
        }

        if (jdbcTemplate == null) {
            throw new BeanCreationException("Null JdbcTemplate on ContactDao");
        }
    }
}
