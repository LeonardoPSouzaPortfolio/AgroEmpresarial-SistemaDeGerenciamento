/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo P Souza
 */
@Entity
@Table(name = "itemvenda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itemvenda.findAll", query = "SELECT i FROM Itemvenda i"),
    @NamedQuery(name = "Itemvenda.findByIdVendaRegistro", query = "SELECT i FROM Itemvenda i WHERE i.idVendaRegistro = :idVendaRegistro"),
    @NamedQuery(name = "Itemvenda.findByIdProduto", query = "SELECT i FROM Itemvenda i WHERE i.idProduto = :idProduto"),
    @NamedQuery(name = "Itemvenda.findByQuantidade", query = "SELECT i FROM Itemvenda i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Itemvenda.findByValorUnitario", query = "SELECT i FROM Itemvenda i WHERE i.valorUnitario = :valorUnitario"),
    @NamedQuery(name = "Itemvenda.findByValorTotal", query = "SELECT i FROM Itemvenda i WHERE i.valorTotal = :valorTotal")})
public class Itemvenda implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idVendaRegistro")
    private Integer idVendaRegistro;
    @Basic(optional = false)
    @Column(name = "idProduto")
    private int idProduto;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "valorUnitario")
    private double valorUnitario;
    @Basic(optional = false)
    @Column(name = "valorTotal")
    private double valorTotal;

    public Itemvenda() {
    }

    public Itemvenda(Integer idVendaRegistro) {
        this.idVendaRegistro = idVendaRegistro;
    }

    public Itemvenda(Integer idVendaRegistro, int idProduto, int quantidade, double valorUnitario, double valorTotal) {
        this.idVendaRegistro = idVendaRegistro;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
    }

    public Integer getIdVendaRegistro() {
        return idVendaRegistro;
    }

    public void setIdVendaRegistro(Integer idVendaRegistro) {
        Integer oldIdVendaRegistro = this.idVendaRegistro;
        this.idVendaRegistro = idVendaRegistro;
        changeSupport.firePropertyChange("idVendaRegistro", oldIdVendaRegistro, idVendaRegistro);
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        int oldIdProduto = this.idProduto;
        this.idProduto = idProduto;
        changeSupport.firePropertyChange("idProduto", oldIdProduto, idProduto);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        int oldQuantidade = this.quantidade;
        this.quantidade = quantidade;
        changeSupport.firePropertyChange("quantidade", oldQuantidade, quantidade);
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        double oldValorUnitario = this.valorUnitario;
        this.valorUnitario = valorUnitario;
        changeSupport.firePropertyChange("valorUnitario", oldValorUnitario, valorUnitario);
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        double oldValorTotal = this.valorTotal;
        this.valorTotal = valorTotal;
        changeSupport.firePropertyChange("valorTotal", oldValorTotal, valorTotal);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVendaRegistro != null ? idVendaRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itemvenda)) {
            return false;
        }
        Itemvenda other = (Itemvenda) object;
        if ((this.idVendaRegistro == null && other.idVendaRegistro != null) || (this.idVendaRegistro != null && !this.idVendaRegistro.equals(other.idVendaRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.Itemvenda[ idVendaRegistro=" + idVendaRegistro + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
