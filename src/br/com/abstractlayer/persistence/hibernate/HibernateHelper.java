package br.com.abstractlayer.persistence.hibernate;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class HibernateHelper {

	private static SessionFactory factory;
	
	private static HibernateHelper helper;
	
	//TODO implementar suporte a thread local 
	static {
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.configure(new File("src/hibernate.cfg.xml"));
		factory = config.buildSessionFactory();
	}
	
	private HibernateHelper() {
		
	}
	
	public static HibernateHelper newInstance() {
		if(helper == null) {
			helper = new HibernateHelper();
		}
		
		return helper;
	}
	
	public SessionFactory getFactory() {
		return factory;
	}
	
	
}
