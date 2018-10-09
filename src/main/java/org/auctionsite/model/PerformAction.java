/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auctionsite.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Windows
 */
public class PerformAction implements Serializable{
    
    private Long postId;
    private String postTitle;
    private Date postDate;
    private Long userId;
    private String firstName;
    private String lastName;
    private String actionStatus;
    private Date actionDate;

    public Date getPostDate() {
        return postDate;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public Long getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public Long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getActionStatus() {
        return actionStatus;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }
    
}
