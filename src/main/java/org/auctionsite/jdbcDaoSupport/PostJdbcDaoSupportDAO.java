/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auctionsite.jdbcDaoSupport;

import org.auctionsite.model.ActionEntity;
import org.auctionsite.model.CategoryEntity;
import org.auctionsite.model.PostEntity;
import org.auctionsite.model.PostInfo;
import org.auctionsite.model.CommentInfo;
import org.auctionsite.model.PerformAction;
import java.util.List;

/**
 *
 * @author Windows
 */
public interface PostJdbcDaoSupportDAO {

    public void insertPost(PostEntity post);

    public void insertBatchSQL(String sql);

    public String findPostTitleByPostId(int postId);

    public List<PostEntity> getPostByPostTitle(String postId);

    public PostInfo findByPostId(Long postId);

    public PostEntity findByPostId2(int userId);

    public List<PostEntity> getAllPost();
    
    public List<PostInfo> getAllPostInfo();
    
    public List<PostEntity> getAllPostByUser(Long userId);
    
    public List<PostEntity> getAllRecentPostTitle();
    
    public List<CategoryEntity> getAllCategory();
    
    public List<CommentInfo> getALLCommentInPost(Long postId);
    
    public List<PostInfo> findAllPostByUser(Long userId);
    
    public Long getCategoryByPost(Long postId);
    
    public List<PostEntity> getAllRelatedPost(Long categoryId);
    
    public List<PostEntity> getAllPostId();
            
    List<CommentInfo> getCommentByPosts(String listId);
    
    public List<PostEntity> getAllRecentPostTitleInCategory(Long categoryId);
    
    public List<PostInfo>getAllPostInfoInCategory(Long categoryId);
    
    public List<PostEntity> getAllRecentPostTitle(Long id);
    
    public void updatePostToBooked(Long postId);
    
    public void updatePostToWished(Long postId);
    
    public void insertAction(ActionEntity actionEntity);
    
    public List<PerformAction> getAllBookedPost(String listId);
    
    public List<PerformAction> getAllWishedPost(String listId);
}
