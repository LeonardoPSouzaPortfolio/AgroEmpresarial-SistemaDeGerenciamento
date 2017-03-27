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
 * @author Leonardo P Souza
 */
@Entity
@Table(name = "pedidoregistro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidoregistro.findAll", query = "SELECT p FROM Pedidoregistro p"),
    @NamedQuery(name = "Pedidoregistro.findById", query = "SELECT p FROM Pedidoregistro p WHERE p.id = :id"),
    @NamedQuery(name = "Pedidoregistro.findByDataPedido", query = "SELECT p FROM Pedidoregistro p WHERE p.dataPedido = :dataPedido"),
    @NamedQuery(name = "Pedidoregistro.findByVlrPedido", query = "SELECT p FROM Pedidoregistro p WHERE p.vlrPedido = :vlrPedido")})
public class Pedidoregistro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataPedido")
    @Temporal(TemporalType.DATE)
    private Date dataPedido;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlrPedido")
    private Double vlrPedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoregistro")
    private Collection<Pedidodetalhe> pedidodetalheCollection;
    @JoinColumn(name = "idFornecedor", referencedColumnName = "id")
    @ManyToOne(optional = true)
    private Fornecedor idFornecedor;

    public Pedidoregistro() {
    }

    public Pedidoregistro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Double getVlrPedido() {
        return vlrPedido;
    }

    public void setVlrPedido(Double vlrPedido) {
        this.vlrPedido = vlrPedido;
    }

    @XmlTransient
    public Collection<Pedidodetalhe> getPedidodetalheCollection() {
        return pedidodetalheCollection;
    }

    public void setPedidodetalheCollection(Collection<Pedidodetalhe> pedidodetalheCollection) {
        this.pedidodetalheCollection = pedidodetalheCollection;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
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
        if (!(object instanceof Pedidoregistro)) {
            return false;
        }
        Pedidoregistro other = (Pedidoregistro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.Pedidoregistro[ id=" + id + " ]";
    }
    
}
