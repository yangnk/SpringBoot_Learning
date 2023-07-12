package com.yangnk.hfn.myTest;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcTest {
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
         this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getCount() {
        Integer count = this.jdbcTemplate.queryForObject("SELECT COUNT(*) FROM `UserTbl`", Integer.class);
        System.out.printf("count:%d\n", count);
        return count;
    }
}
