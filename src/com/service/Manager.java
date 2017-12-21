/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andre
 */
public class Manager {
    
    private EntityManager em;
    
    private static Manager instance = null;
    
    public static Manager getInstance(){
        if (instance==null){
            instance = new Manager();
        }
        return instance;
    }
    
    private Manager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LojaCrudHibernatePU");
        em = emf.createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    
}
