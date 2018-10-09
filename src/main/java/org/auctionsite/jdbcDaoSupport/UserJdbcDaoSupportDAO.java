package org.auctionsite.jdbcDaoSupport;

import org.auctionsite.model.UserEntity;
import java.util.List;

public interface UserJdbcDaoSupportDAO {

    public void insert(UserEntity user);

    public void insertBatch(List<UserEntity> users);

    public void insertBatchSQL(String sql);

    public String findNameByUserId(int userId);

    public UserEntity findByUserId(int userId);

    public UserEntity findByUserId2(int userId);

    public List<UserEntity> getAllUser();
    
    public boolean isAbleToLogin(String email, String password);
    
    public UserEntity getUserInfo(String email, String password);
    
}
