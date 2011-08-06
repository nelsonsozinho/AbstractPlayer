package br.com.abstractlayer.spring.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.orm.hibernate3.support.OpenSessionInViewFilter;
import org.springframework.transaction.support.TransactionSynchronizationManager;


public class SpringOpenSessionInView extends OpenSessionInViewFilter {

	private static Logger logger = Logger.getLogger(SpringOpenSessionInView.class);
    
    
    
    @Override
    protected void closeSession(Session session, SessionFactory sessionFactory) {
        session.flush();
        logger.debug("Flush efetuadao");
        super.closeSession(session, sessionFactory);
        logger.debug("Sessao fechada");
    }

    @Override
    protected Session getSession(SessionFactory sessionFactory) throws DataAccessResourceFailureException {
        Session session = SessionFactoryUtils.getSession(sessionFactory, true);
        logger.debug("Sessao Obtida");
        session.setFlushMode(FlushMode.COMMIT);
        logger.debug("Flux mode commit efetuado");
        return session;
    }
    
    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        SessionFactory sessionFactory = lookupSessionFactory(request);
        Session session = null;
        boolean participate = false;

        if (isSingleSession()) {
            // single session mode
            if (TransactionSynchronizationManager.hasResource(sessionFactory)) {
                // Do not modify the Session: just set the participate flag.
                participate = true;
            } else {
                logger.debug("Opening single Hibernate Session in OpenSessionInViewFilter");
                session = getSession(sessionFactory);
                TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(session));
            }
        } else {
            // deferred close mode
            if (SessionFactoryUtils.isDeferredCloseActive(sessionFactory)) {
                // Do not modify deferred close: just set the participate flag.
                participate = true;
            } else {
                SessionFactoryUtils.initDeferredClose(sessionFactory);
            }
        }

        try {
            filterChain.doFilter(request, response);
        } finally {
            if (!participate) {
                if (isSingleSession()) {
                    // single session mode
                    TransactionSynchronizationManager.unbindResource(sessionFactory);
                    logger.debug("Closing single Hibernate Session in OpenSessionInViewFilter");
                    closeSession(session, sessionFactory);
                } else {
                    // deferred close mode
                    SessionFactoryUtils.processDeferredClose(sessionFactory);
                }
            }
        }
    }

	
}
