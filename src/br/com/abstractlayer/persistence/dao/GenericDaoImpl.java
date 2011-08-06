package br.com.abstractlayer.persistence.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


import org.hibernate.SQLQuery;
import org.hibernate.Session;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.abstractlayer.persistence.AbstractEntity;
import br.com.abstractlayer.persistence.exception.MoreThanOneException;
import br.com.abstractlayer.persistence.exception.PersistenceException;

public class GenericDaoImpl<T extends AbstractEntity> extends HibernateDaoSupport implements GenericDao<T> {

	private static final long serialVersionUID = -3424781899079126891L;
	
	
	public GenericDaoImpl() {
		super();
	}


	@Override
	public List<T> executeQueyHQLByGenericType(String hqlQuery) {
		List<T> result = executeQueyHQLByGenericType(hqlQuery);
		return result;
	}

	@Override
	public T getByExample(T example) throws MoreThanOneException {
		List<T> result = listByExample(example);
		if(!result.isEmpty()) {
			if(result.size() > 1) throw new MoreThanOneException("Existem elementos a mais que " +
				"nao foram esperados. O objeto de retorno " +
				"é unico");
			return result.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(Class classe, Serializable id) {
		return (T) getHibernateTemplate().get(classe, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listAll(Class<T> classe) {
		return getHibernateTemplate().loadAll(classe);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listByExample(T example) {
		return getHibernateTemplate().findByExample(example);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listByExampleRange(T example, Integer inicio, Integer quantidade) {
		return getHibernateTemplate().findByExample(example,inicio, quantidade);
	}

	@Override
	public void remove(T element) throws PersistenceException {
		getHibernateTemplate().delete(element);
	}

	
	public Long save(T element) throws PersistenceException {
		return (Long) getHibernateTemplate().save(element);
	}

	@Override
	public void update(T element) throws PersistenceException {
		getHibernateTemplate().update(element);
	}
	
	@Override
	public List executeQuerySQL(String sqlQuery) {
		List result = null;
		Session session = getSession();
		SQLQuery query = session.createSQLQuery(sqlQuery);
		result = query.list();
		return result;
	}

	@Override
	public List<T> executeQuerySQLByGenericType(String sqlQuery) {
		List result = null;
		Session session = getSession();
		SQLQuery query = session.createSQLQuery(sqlQuery);
		//TODO terminar
		
		return result;
	}


	@Override
	public List<T> listByQuery(String sql, Map<String, Object> param) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<T> listByQuery(String sql, Map<String, Object> param,
			int inicio, int maximo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
