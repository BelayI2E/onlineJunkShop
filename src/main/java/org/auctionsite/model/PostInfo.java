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
public class PostInfo implements Serializable{
    private Long userId;
    private String firstName;
    private String lastName;
    private String avata;
    private Long postId;
    private String postTitle;
    private Date postDate;
    private String shortDescription;
    private String postPhoto;
    private double price;
    private String phone;
    private String email;

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getUserId() {
        return userId;
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

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public void setPostPhoto(String postPhoto) {
        this.postPhoto = postPhoto;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getPostId() {
        return postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public Date getPostDate() {
        return postDate;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getPostPhoto() {
        return postPhoto;
    }

    public double getPrice() {
        return price;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
    
    
}
