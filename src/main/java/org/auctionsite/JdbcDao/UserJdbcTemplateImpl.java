/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auctionsite.JdbcDao;

import java.util.List;
import javax.sql.DataSource;

import org.auctionsite.model.UserEntity;
import org.auctionsite.model.UserRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Windows
 */
public class UserJdbcTemplateImpl implements UserJdbcTemplateDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    @Override
    public void setDataSource(DataSource ds) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    @Override
    public List<UserEntity> listUsers() {
        String SQL = "SELECT * FROM users";
        List <UserEntity> users ;
        		users= jdbcTemplateObject.query(SQL, new UserRowMapper());
      return users;
    }

}
