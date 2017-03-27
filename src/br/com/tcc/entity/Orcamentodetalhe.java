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
@Table(name = "orcamentodetalhe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamentodetalhe.findAll", query = "SELECT o FROM Orcamentodetalhe o"),
    @NamedQuery(name = "Orcamentodetalhe.findByIdOrcamentoRegistro", query = "SELECT o FROM Orcamentodetalhe o WHERE o.orcamentodetalhePK.idOrcamentoRegistro = :idOrcamentoRegistro"),
    @NamedQuery(name = "Orcamentodetalhe.findByIdProduto", query = "SELECT o FROM Orcamentodetalhe o WHERE o.orcamentodetalhePK.idProduto = :idProduto"),
    @NamedQuery(name = "Orcamentodetalhe.findByQtde", query = "SELECT o FROM Orcamentodetalhe o WHERE o.qtde = :qtde"),
    @NamedQuery(name = "Orcamentodetalhe.findByVlrUnitario", query = "SELECT o FROM Orcamentodetalhe o WHERE o.vlrUnitario = :vlrUnitario")})
public class Orcamentodetalhe implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrcamentodetalhePK orcamentodetalhePK;
    @Column(name = "qtde")
    private Integer qtde;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlrUnitario")
    private Double vlrUnitario;
    @Column(name = "vlrTotal")
    private Double vlrTotal;
    @JoinColumn(name = "idOrcamentoRegistro", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orcamentoregistro orcamentoregistro;
    @JoinColumn(name = "idProduto", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public Orcamentodetalhe() {
    }

    public Orcamentodetalhe(OrcamentodetalhePK orcamentodetalhePK) {
        this.orcamentodetalhePK = orcamentodetalhePK;
    }

    public Orcamentodetalhe(int idOrcamentoRegistro, int idProduto) {
        this.orcamentodetalhePK = new OrcamentodetalhePK(idOrcamentoRegistro, idProduto);
    }

    public OrcamentodetalhePK getOrcamentodetalhePK() {
        return orcamentodetalhePK;
    }

    public void setOrcamentodetalhePK(OrcamentodetalhePK orcamentodetalhePK) {
        this.orcamentodetalhePK = orcamentodetalhePK;
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

    public Orcamentoregistro getOrcamentoregistro() {
        return orcamentoregistro;
    }

    public void setOrcamentoregistro(Orcamentoregistro orcamentoregistro) {
        Orcamentoregistro oldOrcamentoregistro = this.orcamentoregistro;
        this.orcamentoregistro = orcamentoregistro;
        changeSupport.firePropertyChange("orcamentoregistro", oldOrcamentoregistro, orcamentoregistro);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        Produto oldProduto = this.produto;
        this.produto = produto;
        changeSupport.firePropertyChange("produto", oldProduto, produto);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orcamentodetalhePK != null ? orcamentodetalhePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orcamentodetalhe)) {
            return false;
        }
        Orcamentodetalhe other = (Orcamentodetalhe) object;
        if ((this.orcamentodetalhePK == null && other.orcamentodetalhePK != null) || (this.orcamentodetalhePK != null && !this.orcamentodetalhePK.equals(other.orcamentodetalhePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.Orcamentodetalhe[ orcamentodetalhePK=" + orcamentodetalhePK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
