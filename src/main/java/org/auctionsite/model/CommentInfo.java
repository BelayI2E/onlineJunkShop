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
public class CommentInfo implements Serializable{
    private Long userId;
    private String firstName;
    private String lastName;
    private String avata;
    private Date commentDate;
    private String comment;
    private int commnentOn;

    public int getCommnentOn() {
        return commnentOn;
    }

    public void setCommnentOn(int commnentOn) {
        this.commnentOn = commnentOn;
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

    public String getAvata() {
        return avata;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public String getComment() {
        return comment;
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

    public void setAvata(String avata) {
        this.avata = avata;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
