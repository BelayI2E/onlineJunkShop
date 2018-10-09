/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auctionsite.ejbspring;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author Windows
 */
public interface BeanServiceHome extends EJBLocalHome{
    public BeanServiceLocal create() throws CreateException;
}
