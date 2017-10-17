package org.academiadecodigo.javabank.persistence.dao;

import org.academiadecodigo.javabank.managers.SessionManager;
import org.academiadecodigo.javabank.model.AbstractModel;
import org.academiadecodigo.javabank.exceptions.TransactionException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public abstract class JpaGenericDao<T extends AbstractModel> implements DAO<T> {

    protected SessionManager<EntityManager> SessionManager;
    private Class<T> modelType;

    public JpaGenericDao(SessionManager SessionManager, Class<T> modelType) {
        this.SessionManager = SessionManager;
        this.modelType = modelType;
    }

    @Override
    public List<T> findAll() {

        EntityManager em = SessionManager.getCurrentSession();

        try {
            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
            criteriaQuery.from(modelType);
            return em.createQuery(criteriaQuery).getResultList();
        } catch (RuntimeException ex) {
            throw new TransactionException();
        }
    }

    @Override
    public T findById(Integer id) {

        EntityManager em = SessionManager.getCurrentSession();

        try {
            return em.find(modelType, id);
        } catch (RuntimeException ex) {
            throw new TransactionException();
        }
    }

    @Override
    public T saveOrUpdate(T modelObject) {

        EntityManager em = SessionManager.getCurrentSession();
        try {
            T savedObject = em.merge(modelObject);
            return savedObject;
        } catch (RuntimeException ex) {
            throw new TransactionException();
        }
    }

    @Override
    public void delete(Integer id) {

        EntityManager em = SessionManager.getCurrentSession();

        try {
            em.remove(em.find(modelType, id));
        } catch (RuntimeException ex) {
            throw new TransactionException();
        }
    }
}
