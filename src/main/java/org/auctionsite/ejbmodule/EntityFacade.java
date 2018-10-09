package org.auctionsite.ejbmodule;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.auctionsite.model.PostEntity;
import org.auctionsite.model.UserEntity;

/**
 *
 * @author ubuntu
 */
@Stateless
public class EntityFacade implements EntityBeanRemote {
    
    public EntityFacade(){
    
    }
    
    @PersistenceContext(unitName = "OnlineJunkShopPU")
    private EntityManager em;

    @Override
    public void addUser(UserEntity userEntity) {
        em.persist(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        em.merge(userEntity);
    }

    @Override
    public void deleteUser(UserEntity userEntity) {
        em.remove(em.merge(userEntity));
    }

    @Override
    public UserEntity findUser(Object id) {
        return em.find(UserEntity.class, id);
    }

    @Override
    public List<UserEntity> getAllUser() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(UserEntity.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<UserEntity> getUserInRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(UserEntity.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public int countUser() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<UserEntity> rt = cq.from(UserEntity.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public PostEntity findPost(Object id) {
        return em.find(PostEntity.class, id);
    }

    @Override
    public List<PostEntity> getAllPost() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(PostEntity.class));
        return em.createQuery(cq).getResultList();
    }

    @Override
    public List<PostEntity> getPostInRange(int[] range) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(UserEntity.class));
        Query q = em.createQuery(cq);
        q.setMaxResults(range[1] - range[0]);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    @Override
    public int countPost() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<UserEntity> rt = cq.from(UserEntity.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    @Override
    public void addPost(PostEntity postEntity) {
        em.persist(postEntity);
    }

    @Override
    public void updatePost(PostEntity postEntity) {
        em.merge(postEntity);
    }

    @Override
    public void deletePost(PostEntity postEntity) {
        em.remove(em.merge(postEntity));
    }
}
