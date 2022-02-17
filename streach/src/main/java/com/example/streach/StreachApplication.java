package com.example.streach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class StreachApplication implements CommandLineRunner {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(StreachApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String sql = "SELECT * FROM FRIENDS";

        List<friend> friends = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(friend.class));

        friends.forEach(System.out :: println);

    }
}
