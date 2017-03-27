/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo P Souza
 */
@Entity
@Table(name = "venda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venda.findAll", query = "SELECT v FROM Venda v"),
    @NamedQuery(name = "Venda.findById", query = "SELECT v FROM Venda v WHERE v.id = :id"),
    @NamedQuery(name = "Venda.findByIdCliente", query = "SELECT v FROM Venda v WHERE v.idCliente = :idCliente"),
    @NamedQuery(name = "Venda.findByIdFuncionario", query = "SELECT v FROM Venda v WHERE v.idFuncionario = :idFuncionario"),
    @NamedQuery(name = "Venda.findByIdTipoPagamento", query = "SELECT v FROM Venda v WHERE v.idTipoPagamento = :idTipoPagamento"),
    @NamedQuery(name = "Venda.findByDataVenda", query = "SELECT v FROM Venda v WHERE v.dataVenda = :dataVenda"),
    @NamedQuery(name = "Venda.findByValorVenda", query = "SELECT v FROM Venda v WHERE v.valorVenda = :valorVenda")})
public class Venda implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "idCliente")
    private int idCliente;
    @Basic(optional = false)
    @Column(name = "idFuncionario")
    private int idFuncionario;
    @Basic(optional = false)
    @Column(name = "idTipoPagamento")
    private int idTipoPagamento;
    @Basic(optional = false)
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @Basic(optional = false)
    @Column(name = "valorVenda")
    private double valorVenda;

    public Venda() {
    }

    public Venda(Integer id) {
        this.id = id;
    }

    public Venda(Integer id, int idCliente, int idFuncionario, int idTipoPagamento, Date dataVenda, double valorVenda) {
        this.id = id;
        this.idCliente = idCliente;
        this.idFuncionario = idFuncionario;
        this.idTipoPagamento = idTipoPagamento;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        int oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        int oldIdFuncionario = this.idFuncionario;
        this.idFuncionario = idFuncionario;
        changeSupport.firePropertyChange("idFuncionario", oldIdFuncionario, idFuncionario);
    }

    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(int idTipoPagamento) {
        int oldIdTipoPagamento = this.idTipoPagamento;
        this.idTipoPagamento = idTipoPagamento;
        changeSupport.firePropertyChange("idTipoPagamento", oldIdTipoPagamento, idTipoPagamento);
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        Date oldDataVenda = this.dataVenda;
        this.dataVenda = dataVenda;
        changeSupport.firePropertyChange("dataVenda", oldDataVenda, dataVenda);
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        double oldValorVenda = this.valorVenda;
        this.valorVenda = valorVenda;
        changeSupport.firePropertyChange("valorVenda", oldValorVenda, valorVenda);
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
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.Venda[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
