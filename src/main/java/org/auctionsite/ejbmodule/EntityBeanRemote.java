/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auctionsite.ejbmodule;

import java.util.List;
import javax.ejb.Remote;

import org.auctionsite.model.PostEntity;
import org.auctionsite.model.UserEntity;

/**
 *
 * @author ubuntu
 */

@Remote
public interface EntityBeanRemote {

    void addUser(UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    void deleteUser(UserEntity userEntity);
    
    void addPost(PostEntity postEntity);

    void updatePost(PostEntity postEntity);

    void deletePost(PostEntity postEntity);

    UserEntity findUser(Object id);

    List<UserEntity> getAllUser();

    List<UserEntity> getUserInRange(int[] range);

    int countUser();
    
    PostEntity findPost(Object id);

    List<PostEntity> getAllPost();

    List<PostEntity> getPostInRange(int[] range);

    int countPost();
}
