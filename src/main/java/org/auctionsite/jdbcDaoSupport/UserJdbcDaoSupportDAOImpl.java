package org.auctionsite.jdbcDaoSupport;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.auctionsite.model.UserEntity;
import org.auctionsite.model.UserRowMapper;

public class UserJdbcDaoSupportDAOImpl extends JdbcDaoSupport implements UserJdbcDaoSupportDAO {

    @Override
    public void insert(UserEntity user) {
        String sql = "INSERT INTO users"
                + "(firstName, lastName, gender,birthdate,email,password,avata,privilege) "
                + "VALUES (?,?,?,?,?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{
            user.getFirstName(), user.getLastName(), user.getGender(), user.getBirthdate(),
            user.getEmail(), user.getPassword(), user.getAvata(), user.getPrivilege()
        });
    }

    @Override
    public void insertBatch(final List<UserEntity> users) {
        String sql = "INSERT INTO users"
                + "(firstName, lastName, gender,birthdate,email,password,avata,privilege) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                UserEntity user = users.get(i);
                ps.setString(2, user.getFirstName());
                ps.setString(3, user.getLastName());
                ps.setString(4, user.getGender());
                ps.setDate(5, (Date) user.getBirthdate());
                ps.setString(6, user.getEmail());
                ps.setString(7, user.getPassword());
                ps.setString(8, user.getAvata());
                ps.setString(9, user.getPrivilege());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
    }

    @Override
    public void insertBatchSQL(final String sql) {
        getJdbcTemplate().batchUpdate(new String[]{sql});
    }

    @Override
    public UserEntity findByUserId(int userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        UserEntity user = (UserEntity) getJdbcTemplate().queryForObject(sql, new Object[]{userId}, new UserRowMapper());
        return user;
    }

    @Override
    public List<UserEntity> getAllUser() {
        String sql = "SELECT * FROM users";
        List<UserEntity> users = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(UserEntity.class));
        return users;
    }

    @Override
    public String findNameByUserId(int userId) {
        String sql = "SELECT firstName FROM users WHERE id = ?";
        String name = (String) getJdbcTemplate().queryForObject(sql, new Object[]{userId}, String.class);
        return name;
    }

    @Override
    public UserEntity findByUserId2(int userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        UserEntity user = (UserEntity) getJdbcTemplate().queryForObject(
                sql, new Object[]{userId},
                new BeanPropertyRowMapper(UserEntity.class));
        return user;
    }

    @Override
    public boolean isAbleToLogin(String email, String password) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
        String count= (String)getJdbcTemplate().queryForObject(sql, new Object[]{email,password},String.class);
        if(Integer.valueOf(count)==1) return true;
        return false;
    }

    @Override
    public UserEntity getUserInfo(String email, String password) {
        String sql = "SELECT id, firstName FROM users WHERE email = ? AND password = ?";
        UserEntity user= (UserEntity)getJdbcTemplate().queryForObject(sql, new Object[]{email,password}, new BeanPropertyRowMapper(UserEntity.class));
        return user;
    }
}
