package br.com.abstractlayer.persistence.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import br.com.abstractlayer.persistence.pojo.Municipio;

public class TestInsert {
	
	@Test
	public void simpleTestInsert() {
		SessionFactory sf = HibernateHelper.newInstance().getFactory();
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		Municipio municipio = new Municipio();
		//municipio.setId(new Long(12));
		municipio.setCidade("Jaraa");
		municipio.setEstado("TRes");
		municipio.setUf("AM");
		session.save(municipio);
		transaction.commit();
	}

}
