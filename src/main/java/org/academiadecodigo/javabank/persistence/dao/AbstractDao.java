package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.model.AbstractModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class AbstractDao<T extends AbstractModel> implements CRUDService<T> {

    protected EntityManagerFactory emf;
    private Class<T> modelType;

    public AbstractDao(EntityManagerFactory emf, Class<T> modelType) {
        this.emf = emf;
        this.modelType = modelType;
    }

    @Override
    public List<T> findAll() {

        EntityManager em = emf.createEntityManager();

        try {

            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
            Root<T> root = criteriaQuery.from(modelType);
            return em.createQuery(criteriaQuery).getResultList();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public T findById(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {

            return em.find(modelType, id);

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public T saveOrUpdate(T modelObject) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            T savedObject = em.merge(modelObject);
            em.getTransaction().commit();

            return savedObject;

        } catch (RollbackException ex) {

            em.getTransaction().rollback();
            return null;

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(Integer id) {

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();
            em.remove(em.find(modelType, id));
            em.getTransaction().commit();

        } catch (RollbackException ex) {

            em.getTransaction().rollback();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
