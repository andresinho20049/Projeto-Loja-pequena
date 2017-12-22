/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Produto;
import com.service.Manager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author andre
 */
public class DaoProduto {
    
    private EntityManager em;
    
    public DaoProduto(){
        em = Manager.getInstance().getEm();
    }
    
    public void Salvar(Produto p){
        em.getTransaction().begin();
        if (p.getCodigo()>0){
            p = em.merge(p);
        }
        em.persist(p);
        em.getTransaction().commit();
    }
    
    public List<Produto> findAll(){
        Query qry = em.createQuery("Select p from com.model.Produto p ");
        List result = qry.getResultList();  
        return (List<Produto>) result;
    }
    
    public void Remover(Produto p){
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }
    
}
