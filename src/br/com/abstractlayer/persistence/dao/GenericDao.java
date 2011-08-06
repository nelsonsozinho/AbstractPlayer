package br.com.abstractlayer.persistence.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import br.com.abstractlayer.persistence.AbstractEntity;
import br.com.abstractlayer.persistence.exception.MoreThanOneException;
import br.com.abstractlayer.persistence.exception.PersistenceException;

public interface GenericDao<T extends AbstractEntity> extends Serializable {

	/**
     * Salva um objeto no banco de dados
     * 
     * @param element
     * @throws br.com.webbh.base.dao.PersistenceException
     */
    public Long save(T element) throws PersistenceException;

    /**
     * Atualiza um objeto no banco de dados
     * 
     * @param element
     * @throws br.com.webbh.base.dao.PersistenceException
     */
    public void update(T element) throws PersistenceException;

    /**
     * Remove uma unidade persistente no banco de dados
     * 
     * @param element
     * @throws br.com.webbh.base.dao.PersistenceException
     */
    public void remove(T element) throws PersistenceException;

    /**
     * Lista todos os elementos categorizados por classe
     * @param classe
     * @return
     */
    public List<T> listAll(Class<T> classe);

    /**
     * Lista os elementos de uma classe categorizados pelo exemplo
     * 
     * @param example
     * @return
     */
    public List<T> listByExample(T example);
    
    /**
     * Obtem um objeto atraves do exemplo
     * 
     * @param example
     * @return
     */
    public T getByExample(T example) throws MoreThanOneException;

    /**
     * 
     * 
     * @param example
     * @param inicio
     * @param quantidade
     * @return
     */
    public List<T> listByExampleRange(T example, Integer inicio, Integer quantidade);

    /**
     * Obtem o objeto atraves do ID
     * 
     * @param classe
     * @param id
     * @return
     */
    public T getById(Class classe, Serializable id);
    
    /**
     * Servico que executa uam HQL que retornara uma lista de objetos de acordo 
     * com o tipo genérico estabelecido
     * 
     * @param query
     * @return objetos
     */
    public List<T> executeQueyHQLByGenericType(String hqlQuery);
    
    /**
     * Executa que query SQL que retorna uma lista de objetos de acordo 
     * com o tipo generico estabelecido
     * 
     * @param sqlQuery
     * @return
     */
    public List<T> executeQuerySQLByGenericType(String sqlQuery);
    
    /**
     * Executa uma consulta SQL com que retorna uma lista de elementos resultante da 
     * consulta. O resultado é uma lista de Map's que contem, como chave, o nome dos 
     * campos cujo o valor está no resultado da consulta. Utilixando as duas estruturas 
     * de colecoes em conjunto é possível representar linhas e colunas. 
     * 
     * @param sqlQuery
     * @return
     */
    public List executeQuerySQL(String sqlQuery);
    
    /**
     * Executa uma consulta SQL parametizada ou n�o que retorna uma lista de objetos de acordo 
     * com o tipo generico estabelecido
     */
    public List<T> listByQuery(String sql, Map<String, Object> param);
    
    /**
     * Executa uma consulta SQL parametizada ou n�o que retorna uma lista de objetos de acordo 
     * com o tipo generico estabelecido
     */
    public List<T> listByQuery(String sql, Map<String, Object> param, int inicio, int maximo);
}
