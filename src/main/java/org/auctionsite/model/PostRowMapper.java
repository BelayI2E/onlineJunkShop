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
public class PostRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        PostEntity post = new PostEntity();
        post.setId(rs.getLong("id"));
        post.setPostTitle(rs.getString("postTitle"));
        post.setPostDate(rs.getDate("postDate"));
        post.setShortDescription(rs.getString("shortDescription"));
        post.setFullDescription(rs.getString("fullDescription"));
        post.setPostPhoto(rs.getString("postPhoto"));
        post.setStatus(rs.getString("status"));
        post.setPrice(rs.getDouble("price"));
        post.setEmail(rs.getString("email"));
        post.setPhone(rs.getString("phone"));
        post.setInCategory(rs.getLong("inCategory"));
        post.setPostBy(rs.getLong("postBy"));
        return post;
    }
}
