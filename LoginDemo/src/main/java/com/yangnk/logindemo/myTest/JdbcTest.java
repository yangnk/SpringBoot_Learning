package com.yangnk.logindemo.myTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class JdbcTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
         this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getCount() {
        Integer count = this.jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
        System.out.printf("count:%d\n", count);
        return count;
    }
}

