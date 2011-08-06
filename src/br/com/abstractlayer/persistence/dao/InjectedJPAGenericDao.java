package br.com.abstractlayer.persistence.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.abstractlayer.persistence.AbstractEntity;
import br.com.abstractlayer.persistence.exception.MoreThanOneException;
import br.com.abstractlayer.persistence.exception.PersistenceException;

/**
 * Implementation of GeneriDao for JPA object persist style. 
 * The entityManager should be injected by constructor 
 * 
 * @author nelsonsozinho
 *
 * @param <T>
 */
public abstract class InjectedJPAGenericDao<T extends AbstractEntity> implements GenericDao<T> {

	protected EntityManager entityManager;
	
	public InjectedJPAGenericDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Long save(T element) throws PersistenceException {
		entityManager.persist(element);
		return element.getId();
	}

	@Override
	public void update(T element) throws PersistenceException {
		entityManager.merge(element);
	}

	@Override
	public void remove(T element) throws PersistenceException {
		entityManager.remove(element);
	}

	@Override
	public List<T> listAll(Class<T> classe) {
		Query query = entityManager.createQuery("from " + classe.getSimpleName());
		List result = query.getResultList();
		return result;
	}

	public List<T> listByQuery(String sql, Map<String, Object> param){
		Query query = entityManager.createQuery(sql);
		
		if(param != null && !param.isEmpty()){
			for(String key : param.keySet()){
				query.setParameter(key, param.get(key));
			}
		}
		return (List<T>) query.getResultList();
	}
	
	public List<T> listByQuery(String sql, Map<String, Object> param, int inicio, int maximo) {
		Query query = entityManager.createQuery(sql);
		
		if(param != null && !param.isEmpty()){
			for(String key : param.keySet()){
				query.setParameter(key, param.get(key));
			}
		}
		query.setFirstResult(inicio);
		query.setMaxResults(maximo);
		
		return (List<T>) query.getResultList();
	}
	
	@Override
	public List<T> listByExample(T example) {
		//TODO 
		return null;
	}

	@Override
	public T getByExample(T example) throws MoreThanOneException {
		//TODO
		return null;
	}

	@Override
	public List<T> listByExampleRange(T example, Integer inicio, Integer quantidade) {
		//TODO
		return null;
	}

	@Override
	public T getById(Class classe, Serializable id) {
		T result = (T) entityManager.find(classe, id);
		return result;
	}

	@Override
	public List<T> executeQueyHQLByGenericType(String hqlQuery) {
		// TODO 
		return null;
	}

	@Override
	public List<T> executeQuerySQLByGenericType(String sqlQuery) {
		// TODO 
		return null;
	}

	@Override
	public List executeQuerySQL(String sqlQuery) {
		// TODO 
		return null;
	}
	
}
