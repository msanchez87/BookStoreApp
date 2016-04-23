/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bookstore.process;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 * Plantilla base de facade de capa DAO
 *
 * @author ssanchez
 * @param <Entity> Entidad de base de datos
 * @param <PrimaryKey> clase que representa llave primaria
 */
public abstract class AbstractFacade<Entity, PrimaryKey> {

    @PersistenceContext(unitName = "BookStore-ejbPU")
    protected EntityManager entityManager;

    protected final Class<Entity> entityClass;

    public AbstractFacade(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }

    public void create(Entity entity) {
        entityManager.persist(entity);
    }

    public Entity find(PrimaryKey primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    public List<Entity> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Entity> criteriaQuery = builder.createQuery(entityClass);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public void update(Entity entity) {
        entityManager.merge(entity);
    }

    public void delete(Entity entity) {
        entityManager.remove(entity);
    }

}
