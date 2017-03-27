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
@Table(name = "tipopagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopagamento.findAll", query = "SELECT t FROM Tipopagamento t"),
    @NamedQuery(name = "Tipopagamento.findById", query = "SELECT t FROM Tipopagamento t WHERE t.id = :id"),
    @NamedQuery(name = "Tipopagamento.findByDescricao", query = "SELECT t FROM Tipopagamento t WHERE t.descricao = :descricao")})
public class Tipopagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPagamento")
    private Collection<Pagamentocliente> pagamentoclienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPagamento")
    private Collection<Pagamentoparafornecedor> pagamentoparafornecedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPagamento")
    private Collection<Vendaregistro> vendaregistroCollection;
    
    /**
     * Construtor padrão da classe <b>Tipopagamento</b>
     */
    public Tipopagamento() {
    }
    /**
     * Construtor sobrecarregado da classe <b>Tipopagamento</b>
     * @param id inteiro que recebe a id da <b>Tipopagamento</b>
     */
    public Tipopagamento(Integer id) {
        this.id = id;
    }
     /**
     * Método get do <b>id</b>
     * @return retorna um <b>id</b> inteiro
     */
    public Integer getId() {
        return id;
    }
     /** Método set <b>id</b>
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
     /** Método set <b>descricao</b>
     * @param descricao atribui uma instancia da classe 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Pagamentocliente> getPagamentoclienteCollection() {
        return pagamentoclienteCollection;
    }

    public void setPagamentoclienteCollection(Collection<Pagamentocliente> pagamentoclienteCollection) {
        this.pagamentoclienteCollection = pagamentoclienteCollection;
    }

    @XmlTransient
    public Collection<Pagamentoparafornecedor> getPagamentoparafornecedorCollection() {
        return pagamentoparafornecedorCollection;
    }

    public void setPagamentoparafornecedorCollection(Collection<Pagamentoparafornecedor> pagamentoparafornecedorCollection) {
        this.pagamentoparafornecedorCollection = pagamentoparafornecedorCollection;
    }

    @XmlTransient
    public Collection<Vendaregistro> getVendaregistroCollection() {
        return vendaregistroCollection;
    }

    public void setVendaregistroCollection(Collection<Vendaregistro> vendaregistroCollection) {
        this.vendaregistroCollection = vendaregistroCollection;
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
        if (!(object instanceof Tipopagamento)) {
            return false;
        }
        Tipopagamento other = (Tipopagamento) object;
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
