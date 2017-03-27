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
@Table(name = "produto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :id"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByVlrCompra", query = "SELECT p FROM Produto p WHERE p.vlrCompra = :vlrCompra"),
    @NamedQuery(name = "Produto.findByVlrVenda", query = "SELECT p FROM Produto p WHERE p.vlrVenda = :vlrVenda"),
    @NamedQuery(name = "Produto.findByNumEstoque", query = "SELECT p FROM Produto p WHERE p.numEstoque = :numEstoque"),
    @NamedQuery(name = "Produto.findByNumEstoqueCritico", query = "SELECT p FROM Produto p WHERE p.numEstoqueCritico = :numEstoqueCritico")})
public class Produto implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Pedidodetalhe> pedidodetalheCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "descricao")
    private String descricao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlrCompra")
    private Double vlrCompra;
    @Column(name = "vlrVenda")
    private Double vlrVenda;
    @Column(name = "numEstoque")
    private Integer numEstoque;
    @Column(name = "numEstoqueCritico")
    private Integer numEstoqueCritico;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Orcamentodetalhe> orcamentodetalheCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Entradaprodutodetalhe> entradaprodutodetalheCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private Collection<Vendadetalhe> vendadetalheCollection;
    @JoinColumn(name = "idFornecedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Fornecedor idFornecedor;
    @JoinColumn(name = "idUnidade", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Unidade idUnidade;

    /**
     * Construtor padrão da classe <b>Produto</b>
     */
    public Produto() {
    }

    /**
     * Construtor sobrecarregado da classe <b>Produto</b>
     *
     * @param id inteiro que recebe a id da <b>Produto</b>
     */
    public Produto(Integer id) {
        this.id = id;
    }

    /**
     * Método get do <b>id</b>
     *
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
     * Método set <b>descricao</b>
     * @param descricao atribui uma instancia da classe 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
     /**
     * Método get do <b>vlrCompra</b>
     * @return retorna um <b>vlrCompra</b> double
     */
    public Double getVlrCompra() {
        return vlrCompra;
    }
     /**
     * Método set <b>vlrCompra</b>
     * @param vlrCompra  atribui uma instancia da classe 
     */
    public void setVlrCompra(Double vlrCompra) {
        this.vlrCompra = vlrCompra;
    }
     /**
     * Método get do <b>vlrVenda</b>
     * @return retorna um <b>vlrVenda</b> double
     */
    public Double getVlrVenda() {
        return vlrVenda;
    }
     /**
     * Método set <b>vlrVenda</b>
     * @param vlrVenda  atribui uma instancia da classe 
     */
    public void setVlrVenda(Double vlrVenda) {
        this.vlrVenda = vlrVenda;
    }
     /**
     * Método get do <b>numEstoque</b>
     * @return retorna um <b>numEstoque</b> inteiro
     */
    public Integer getNumEstoque() {
        return numEstoque;
    }
     /**
     * Método set <b>numEstoque</b>
     * @param numEstoque  atribui uma instancia da classe 
     */
    public void setNumEstoque(Integer numEstoque) {
        this.numEstoque = numEstoque;
    }
     /**
     * Método get do <b>numEstoqueCritico</b>
     * @return retorna um <b>numEstoqueCritico</b> inteiro
     */
    public Integer getNumEstoqueCritico() {
        return numEstoqueCritico;
    }
     /**
     * Método set <b>numEstoqueCritico</b>
     * @param numEstoqueCritico  atribui uma instancia da classe 
     */
    public void setNumEstoqueCritico(Integer numEstoqueCritico) {
        this.numEstoqueCritico = numEstoqueCritico;
    }

    @XmlTransient
    public Collection<Orcamentodetalhe> getOrcamentodetalheCollection() {
        return orcamentodetalheCollection;
    }

    public void setOrcamentodetalheCollection(Collection<Orcamentodetalhe> orcamentodetalheCollection) {
        this.orcamentodetalheCollection = orcamentodetalheCollection;
    }

    @XmlTransient
    public Collection<Entradaprodutodetalhe> getEntradaprodutodetalheCollection() {
        return entradaprodutodetalheCollection;
    }

    public void setEntradaprodutodetalheCollection(Collection<Entradaprodutodetalhe> entradaprodutodetalheCollection) {
        this.entradaprodutodetalheCollection = entradaprodutodetalheCollection;
    }

    @XmlTransient
    public Collection<Vendadetalhe> getVendadetalheCollection() {
        return vendadetalheCollection;
    }

    public void setVendadetalheCollection(Collection<Vendadetalhe> vendadetalheCollection) {
        this.vendadetalheCollection = vendadetalheCollection;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Unidade getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Unidade idUnidade) {
        this.idUnidade = idUnidade;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\n"+descricao+"              "+ numEstoque + "              "
                + numEstoqueCritico + "              "
                + vlrCompra + "              "
                + vlrVenda;
    }

    @XmlTransient
    public Collection<Pedidodetalhe> getPedidodetalheCollection() {
        return pedidodetalheCollection;
    }

    public void setPedidodetalheCollection(Collection<Pedidodetalhe> pedidodetalheCollection) {
        this.pedidodetalheCollection = pedidodetalheCollection;
    }

}
