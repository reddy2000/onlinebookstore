/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project5;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import project5.exceptions.NonexistentEntityException;
import project5.exceptions.PreexistingEntityException;

/**
 *
 * @author vishnu
 */
public class Cart_1JpaController implements Serializable {

    public Cart_1JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cart_1 cart_1) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cart_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCart_1(cart_1.getIsbn()) != null) {
                throw new PreexistingEntityException("Cart_1 " + cart_1 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cart_1 cart_1) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cart_1 = em.merge(cart_1);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cart_1.getIsbn();
                if (findCart_1(id) == null) {
                    throw new NonexistentEntityException("The cart_1 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cart_1 cart_1;
            try {
                cart_1 = em.getReference(Cart_1.class, id);
                cart_1.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cart_1 with id " + id + " no longer exists.", enfe);
            }
            em.remove(cart_1);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cart_1> findCart_1Entities() {
        return findCart_1Entities(true, -1, -1);
    }

    public List<Cart_1> findCart_1Entities(int maxResults, int firstResult) {
        return findCart_1Entities(false, maxResults, firstResult);
    }

    private List<Cart_1> findCart_1Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cart_1.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cart_1 findCart_1(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cart_1.class, id);
        } finally {
            em.close();
        }
    }

    public int getCart_1Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cart_1> rt = cq.from(Cart_1.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
