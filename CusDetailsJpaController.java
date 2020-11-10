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

/**
 *
 * @author vishnu
 */
public class CusDetailsJpaController implements Serializable {

    public CusDetailsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CusDetails cusDetails) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cusDetails);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CusDetails cusDetails) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cusDetails = em.merge(cusDetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cusDetails.getId();
                if (findCusDetails(id) == null) {
                    throw new NonexistentEntityException("The cusDetails with id " + id + " no longer exists.");
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
            CusDetails cusDetails;
            try {
                cusDetails = em.getReference(CusDetails.class, id);
                cusDetails.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cusDetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(cusDetails);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CusDetails> findCusDetailsEntities() {
        return findCusDetailsEntities(true, -1, -1);
    }

    public List<CusDetails> findCusDetailsEntities(int maxResults, int firstResult) {
        return findCusDetailsEntities(false, maxResults, firstResult);
    }

    private List<CusDetails> findCusDetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CusDetails.class));
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

    public CusDetails findCusDetails(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CusDetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getCusDetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CusDetails> rt = cq.from(CusDetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
