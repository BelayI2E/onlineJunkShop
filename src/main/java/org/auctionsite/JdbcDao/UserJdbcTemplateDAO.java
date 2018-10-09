/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auctionsite.JdbcDao;

import java.util.List;
import javax.sql.DataSource;

import org.auctionsite.model.UserEntity;

/**
 *
 * @author Windows
 * @param <UserEntity>
 */
public interface UserJdbcTemplateDAO<UserEntity> {
    
    public void setDataSource(DataSource ds);
    
    public List<UserEntity> listUsers();
}
