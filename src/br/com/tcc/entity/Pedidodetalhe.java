/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo P Souza
 */
@Entity
@Table(name = "pedidodetalhe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidodetalhe.findAll", query = "SELECT p FROM Pedidodetalhe p"),
    @NamedQuery(name = "Pedidodetalhe.findByIdPedidoRegistro", query = "SELECT p FROM Pedidodetalhe p WHERE p.pedidodetalhePK.idPedidoRegistro = :idPedidoRegistro"),
    @NamedQuery(name = "Pedidodetalhe.findByIdProduto", query = "SELECT p FROM Pedidodetalhe p WHERE p.pedidodetalhePK.idProduto = :idProduto"),
    @NamedQuery(name = "Pedidodetalhe.findByDescricao", query = "SELECT p FROM Pedidodetalhe p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Pedidodetalhe.findByQtdePedido", query = "SELECT p FROM Pedidodetalhe p WHERE p.qtdePedido = :qtdePedido"),
    @NamedQuery(name = "Pedidodetalhe.findByVlrUnitario", query = "SELECT p FROM Pedidodetalhe p WHERE p.vlrUnitario = :vlrUnitario"),
    @NamedQuery(name = "Pedidodetalhe.findByVlrTotal", query = "SELECT p FROM Pedidodetalhe p WHERE p.vlrTotal = :vlrTotal")})
public class Pedidodetalhe implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PedidodetalhePK pedidodetalhePK;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "qtdePedido")
    private Integer qtdePedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlrUnitario")
    private Double vlrUnitario;
    @Column(name = "vlrTotal")
    private Double vlrTotal;
    @JoinColumn(name = "idPedidoRegistro", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pedidoregistro pedidoregistro;
    @JoinColumn(name = "idProduto", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public Pedidodetalhe() {
    }

    public Pedidodetalhe(PedidodetalhePK pedidodetalhePK) {
        this.pedidodetalhePK = pedidodetalhePK;
    }

    public Pedidodetalhe(int idPedidoRegistro, int idProduto) {
        this.pedidodetalhePK = new PedidodetalhePK(idPedidoRegistro, idProduto);
    }

    public PedidodetalhePK getPedidodetalhePK() {
        return pedidodetalhePK;
    }

    public void setPedidodetalhePK(PedidodetalhePK pedidodetalhePK) {
        this.pedidodetalhePK = pedidodetalhePK;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtdePedido() {
        return qtdePedido;
    }

    public void setQtdePedido(Integer qtdePedido) {
        this.qtdePedido = qtdePedido;
    }

    public Double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(Double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public Pedidoregistro getPedidoregistro() {
        return pedidoregistro;
    }

    public void setPedidoregistro(Pedidoregistro pedidoregistro) {
        this.pedidoregistro = pedidoregistro;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pedidodetalhePK != null ? pedidodetalhePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidodetalhe)) {
            return false;
        }
        Pedidodetalhe other = (Pedidodetalhe) object;
        if ((this.pedidodetalhePK == null && other.pedidodetalhePK != null) || (this.pedidodetalhePK != null && !this.pedidodetalhePK.equals(other.pedidodetalhePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.Pedidodetalhe[ pedidodetalhePK=" + pedidodetalhePK + " ]";
    }
    
}
