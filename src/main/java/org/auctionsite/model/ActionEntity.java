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
public class ActionEntity implements Serializable{
    
    private Long id;
    private Date actionDate;
    private String actionStatus;
    private Long actionBy;
    private Long actionOn;

    public Long getId() {
        return id;
    }

    public Date getActionDate() {
        return actionDate;
    }

    public String getActionStatus() {
        return actionStatus;
    }

    public Long getActionBy() {
        return actionBy;
    }

    public Long getActionOn() {
        return actionOn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActionDate(Date actionDate) {
        this.actionDate = actionDate;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public void setActionBy(Long actionBy) {
        this.actionBy = actionBy;
    }

    public void setActionOn(Long actionOn) {
        this.actionOn = actionOn;
    }
    
    
}
