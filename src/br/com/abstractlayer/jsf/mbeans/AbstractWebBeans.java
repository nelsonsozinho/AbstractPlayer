package br.com.abstractlayer.jsf.mbeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.abstractlayer.persistence.pojo.Usuario;


public class AbstractWebBeans implements Serializable {

public static String USER_SESSION = "user";
	
	public static final String QUESTIONARIO_SELECIONADO = "questionarioSelecionado";
	
	
	private HttpSession session;
	
	private FacesContext context;
	
	private ExternalContext externalContext;
	
	/**
	 * Construtor padrao
	 */
	public AbstractWebBeans() {
		context = FacesContext.getCurrentInstance();
		externalContext = context.getExternalContext();
		session = (HttpSession) externalContext.getSession(true);
	}
	

	/**
	 * Obtem o usuario logado que esta presente na sessao
	 * 
	 * @return
	 */
	public Usuario getUserSession() {
		Usuario usuario = (Usuario) session.getAttribute(AbstractWebBeans.USER_SESSION);
		return usuario;
	}
	
	/**
	 * Obtem um elemento contido na sessao através do nome
	 * 
	 * @param name
	 * @return
	 */
	public Object getSessionElement(String name) {
		if(name == null) throw new NullPointerException("Nome do elemento vazio");
		return session.getAttribute(name);
	}

	/**
	 * Cria uma mensagem de erro para ser disponibilizada na view 
	 * @return
	 */
	public FacesMessage newErrorMessage() {
		FacesMessage message = new FacesMessage();
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		return message;
	}
	
	public Object getParameter(String name) {
		return getExternalContext().getRequestParameterMap().get(name);
	}
	
	public HttpSession getSession() {
		return session;
	}

	public FacesContext getContext() {
		return context;
	}

	public ExternalContext getExternalContext() {
		return externalContext;
	}
	
}
