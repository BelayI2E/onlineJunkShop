/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.auctionsite.ejbspring;

import javax.ejb.CreateException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.ejb.support.AbstractStatelessSessionBean;
/**
 *
 * @author Windows
 */
public class BeanServiceEjb extends AbstractStatelessSessionBean implements BeanService{
    private static final String BEAN_NAME = "beanService";
    private BeanService beanService;
    
    public BeanServiceEjb(){
    
    }
    @Override
    public String echo(String message) {
        return beanService.echo(message);
    }
    
    @Override
    protected void onEjbCreate() throws CreateException {
      //BeanFactory beanFactory = getBeanFactory();
      //beanService = (BeanService)beanFactory.getBean(BEAN_NAME);
      beanService = (BeanService) getBeanFactory().getBean(BEAN_NAME);
   }
}
