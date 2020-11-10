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
public class BookDetailJpaController implements Serializable {

    public BookDetailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(BookDetail bookDetail) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(bookDetail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBookDetail(bookDetail.getIsbn()) != null) {
                throw new PreexistingEntityException("BookDetail " + bookDetail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BookDetail bookDetail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            bookDetail = em.merge(bookDetail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = bookDetail.getIsbn();
                if (findBookDetail(id) == null) {
                    throw new NonexistentEntityException("The bookDetail with id " + id + " no longer exists.");
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
            BookDetail bookDetail;
            try {
                bookDetail = em.getReference(BookDetail.class, id);
                bookDetail.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bookDetail with id " + id + " no longer exists.", enfe);
            }
            em.remove(bookDetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BookDetail> findBookDetailEntities() {
        return findBookDetailEntities(true, -1, -1);
    }

    public List<BookDetail> findBookDetailEntities(int maxResults, int firstResult) {
        return findBookDetailEntities(false, maxResults, firstResult);
    }

    private List<BookDetail> findBookDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BookDetail.class));
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

    public BookDetail findBookDetail(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BookDetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getBookDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BookDetail> rt = cq.from(BookDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
