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
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f"),
    @NamedQuery(name = "Fornecedor.findById", query = "SELECT f FROM Fornecedor f WHERE f.id = :id"),
    @NamedQuery(name = "Fornecedor.findByNome", query = "SELECT f FROM Fornecedor f WHERE f.nome = :nome"),
    @NamedQuery(name = "Fornecedor.findByCpf", query = "SELECT f FROM Fornecedor f WHERE f.cpf = :cpf"),
    @NamedQuery(name = "Fornecedor.findByRg", query = "SELECT f FROM Fornecedor f WHERE f.rg = :rg"),
    @NamedQuery(name = "Fornecedor.findByCnpj", query = "SELECT f FROM Fornecedor f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedor.findByEndereco", query = "SELECT f FROM Fornecedor f WHERE f.endereco = :endereco"),
    @NamedQuery(name = "Fornecedor.findByEmail", query = "SELECT f FROM Fornecedor f WHERE f.email = :email"),
    @NamedQuery(name = "Fornecedor.findBySite", query = "SELECT f FROM Fornecedor f WHERE f.site = :site"),
    @NamedQuery(name = "Fornecedor.findByFone", query = "SELECT f FROM Fornecedor f WHERE f.fone = :fone"),
    @NamedQuery(name = "Fornecedor.findByCelular", query = "SELECT f FROM Fornecedor f WHERE f.celular = :celular")})
public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "email")
    private String email;
    @Column(name = "site")
    private String site;
    @Column(name = "fone")
    private String fone;
    @Column(name = "celular")
    private String celular;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private Collection<Produto> produtoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private Collection<Pagamentoparafornecedor> pagamentoparafornecedorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private Collection<Entradaprodutoregistro> entradaprodutoregistroCollection;
    @JoinColumn(name = "idBairro", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bairro idBairro;
    @JoinColumn(name = "idTipoFornecedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipofornecedor idTipoFornecedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private Collection<Pedidoregistro> pedidoregistroCollection;

    /**
     * Construtor padrão da classe <b>Fornecedor</b>
     */
    public Fornecedor() {
    }
    /**
     * Construtor sobrecarregado da classe <b>Fornecedor</b>
     * @param id inteiro que recebe a id da <b>Fornecedor</b>
     */
    public Fornecedor(Integer id) {
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
     * Método get do <b>cpf</b>
     * @return retorna um <b>cpf</b> String
     */
    public String getCpf() {
        return cpf;
    }
     /**
     * Método set <b>cpf</b>
     * @param cpf atribui uma instancia da classe 
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
     /**
     * Método get do <b>rg</b>
     * @return retorna um <b>rg</b> String
     */
    public String getRg() {
        return rg;
    }
     /**
     * Método set <b>rg</b>
     * @param rg atribui uma instancia da classe 
     */
    public void setRg(String rg) {
        this.rg = rg;
    }
     /**
     * Método get do <b>cnpj</b>
     * @return retorna um <b>cnpj</b> String
     */
    public String getCnpj() {
        return cnpj;
    }
     /**
     * Método set <b>cnpj</b>
     * @param cnpj  atribui uma instancia da classe 
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
     /**
     * Método get do <b>endereco</b>
     * @return retorna um <b>endereco</b> String
     */
    public String getEndereco() {
        return endereco;
    }
     /**
     * Método set <b>endereco</b>
     * @param endereco  atribui uma instancia da classe 
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
     /**
     * Método get do <b>email</b>
     * @return retorna um <b>email</b> String
     */
    public String getEmail() {
        return email;
    }
     /**
     * Método set <b>email</b>
     * @param email atribui uma instancia da classe 
     */
    public void setEmail(String email) {
        this.email = email;
    }
     /**
     * Método get do <b>site</b>
     * @return retorna um <b>site</b> String
     */
    public String getSite() {
        return site;
    }
     /**
     * Método set <b>site</b>
     * @param site atribui uma instancia da classe 
     */
    public void setSite(String site) {
        this.site = site;
    }
     /**
     * Método get do <b>fone</b>
     * @return retorna um <b>fone</b> String
     */
    public String getFone() {
        return fone;
    }
     /**
     * Método set <b>fone</b>
     * @param fone atribui uma instancia da classe 
     */
    public void setFone(String fone) {
        this.fone = fone;
    }
     /**
     * Método get do <b>celular</b>
     * @return retorna um <b>celular</b> String
     */
    public String getCelular() {
        return celular;
    }
     /**
     * Método set <b>celular</b>
     * @param celular atribui uma instancia da classe 
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    @XmlTransient
    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @XmlTransient
    public Collection<Pagamentoparafornecedor> getPagamentoparafornecedorCollection() {
        return pagamentoparafornecedorCollection;
    }

    public void setPagamentoparafornecedorCollection(Collection<Pagamentoparafornecedor> pagamentoparafornecedorCollection) {
        this.pagamentoparafornecedorCollection = pagamentoparafornecedorCollection;
    }

    @XmlTransient
    public Collection<Entradaprodutoregistro> getEntradaprodutoregistroCollection() {
        return entradaprodutoregistroCollection;
    }

    public void setEntradaprodutoregistroCollection(Collection<Entradaprodutoregistro> entradaprodutoregistroCollection) {
        this.entradaprodutoregistroCollection = entradaprodutoregistroCollection;
    }

    public Bairro getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Bairro idBairro) {
        this.idBairro = idBairro;
    }

    public Tipofornecedor getIdTipoFornecedor() {
        return idTipoFornecedor;
    }

    public void setIdTipoFornecedor(Tipofornecedor idTipoFornecedor) {
        this.idTipoFornecedor = idTipoFornecedor;
    }

    @XmlTransient
    public Collection<Pedidoregistro> getPedidoregistroCollection() {
        return pedidoregistroCollection;
    }

    public void setPedidoregistroCollection(Collection<Pedidoregistro> pedidoregistroCollection) {
        this.pedidoregistroCollection = pedidoregistroCollection;
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
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
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
