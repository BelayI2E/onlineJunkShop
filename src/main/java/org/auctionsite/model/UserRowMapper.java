/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auctionsite.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Windows
 */
public class UserRowMapper implements RowMapper{

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
      UserEntity user = new UserEntity();
      user.setId(rs.getLong("id"));
      user.setFirstName(rs.getString("firstName"));
      user.setLastName(rs.getString("lastName"));
      user.setGender(rs.getString("gender"));
      user.setBirthdate(rs.getDate("birthdate"));
      user.setEmail(rs.getString("email"));
      user.setPassword(rs.getString("password"));
      user.setAvata(rs.getString("avata"));
      user.setPrivilege(rs.getString("privilege"));
      return user;
    }
    
}
