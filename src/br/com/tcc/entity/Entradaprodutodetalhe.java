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
 * @author Leonardo
 */
@Entity
@Table(name = "entradaprodutodetalhe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entradaprodutodetalhe.findAll", query = "SELECT e FROM Entradaprodutodetalhe e"),
    @NamedQuery(name = "Entradaprodutodetalhe.findByIdEntradaRegistro", query = "SELECT e FROM Entradaprodutodetalhe e WHERE e.entradaprodutodetalhePK.idEntradaRegistro = :idEntradaRegistro"),
    @NamedQuery(name = "Entradaprodutodetalhe.findByIdProduto", query = "SELECT e FROM Entradaprodutodetalhe e WHERE e.entradaprodutodetalhePK.idProduto = :idProduto"),
    @NamedQuery(name = "Entradaprodutodetalhe.findByQtde", query = "SELECT e FROM Entradaprodutodetalhe e WHERE e.qtde = :qtde"),
    @NamedQuery(name = "Entradaprodutodetalhe.findByVlrUnitario", query = "SELECT e FROM Entradaprodutodetalhe e WHERE e.vlrUnitario = :vlrUnitario")})
public class Entradaprodutodetalhe implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntradaprodutodetalhePK entradaprodutodetalhePK;
    @Column(name = "qtde")
    private Integer qtde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlrUnitario")
    private Double vlrUnitario;
    @Column(name = "vlrTotal")
    private Double vlrTotal;
    @JoinColumn(name = "idEntradaRegistro", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Entradaprodutoregistro entradaprodutoregistro;
    @JoinColumn(name = "idProduto", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public Entradaprodutodetalhe() {
    }

    public Entradaprodutodetalhe(EntradaprodutodetalhePK entradaprodutodetalhePK) {
        this.entradaprodutodetalhePK = entradaprodutodetalhePK;
    }

    public Entradaprodutodetalhe(int idEntradaRegistro, int idProduto) {
        this.entradaprodutodetalhePK = new EntradaprodutodetalhePK(idEntradaRegistro, idProduto);
    }

    public EntradaprodutodetalhePK getEntradaprodutodetalhePK() {
        return entradaprodutodetalhePK;
    }

    public void setEntradaprodutodetalhePK(EntradaprodutodetalhePK entradaprodutodetalhePK) {
        this.entradaprodutodetalhePK = entradaprodutodetalhePK;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
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

    public Entradaprodutoregistro getEntradaprodutoregistro() {
        return entradaprodutoregistro;
    }

    public void setEntradaprodutoregistro(Entradaprodutoregistro entradaprodutoregistro) {
        this.entradaprodutoregistro = entradaprodutoregistro;
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
        hash += (entradaprodutodetalhePK != null ? entradaprodutodetalhePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entradaprodutodetalhe)) {
            return false;
        }
        Entradaprodutodetalhe other = (Entradaprodutodetalhe) object;
        if ((this.entradaprodutodetalhePK == null && other.entradaprodutodetalhePK != null) || (this.entradaprodutodetalhePK != null && !this.entradaprodutodetalhePK.equals(other.entradaprodutodetalhePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
//        return "br.com.tcc.entity.Entradaprodutodetalhe[ entradaprodutodetalhePK=" + entradaprodutodetalhePK + " ]";
        return "\n"+entradaprodutodetalhePK+"              "+qtde +"          "+ vlrUnitario +"          "+vlrTotal;
    }
    
}
