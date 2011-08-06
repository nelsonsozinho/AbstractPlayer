package br.com.abstractlayer.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DefaultEntityManager {

private ClassPathXmlApplicationContext context;

	private static final String PATTER_NAME = "SpringContext.xml";

	private static DefaultEntityManager factory;

    private DefaultEntityManager() {
    	String[] fileContext = new String[]{"persistence"+PATTER_NAME, "dao"+PATTER_NAME, "service"+PATTER_NAME};
    	context = new ClassPathXmlApplicationContext(fileContext);
    }

    public static DefaultEntityManager getInstance() {
        if (factory == null) {
            factory = new DefaultEntityManager();
        }

        return factory;
    }

    public Object getObject(String nameObject) {
        Object object = null;
        object = context.getBean(nameObject);

        return object;
    }
	
}
