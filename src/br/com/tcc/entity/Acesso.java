/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "acesso")
@NamedQueries({
    @NamedQuery(name = "Acesso.findAll", query = "SELECT a FROM Acesso a"),
    @NamedQuery(name = "Acesso.findById", query = "SELECT a FROM Acesso a WHERE a.id = :id"),
    @NamedQuery(name = "Acesso.verifiqueAcesso", query = "SELECT a FROM Acesso a WHERE a.idFuncionario = :idFuncionario and a.modelo = :modelo"),
    @NamedQuery(name = "Acesso.findByModelo", query = "SELECT a FROM Acesso a WHERE a.modelo = :modelo"),
    @NamedQuery(name = "Acesso.findByIdFuncionario", query = "SELECT a FROM Acesso a WHERE a.idFuncionario = :idFuncionario")})
public class Acesso implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @Column(name = "idFuncionario")
    private int idFuncionario;
    /**
     * Construtor padrão da classe <b>Acesso</b>
     */
    public Acesso() {
    }
    /**
     * Construtor sobrecarregado da classe <b>Acesso</b>
     * @param id inteiro que recebe a id da <b>Acesso</b>
     */
    public Acesso(Integer id) {
        this.id = id;
    }
    /**
     * Construtor sobrecarregado da classe <b>Acesso</b>
     * @param id inteiro que recebe a id da <b>Acesso</b>
     * @param modelo String que recebe o modelo da <b>Acesso</b>
     * @param idFuncionario  inteiro que recebe a idFuncionario da <b>Acesso</b>
     */
    public Acesso(Integer id, String modelo, int idFuncionario) {
        this.id = id;
        this.modelo = modelo;
        this.idFuncionario = idFuncionario;
    }
     /**
     * Método get do <b>id</b>
     * @return retorna um <b>id</b> inteiro
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }
     /**
     * Método get do <b>modelo</b>
     * @return retorna um <b>modelo</b> String
     */
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String oldModelo = this.modelo;
        this.modelo = modelo;
        changeSupport.firePropertyChange("modelo", oldModelo, modelo);
    }
     /**
     * Método get do <b>idFuncionario</b>
     * @return retorna um <b>idFuncionario</b> inteiro
     */
    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        int oldIdFuncionario = this.idFuncionario;
        this.idFuncionario = idFuncionario;
        changeSupport.firePropertyChange("idFuncionario", oldIdFuncionario, idFuncionario);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.view.Acesso[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
