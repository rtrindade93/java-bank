package org.academiadecodigo.javabank.persistence.dao.jpa;

import org.academiadecodigo.javabank.model.Model;
import org.academiadecodigo.javabank.persistence.dao.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericJpaDao<T extends Model> implements Dao<T> {

    @PersistenceContext
    protected EntityManager em;
    protected Class<T> modelType;

    public GenericJpaDao(Class<T> modelType) {
        this.modelType = modelType;
    }

    @Override
    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        return em.createQuery(criteriaQuery).getResultList();

        // Using JPQL
        //return em.createQuery( "from " + modelType.getSimpleName(), modelType).getResultList();
    }

    @Override
    public T findById(Integer id) {

        return em.find(modelType, id);

    }

    @Override
    public T saveOrUpdate(T modelObject) {

        return em.merge(modelObject);

    }

    @Override
    public void delete(Integer id) {

        em.remove(em.find(modelType, id));

    }
}
