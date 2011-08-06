package br.com.abstractlayer.spring;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.abstractlayer.persistence.dao.GenericDao;

public class TestDefaultEntityManager {
	
	@Test
	public void testGetGenericDao() {
		DefaultEntityManager manager = DefaultEntityManager.getInstance();
		GenericDao genericDao = (GenericDao) manager.getObject("genericDao");
		assertNotNull(genericDao);
	}

}
