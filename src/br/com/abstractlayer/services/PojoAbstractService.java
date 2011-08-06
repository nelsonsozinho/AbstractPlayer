package br.com.abstractlayer.services;

import br.com.abstractlayer.persistence.AbstractEntity;
import br.com.abstractlayer.persistence.dao.GenericDao;

/**
 * Classe abstrata que representa um servico
 * 
 * @author Nelson
 *
 */
public abstract class PojoAbstractService {

	private GenericDao<AbstractEntity> genericDao;
	
	
	/**
	 * Construtor que recebe um dao atraves do contexto de configuracao do Spring
	 * 
	 * @param genericDao
	 */
	public PojoAbstractService(GenericDao<AbstractEntity> genericDao) {
		setGenericDao(genericDao);
	}

	public GenericDao<AbstractEntity> getGenericDao() {
		return genericDao;
	}

	public void setGenericDao(GenericDao<AbstractEntity> genericDao) {
		this.genericDao = genericDao;
	}
	
}
