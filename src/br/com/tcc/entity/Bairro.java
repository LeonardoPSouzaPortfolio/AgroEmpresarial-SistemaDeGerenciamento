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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bairro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bairro.findAll", query = "SELECT b FROM Bairro b"),
    @NamedQuery(name = "Bairro.findById", query = "SELECT b FROM Bairro b WHERE b.id = :id"),
    @NamedQuery(name = "Bairro.findByNome", query = "SELECT b FROM Bairro b WHERE b.nome = :nome")})
public class Bairro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @JoinColumn(name = "idCidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cidade idCidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBairro")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBairro")
    private Collection<Fornecedor> fornecedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idBairro")
    private Collection<Funcionario> funcionarioCollection;
    /**
     * Construtor padrão da classe <b>Bairro</b>
     */
    public Bairro() {
    }
    /**
     * Construtor sobrecarregado da classe <b>Bairro</b>
     * @param id inteiro que recebe a id da <b>Bairro</b>
     */
    public Bairro(Integer id) {
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
     * Método get do <b>nome</b>
     * @return retorna um <b>nome</b> inteiro
     */
    public String getNome() {
        return nome;
    }
     /**
     * Método set <b>nome</b>
     * @param nome  atribui uma instancia da classe 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
     /**
     * Método get do <b>idCidade</b>
     * @return retorna um <b>idCidade</b> Cidade
     */
    public Cidade getIdCidade() {
        return idCidade;
    }
     /**
     * Método set <b>idCidade</b>
     * @param idCidade  atribui uma instancia da classe 
     */
    public void setIdCidade(Cidade idCidade) {
        this.idCidade = idCidade;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @XmlTransient
    public Collection<Fornecedor> getFornecedorCollection() {
        return fornecedorCollection;
    }

    public void setFornecedorCollection(Collection<Fornecedor> fornecedorCollection) {
        this.fornecedorCollection = fornecedorCollection;
    }

    @XmlTransient
    public Collection<Funcionario> getFuncionarioCollection() {
        return funcionarioCollection;
    }

    public void setFuncionarioCollection(Collection<Funcionario> funcionarioCollection) {
        this.funcionarioCollection = funcionarioCollection;
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
        if (!(object instanceof Bairro)) {
            return false;
        }
        Bairro other = (Bairro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
