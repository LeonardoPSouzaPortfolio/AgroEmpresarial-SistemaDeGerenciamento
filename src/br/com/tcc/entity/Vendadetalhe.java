/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "vendadetalhe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendadetalhe.findAll", query = "SELECT v FROM Vendadetalhe v"),
    @NamedQuery(name = "Vendadetalhe.findByIdVendaRegistro", query = "SELECT v FROM Vendadetalhe v WHERE v.vendadetalhePK.idVendaRegistro = :idVendaRegistro"),
    @NamedQuery(name = "Vendadetalhe.findByIdProduto", query = "SELECT v FROM Vendadetalhe v WHERE v.vendadetalhePK.idProduto = :idProduto"),
    @NamedQuery(name = "Vendadetalhe.findByQtde", query = "SELECT v FROM Vendadetalhe v WHERE v.qtde = :qtde"),
    @NamedQuery(name = "Vendadetalhe.findByVlrUnitario", query = "SELECT v FROM Vendadetalhe v WHERE v.vlrUnitario = :vlrUnitario"),
    @NamedQuery(name = "Vendadetalhe.findByVlrTotal", query = "SELECT v FROM Vendadetalhe v WHERE v.vlrTotal = :vlrTotal")})
public class Vendadetalhe implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VendadetalhePK vendadetalhePK;
    @Column(name = "qtde")
    private Integer qtde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlrUnitario")
    private Double vlrUnitario;
    @Column(name = "vlrTotal")
    private Double vlrTotal;
    @JoinColumn(name = "idProduto", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "idVendaRegistro", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Vendaregistro vendaregistro;

    public Vendadetalhe() {
    }

    public Vendadetalhe(VendadetalhePK vendadetalhePK) {
        this.vendadetalhePK = vendadetalhePK;
    }

    public Vendadetalhe(int idVendaRegistro, int idProduto) {
        this.vendadetalhePK = new VendadetalhePK(idVendaRegistro, idProduto);
    }

    public VendadetalhePK getVendadetalhePK() {
        return vendadetalhePK;
    }

    public void setVendadetalhePK(VendadetalhePK vendadetalhePK) {
        this.vendadetalhePK = vendadetalhePK;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        Integer oldQtde = this.qtde;
        this.qtde = qtde;
        changeSupport.firePropertyChange("qtde", oldQtde, qtde);
    }

    public Double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(Double vlrUnitario) {
        Double oldVlrUnitario = this.vlrUnitario;
        this.vlrUnitario = vlrUnitario;
        changeSupport.firePropertyChange("vlrUnitario", oldVlrUnitario, vlrUnitario);
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        Double oldVlrTotal = this.vlrTotal;
        this.vlrTotal = vlrTotal;
        changeSupport.firePropertyChange("vlrTotal", oldVlrTotal, vlrTotal);
    }
    

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        Produto oldProduto = this.produto;
        this.produto = produto;
        changeSupport.firePropertyChange("produto", oldProduto, produto);
    }

    public Vendaregistro getVendaregistro() {
        return vendaregistro;
    }

    public void setVendaregistro(Vendaregistro vendaregistro) {
        Vendaregistro oldVendaregistro = this.vendaregistro;
        this.vendaregistro = vendaregistro;
        changeSupport.firePropertyChange("vendaregistro", oldVendaregistro, vendaregistro);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendadetalhePK != null ? vendadetalhePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendadetalhe)) {
            return false;
        }
        Vendadetalhe other = (Vendadetalhe) object;
        if ((this.vendadetalhePK == null && other.vendadetalhePK != null) || (this.vendadetalhePK != null && !this.vendadetalhePK.equals(other.vendadetalhePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\n"+vendadetalhePK+"              "+qtde +"          "+ vlrUnitario +"          "+vlrTotal;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
