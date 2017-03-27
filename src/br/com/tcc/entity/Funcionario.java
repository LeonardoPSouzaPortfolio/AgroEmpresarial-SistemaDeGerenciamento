/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "funcionario")
@XmlRootElement
@NamedQueries
        ({
    @NamedQuery(name = "Funcionario.findAll", query = "SELECT f FROM Funcionario f"),
    @NamedQuery(name = "Funcionario.findById", query = "SELECT f FROM Funcionario f WHERE f.id = :id"),
    @NamedQuery(name = "Funcionario.findByNome", query = "SELECT f FROM Funcionario f WHERE f.nome = :nome"),
    @NamedQuery(name = "Funcionario.findByLogin", query = "SELECT f FROM Funcionario f WHERE f.login = :login"),
    @NamedQuery(name = "Funcionario.findBySenha", query = "SELECT f FROM Funcionario f WHERE f.senha = :senha"),
    @NamedQuery(name = "Funcionario.findByAdmissao", query = "SELECT f FROM Funcionario f WHERE f.admissao = :admissao"),
    @NamedQuery(name = "Funcionario.findByAcessoTotal", query = "SELECT f FROM Funcionario f WHERE f.acessoTotal = :acessoTotal"),
    @NamedQuery(name = "Funcionario.verificaLogin", query = "SELECT f FROM Funcionario f WHERE f.login = :login and f.senha = :senha"),
    @NamedQuery(name = "Funcionario.pegaNome", query = "SELECT f.nome FROM Funcionario f WHERE f.login = :login")
})
public class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "login")
    private String login;
    @Column(name = "senha")
    private String senha;
    @Column(name = "admissao")
    @Temporal(TemporalType.DATE)
    private Date admissao;
    @Column(name = "acessoTotal")
    private Character acessoTotal;
    @OneToMany(mappedBy = "idFuncionario")
    private Collection<Orcamentoregistro> orcamentoregistroCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFuncionario")
    private Collection<Vendaregistro> vendaregistroCollection;
    @JoinColumn(name = "idFuncao", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcao idFuncao;
    @JoinColumn(name = "idBairro", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bairro idBairro;
    /**
     * Construtor padrão da classe <b>Funcionario</b>
     */
    public Funcionario() {
    }
    /**
     * Construtor sobrecarregado da classe <b>Funcionario</b>
     * @param id inteiro que recebe a id de <b>Funcionario</b>
     */
    public Funcionario(Integer id) {
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
     /**
     * Método get do <b>login</b>
     * @return retorna um <b>login</b> String
     */
    public String getLogin() {
        return login;
    }
     /**
     * Método set <b>login</b>
     * @param login  atribui uma instancia da classe 
     */
    public void setLogin(String login) {
        this.login = login;
    }
     /**
     * Método get do <b>senha</b>
     * @return retorna um <b>senha</b> String
     */
    public String getSenha() {
        return senha;
    }
     /**
     * Método set <b>senha</b>
     * @param senha atribui uma instancia da classe 
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
     /**
     * Método get do <b>admissao</b>
     * @return retorna um <b>admissao</b> Date
     */
    public Date getAdmissao() {
        return admissao;
    }
     /**
     * Método set <b>admissao</b>
     * @param admissao  atribui uma instancia da classe 
     */
    public void setAdmissao(Date admissao) {
        this.admissao = admissao;
    }
     /**
     * Método get do <b>acessoTotal</b>
     * @return retorna um <b>acessoTotal</b> Chacacter
     */
    public Character getAcessoTotal() {
        return acessoTotal;
    }
     /**
     * Método set <b>acessoTotal</b>
     * @param acessoTotal  atribui uma instancia da classe 
     */
    public void setAcessoTotal(Character acessoTotal) {
        this.acessoTotal = acessoTotal;
    }

    @XmlTransient
    public Collection<Orcamentoregistro> getOrcamentoregistroCollection() {
        return orcamentoregistroCollection;
    }

    public void setOrcamentoregistroCollection(Collection<Orcamentoregistro> orcamentoregistroCollection) {
        this.orcamentoregistroCollection = orcamentoregistroCollection;
    }

    @XmlTransient
    public Collection<Vendaregistro> getVendaregistroCollection() {
        return vendaregistroCollection;
    }

    public void setVendaregistroCollection(Collection<Vendaregistro> vendaregistroCollection) {
        this.vendaregistroCollection = vendaregistroCollection;
    }

    public Funcao getIdFuncao() {
        return idFuncao;
    }

    public void setIdFuncao(Funcao idFuncao) {
        this.idFuncao = idFuncao;
    }

    public Bairro getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Bairro idBairro) {
        this.idBairro = idBairro;
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
        if (!(object instanceof Funcionario)) {
            return false;
        }
        Funcionario other = (Funcionario) object;
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
