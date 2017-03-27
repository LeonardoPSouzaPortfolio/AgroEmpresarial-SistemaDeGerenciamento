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
@Table(name = "unidade")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidade.findAll", query = "SELECT u FROM Unidade u"),
    @NamedQuery(name = "Unidade.findById", query = "SELECT u FROM Unidade u WHERE u.id = :id"),
    @NamedQuery(name = "Unidade.findByDescricao", query = "SELECT u FROM Unidade u WHERE u.descricao = :descricao")})
public class Unidade implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUnidade")
    private Collection<Produto> produtoCollection;

    /**
     * Construtor padrão da classe <b>Unidade</b>
     */
    public Unidade() {
    }

    /**
     * Construtor sobrecarregado da classe <b>Unidade</b>
     * @param id inteiro que recebe a id da <b>Unidade</b>
     */
    public Unidade(Integer id) {
        this.id = id;
    }

    /**
     * Método get do <b>id</b>
     * @return retorna um <b>id</b> inteiro
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
     * Método set <b>id</b>
     * @param descricao atribui uma instancia da classe 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    /**
     * Método get do <b>ProdutoCollection</b> 
     * @return retorna uma coleção de Produto
     */
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    /**
     * Método set <b>ProdutoCollection</b>
     * @param produtoCollection atribui uma instancia da classe
     */
    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
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
        if (!(object instanceof Unidade)) {
            return false;
        }
        Unidade other = (Unidade) object;
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
