/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auctionsite.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author ubuntu
 */
@Entity
@Table(name = "users")
public class UserEntity implements Serializable {
    
    public UserEntity(){
    
    }
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
    
    @Column(name = "firstName",nullable = false)
    private String firstName;
    
    @Column(name = "lastName",nullable = false)
    private String lastName;
    
    @Column(name = "gender",nullable = false)
    private String gender;
    
    @Column(name = "birthdate",nullable = false)
    @Temporal(DATE)
    private Date birthdate;
    
    @Column(name = "email",nullable = false)
    private String email;
    
    @Column(name = "password",nullable = false)
    private String password;
    
    @Column(name = "avata",nullable = true)
    private String avata;
    
    @Column(name="privilege",nullable = false)
    private String privilege;

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }
    
    public String getPrivilege() {
        return privilege;
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAvata(String avata) {
        this.avata = avata;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAvata() {
        return avata;
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
        if (!(object instanceof UserEntity)) {
            return false;
        }
        UserEntity other = (UserEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onlinejunkshop.ejb.User[ id=" + id + " ]";
    }
    
}
