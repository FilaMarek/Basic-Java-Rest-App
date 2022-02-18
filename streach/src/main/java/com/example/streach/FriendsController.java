package com.example.streach;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class FriendsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/listFriends")
    public ResponseEntity<List<friend>> listAllFriends() {

        String sql = "SELECT * FROM FRIENDS";

        List<friend> friends = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(friend.class));

        return new ResponseEntity<>(friends, HttpStatus.OK);
    }


    @PostMapping("/newfriend")
    public ResponseEntity<friend> friend(@RequestBody friend friend) {
        jdbcTemplate.update("INSERT INTO friends (NAME, AGE) VALUES(\'" + friend.name + "\',"+friend.age+")");
        return new ResponseEntity<>(friend, HttpStatus.CREATED);
    }
}
