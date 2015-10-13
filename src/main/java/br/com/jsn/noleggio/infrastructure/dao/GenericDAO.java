package br.com.jsn.noleggio.infrastructure.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<T> implements Serializable {
	private static final long serialVersionUID = -1346304670895222289L;

	private Class<T> classe;
	@Inject
	protected EntityManager entityManager;

	protected GenericDAO(Class<T> classe) {
		this.classe = classe;
	}

	protected void save(T entity) {
		entityManager.persist(entity);
	}

	protected T update(T entity) {
		return entityManager.merge(entity);
	}

	protected void delete(Object id, Class<T> classe) {
		T entityToBeRemoved = entityManager.getReference(classe, id);
		entityManager.remove(entityToBeRemoved);
	}

	protected T findById(int id) {
		return entityManager.find(classe, id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll() {
		CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
		criteriaQuery.select(criteriaQuery.from(classe));
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
}