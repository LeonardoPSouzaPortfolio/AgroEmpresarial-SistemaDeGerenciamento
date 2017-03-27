/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "pagamentoparafornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamentoparafornecedor.findAll", query = "SELECT p FROM Pagamentoparafornecedor p"),
    @NamedQuery(name = "Pagamentoparafornecedor.findById", query = "SELECT p FROM Pagamentoparafornecedor p WHERE p.id = :id"),
    @NamedQuery(name = "Pagamentoparafornecedor.findByVlrTotal", query = "SELECT p FROM Pagamentoparafornecedor p WHERE p.vlrTotal = :vlrTotal"),
    @NamedQuery(name = "Pagamentoparafornecedor.findByVlrDesconto", query = "SELECT p FROM Pagamentoparafornecedor p WHERE p.vlrDesconto = :vlrDesconto"),
    @NamedQuery(name = "Pagamentoparafornecedor.findByVlrPago", query = "SELECT p FROM Pagamentoparafornecedor p WHERE p.vlrPago = :vlrPago"),
    @NamedQuery(name = "Pagamentoparafornecedor.findByDataPagamento", query = "SELECT p FROM Pagamentoparafornecedor p WHERE p.dataPagamento = :dataPagamento")})
public class Pagamentoparafornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlrTotal")
    private Double vlrTotal;
    @Column(name = "vlrDesconto")
    private Double vlrDesconto;
    @Column(name = "vlrPago")
    private Double vlrPago;
    @Column(name = "dataPagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @JoinColumn(name = "idFornecedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Fornecedor idFornecedor;
    @JoinColumn(name = "idTipoPagamento", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tipopagamento idTipoPagamento;

    public Pagamentoparafornecedor() {
    }

    public Pagamentoparafornecedor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public Double getVlrDesconto() {
        return vlrDesconto;
    }

    public void setVlrDesconto(Double vlrDesconto) {
        this.vlrDesconto = vlrDesconto;
    }

    public Double getVlrPago() {
        return vlrPago;
    }

    public void setVlrPago(Double vlrPago) {
        this.vlrPago = vlrPago;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Tipopagamento getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(Tipopagamento idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
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
        if (!(object instanceof Pagamentoparafornecedor)) {
            return false;
        }
        Pagamentoparafornecedor other = (Pagamentoparafornecedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.Pagamentoparafornecedor[ id=" + id + " ]";
    }
    
}
