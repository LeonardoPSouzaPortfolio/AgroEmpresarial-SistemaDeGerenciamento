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
 * @author Leonardo
 */
@Entity
@Table(name = "entradaprodutoregistro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entradaprodutoregistro.findAll", query = "SELECT e FROM Entradaprodutoregistro e"),
    @NamedQuery(name = "Entradaprodutoregistro.findById", query = "SELECT e FROM Entradaprodutoregistro e WHERE e.id = :id"),
    @NamedQuery(name = "Entradaprodutoregistro.findByDataEntrada", query = "SELECT e FROM Entradaprodutoregistro e WHERE e.dataEntrada = :dataEntrada"),
    @NamedQuery(name = "Entradaprodutoregistro.findByVlrTotal", query = "SELECT e FROM Entradaprodutoregistro e WHERE e.vlrTotal = :vlrTotal")})
public class Entradaprodutoregistro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataEntrada")
    @Temporal(TemporalType.DATE)
    private Date dataEntrada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlrTotal")
    private Double vlrTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "entradaprodutoregistro")
    private Collection<Entradaprodutodetalhe> entradaprodutodetalheCollection;
    @JoinColumn(name = "idFornecedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Fornecedor idFornecedor;

    public Entradaprodutoregistro() {
    }

    public Entradaprodutoregistro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    @XmlTransient
    public Collection<Entradaprodutodetalhe> getEntradaprodutodetalheCollection() {
        return entradaprodutodetalheCollection;
    }

    public void setEntradaprodutodetalheCollection(Collection<Entradaprodutodetalhe> entradaprodutodetalheCollection) {
        this.entradaprodutodetalheCollection = entradaprodutodetalheCollection;
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
        if (!(object instanceof Entradaprodutoregistro)) {
            return false;
        }
        Entradaprodutoregistro other = (Entradaprodutoregistro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.Entradaprodutoregistro[ id=" + id + " ]";
    }
    
}
