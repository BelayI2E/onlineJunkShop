package org.auctionsite.jdbcDaoSupport;

import org.auctionsite.model.ActionEntity;
import org.auctionsite.model.CategoryEntity;
import org.auctionsite.model.CommentInfo;
import org.auctionsite.model.PerformAction;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import org.auctionsite.model.PostEntity;
import org.auctionsite.model.PostInfo;
import org.auctionsite.model.PostRowMapper;

public class PostJdbcDaoSupportDAOImpl extends JdbcDaoSupport implements PostJdbcDaoSupportDAO {

    @Override
    public void insertPost(PostEntity post) {
        String sql = "INSERT INTO posts" + "(postTitle, postDate, shortDescription, fulDescription,"
                + "postPhoto,status,price,email,phone,inCategory,postBy) " 
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{
            post.getPostTitle(), post.getPostDate(), post.getShortDescription(), post.getFullDescription(),
            post.getPostPhoto(), post.getStatus(), post.getPrice(), post.getEmail(),post.getPhone(),
            post.getInCategory(),post.getPostBy()
        });
    }

    @Override
    public void insertBatchSQL(final String sql) {
        getJdbcTemplate().batchUpdate(new String[]{sql});
    }

    @Override
    public String findPostTitleByPostId(int postId) {
        String sql = "SELECT postTitle FROM posts WHERE id = ?";
        String postTitle = (String) getJdbcTemplate().queryForObject(sql, new Object[]{postId}, String.class);
        return postTitle;
    }

    @Override
    public List<PostEntity> getAllPost() {
        String sql = "SELECT * FROM posts";
        List<PostEntity> posts = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(PostEntity.class));
        return posts;
    }

    @Override
    public PostInfo findByPostId(Long postId) {
        String sql = "SELECT users.id AS userId, users.avata, users.firstName, users.lastName,"
                + "posts.id AS postId, posts.postTitle, posts.postDate, posts.shortDescription,"
                + "posts.postPhoto, posts.price, posts.phone, posts.email"
                + " FROM users INNER JOIN posts ON users.id=posts.postBy WHERE posts.id= ?";
        PostInfo posts = (PostInfo) getJdbcTemplate().queryForObject(sql,new Object[]{postId},
                new BeanPropertyRowMapper(PostInfo.class));
        return posts;
    }
    
    @Override
    public PostEntity findByPostId2(int postId) {
        String sql = "SELECT * FROM posts WHERE id = ?";
        PostEntity post = (PostEntity) getJdbcTemplate().queryForObject(sql, new Object[]{postId}, 
                new BeanPropertyRowMapper(PostEntity.class));
        return post;
    }

    @Override
    public List<PostEntity> getPostByPostTitle(String postId) {
        String sql = "SELECT * FROM users WHERE postTitle like ?";
        List<PostEntity> posts = getJdbcTemplate().query(sql, new Object[]{postId}, new PostRowMapper());
        return posts;
    }

    @Override
    public List<PostEntity> getAllRecentPostTitle() {
        String sql = "SELECT id, postTitle FROM posts ORDER BY postDate DESC LIMIT 20";
        List<PostEntity> posts = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(PostEntity.class));
        return posts;
    }

    @Override
    public List<PostInfo> getAllPostInfo() {
        String sql = "SELECT users.id AS userId, users.avata, users.firstName, users.lastName,"
                + "posts.id AS postId, posts.postTitle, posts.postDate, posts.shortDescription,"
                + "posts.postPhoto, posts.price, posts.phone, posts.email"
                + " FROM users INNER JOIN posts ON users.id=posts.postBy WHERE posts.status = 'new' "
                + "ORDER BY posts.postDate DESC LIMIT 50";
        List<PostInfo> posts = getJdbcTemplate().query(sql,new BeanPropertyRowMapper(PostInfo.class));
        return posts;
    }

    @Override
    public List<PostEntity> getAllPostByUser(Long userId) {
        String sql = "SELECT * FROM posts WHERE postBy = ? AND status = 'new'";
        List<PostEntity> posts = getJdbcTemplate().query(sql,new Object[]{userId}, 
                new BeanPropertyRowMapper(PostEntity.class));
        return posts;
    }

    @Override
    public List<CategoryEntity> getAllCategory() {
        String sql = "SELECT * FROM categories";
        List<CategoryEntity> categories = getJdbcTemplate().query(sql, 
                new BeanPropertyRowMapper(CategoryEntity.class));
        return categories;
    }
    
    @Override
    public List<CommentInfo> getALLCommentInPost(Long postId) {
        String sql = "SELECT u.id AS userId, u.firstName, u.lastName, u.avata, c.commentDate, "
                + "c.comment FROM users u INNER JOIN comments c ON u.id = c.commentBy "
                + "INNER JOIN posts p ON c.commentOn = p.id WHERE p.Id = ?";
        List<CommentInfo> comments = getJdbcTemplate().query(sql,new Object[]{postId}, 
                new BeanPropertyRowMapper(CommentInfo.class));
        return comments;
    }

    @Override
    public List<PostInfo> findAllPostByUser(Long userId) {
        String sql = "SELECT users.id AS userId, users.avata, users.firstName, users.lastName,"
                + "posts.id AS postId, posts.postTitle, posts.postDate, posts.shortDescription,"
                + "posts.postPhoto, posts.price, posts.phone, posts.email"
                + " FROM users INNER JOIN posts ON users.id=posts.postBy WHERE users.id= ? AND post.status <> 'booked'";
        List<PostInfo> posts = getJdbcTemplate().query(sql,new Object[]{userId},
                new BeanPropertyRowMapper(PostInfo.class));
        return posts;
    }

    @Override
    public Long getCategoryByPost(Long postId) {
        String sql = "SELECT inCategory FROM posts WHERE id=?";
        Long categoryId= getJdbcTemplate().queryForObject(sql, new Object[]{postId},Long.class);
        return categoryId;
    }

    @Override
    public List<PostEntity> getAllRelatedPost(Long categoryId) {
        String sql = "SELECT id, postTitle FROM posts WHERE inCategory = ? AND status <> 'booked'";
        List<PostEntity> posts = getJdbcTemplate().query(sql,new Object[]{categoryId}, 
                new BeanPropertyRowMapper(PostEntity.class));
        return posts;
    }
    
    @Override
    public List<PostEntity> getAllPostId(){
        String sql="SELECT posts.id FROM posts ORDER BY posts.postDate DESC LIMIT 50";
        List<PostEntity> idList = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(PostEntity.class));
        return idList;
    }   
    
    @Override
    public List<CommentInfo> getCommentByPosts(String listId) {
        String condition = "(" + listId + ")";
        String sql = "SELECT u.id AS userId, u.firstName, u.lastName, u.avata, c.commentDate, c.comment "
                + "FROM users u INNER JOIN comments c ON u.id = c.commentBy WHERE c.commentOn IN " + condition;
        List<CommentInfo> comments = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(CommentInfo.class));
        return comments;
    }

    @Override
    public List<PostEntity> getAllRecentPostTitleInCategory(Long categoryId) {
        String sql = "SELECT id, postTitle FROM posts WHERE inCategory = ? AND status <> 'booked' ORDER BY postDate DESC LIMIT 20";
        List<PostEntity> posts = getJdbcTemplate().query(sql,new Object[]{categoryId},
                new BeanPropertyRowMapper(PostEntity.class));
        return posts;
    }

    @Override
    public List<PostInfo> getAllPostInfoInCategory(Long categoryId) {
        String sql = "SELECT users.id AS userId, users.avata, users.firstName, users.lastName,"
                + "posts.id AS postId, posts.postTitle, posts.postDate, posts.shortDescription,"
                + "posts.postPhoto, posts.price, posts.phone, posts.email"
                + " FROM users INNER JOIN posts ON users.id=posts.postBy WHERE posts.inCategory = ? AND posts.status <> 'booked'"
                + "ORDER BY posts.postDate DESC LIMIT 50";
        List<PostInfo> posts = getJdbcTemplate().query(sql, new Object[]{categoryId}, 
                new BeanPropertyRowMapper(PostInfo.class));
        return posts;
    }

    @Override
    public List<PostEntity> getAllRecentPostTitle(Long id) {
        String sql = "SELECT posts.id, posts.postTitle FROM posts WHERE posts.postBy = ? "
                + "ORDER BY postDate DESC";
        List<PostEntity> posts = getJdbcTemplate().query(sql,new Object[]{id}, 
                new BeanPropertyRowMapper(PostEntity.class));
        return posts;
    }

    @Override
    public void updatePostToBooked(Long postId) {
        getJdbcTemplate().update("update posts set status = 'booked' where id = ?", postId);
    }
    
    @Override
    public void updatePostToWished(Long postId) {
        getJdbcTemplate().update("update posts set status = 'wished' where id = ?", postId);
    }

    @Override
    public void insertAction(ActionEntity actionEntity) {
        String sql = "INSERT INTO actions" + "(actionDate, actionStatus, actionBy, actionOn) " 
                + "VALUES (?,?,?,?)";
        getJdbcTemplate().update(sql, new Object[]{
            actionEntity.getActionDate(), actionEntity.getActionStatus(), actionEntity.getActionBy(), 
            actionEntity.getActionOn()
        });
    }

    @Override
    public List<PerformAction> getAllBookedPost(String listId) {
        String condition = "(" + listId + ")";
        String sql = "SELECT p.id AS postId, p.postTitle, p.postDate, u.id AS userId, u.firstName, u.lastName,a.actionDate, "
                + "a.actionStatus FROM posts p INNER JOIN actions a ON p.id = a.actionOn INNER JOIN users u "
                + "ON u.id= a.actionBy WHERE a.actionOn IN " + condition + "AND a.actionStatus = 'booked'";
        List<PerformAction> actionInfos = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(PerformAction.class));
        return actionInfos;
    }

    @Override
    public List<PerformAction> getAllWishedPost(String listId) {
        String condition = "(" + listId + ")";
        String sql = "SELECT p.id AS postId, p.postTitle, p.postDate, u.id AS userId,u.firstName, u.lastName,a.actionDate, "
                + "a.actionStatus FROM posts p INNER JOIN actions a ON p.id = a.actionOn INNER JOIN users u "
                + "ON u.id= a.actionBy WHERE a.actionOn IN " + condition + " AND a.actionStatus = 'wished'";
        List<PerformAction> actionInfos = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(PerformAction.class));
        return actionInfos;
    } 
}
