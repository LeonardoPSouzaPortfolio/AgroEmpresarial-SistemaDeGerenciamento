/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "tipofornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipofornecedor.findAll", query = "SELECT t FROM Tipofornecedor t"),
    @NamedQuery(name = "Tipofornecedor.findById", query = "SELECT t FROM Tipofornecedor t WHERE t.id = :id"),
    @NamedQuery(name = "Tipofornecedor.findByDescricao", query = "SELECT t FROM Tipofornecedor t WHERE t.descricao = :descricao")})
public class Tipofornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoFornecedor")
    private Collection<Fornecedor> fornecedorCollection;

    /**
     * Construtor padrão da classe <b>Tipofornecedor</b>
     */
    public Tipofornecedor() {
    }

    /**
     * Construtor sobrecarregado da classe <b>Tipofornecedor</b>
     * @param id inteiro que recebe a id da <b>Tipofornecedor</b>
     */
    public Tipofornecedor(Integer id) {
        this.id = id;
    }

     /**
     * Método get do <b>descricao</b>
     * @return retorna um <b>descricao</b> inteiro
     */
    public Integer getId() {
        return id;
    }
     /**
     * Método set <b>id</b>
     * @param id atribui uma instancia da classe 
     */
    public void setId(Integer id) {
        this.id = id;
    }
     /**
     * Método get do <b>descricao</b>
     * @return retorna um <b>descricao</b> String
     */
    public String getDescricao() {
        return descricao;
    }
     /**
     * Método set <b>descricao</b>
     * @param descricao atribui uma instancia da classe 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
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
        if (!(object instanceof Tipofornecedor)) {
            return false;
        }
        Tipofornecedor other = (Tipofornecedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
}
