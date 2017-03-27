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
@Table(name = "funcao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Funcao.findAll", query = "SELECT f FROM Funcao f"),
    @NamedQuery(name = "Funcao.findById", query = "SELECT f FROM Funcao f WHERE f.id = :id"),
    @NamedQuery(name = "Funcao.findByNome", query = "SELECT f FROM Funcao f WHERE f.nome = :nome")})
public class Funcao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncao")
    private Collection<Funcionario> funcionarioCollection;
    /**
     * Construtor padrão da classe <b>Funcao</b>
     */
    public Funcao() {
    }
    /**
     * Construtor sobrecarregado da classe <b>Funcao</b>
     * @param id inteiro que recebe a id da <b>Funcao</b>
     */
    public Funcao(Integer id) {
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
     * @return retorna um <b>nome</b> String
     */
    public String getNome() {
        return nome;
    }
     /**
     * Método set <b>nome</b>
     * @param nome atribui uma instancia da classe 
     */
    public void setNome(String nome) {
        this.nome = nome;
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
        if (!(object instanceof Funcao)) {
            return false;
        }
        Funcao other = (Funcao) object;
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
