package br.com.abstractlayer.persistence.hibernate;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class TestHibernateHelper {
	
	@Test
	public void testLoadHelper() {
		SessionFactory factory = HibernateHelper.newInstance().getFactory();
	}

}
