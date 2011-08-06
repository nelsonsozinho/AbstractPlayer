package br.com.abstractlayer.spring;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class WebEmtityManager {

private static WebEmtityManager instance;
	
	private WebApplicationContext context;

	/**
	 * Construtor padrao
	 */
	private WebEmtityManager() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ServletContext servletContext = (ServletContext) externalContext.getContext();
        context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
	}
	
	/**
	 * Obtem a instacia do singleton
	 * 
	 * @return
	 */
	public static WebEmtityManager getInstance() {
		if(instance == null) {
			instance = new WebEmtityManager();
		}
		
		return instance;
	}
	
	/**
	 * Obtem o bean
	 * 
	 * @param name
	 * @return
	 */
	public Object getMB(String name) {
		Object bean = context.getBean(name);
		return bean;
	}
	
}
