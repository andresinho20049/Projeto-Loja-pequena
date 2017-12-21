/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author andre
 */
@Entity(name="tb_produto")
public class Produto {
    
        @Id
        @Column(name="cd_produto")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int codigo;

    public static final String PROP_CODIGO = "codigo";

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        int oldCodigo = this.codigo;
        this.codigo = codigo;
        propertyChangeSupport.firePropertyChange(PROP_CODIGO, oldCodigo, codigo);
    }

        @Column(name="nm_produto")
        private String nome;

    public static final String PROP_NOME = "nome";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        propertyChangeSupport.firePropertyChange(PROP_NOME, oldNome, nome);
    }

    
    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
