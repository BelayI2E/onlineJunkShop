/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auctionsite.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author ubuntu
 */
@Entity
@Table(name = "posts")
public class PostEntity implements Serializable {
    
    public PostEntity(){
    
    }
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
    
    @Column(name = "postTitle",nullable = false)
    private String postTitle;
    
    @Column(name = "postDate",nullable = false)
    @Temporal(DATE)
    private Date postDate;
    
    @Column(name = "shortDescription",nullable = false)
    private String shortDescription;
    
    @Column(name = "fullDescription",nullable = false)
    private String fullDescription;
    
    @Column(name = "postPhoto",nullable = false)
    private String postPhoto;
    
    @Column(name = "status",nullable = false)
    private String status;
    
    @Column(name = "price",nullable = false)
    private double price;
    
    @Column(name = "phone",nullable = false)
    private String phone;
    
    @Column(name = "email",nullable = false)
    private String email;
    
    @Column(name = "inCategory",nullable = false)
    private Long inCategory;
    
    @Column(name = "postBy",nullable = false)
    private Long postBy;

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
    
    public void setInCategory(Long inCategory) {
        this.inCategory = inCategory;
    }

    public Long getInCategory() {
        return inCategory;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public void setPostPhoto(String postPhoto) {
        this.postPhoto = postPhoto;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPostBy(Long postBy) {
        this.postBy = postBy;
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

    public String getFullDescription() {
        return fullDescription;
    }

    public String getPostPhoto() {
        return postPhoto;
    }

    public String getStatus() {
        return status;
    }

    public Long getPostBy() {
        return postBy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostEntity)) {
            return false;
        }
        PostEntity other = (PostEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlinejunkshop.ejb.Post[ id=" + id + " ]";
    }
    
}
