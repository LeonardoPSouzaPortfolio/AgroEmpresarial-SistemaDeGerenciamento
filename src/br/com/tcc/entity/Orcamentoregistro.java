/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.entity;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Leonardo
 */
@Entity
@Table(name = "orcamentoregistro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orcamentoregistro.findAll", query = "SELECT o FROM Orcamentoregistro o"),
    @NamedQuery(name = "Orcamentoregistro.findById", query = "SELECT o FROM Orcamentoregistro o WHERE o.id = :id"),
    @NamedQuery(name = "Orcamentoregistro.findByDataOrcamento", query = "SELECT o FROM Orcamentoregistro o WHERE o.dataOrcamento = :dataOrcamento"),
    @NamedQuery(name = "Orcamentoregistro.findByVlrTotalOrcamento", query = "SELECT o FROM Orcamentoregistro o WHERE o.vlrTotalOrcamento = :vlrTotalOrcamento")})
public class Orcamentoregistro implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataOrcamento")
    @Temporal(TemporalType.DATE)
    private Date dataOrcamento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlrTotalOrcamento")
    private Double vlrTotalOrcamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orcamentoregistro")
    private Collection<Orcamentodetalhe> orcamentodetalheCollection;
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "id")
    @ManyToOne
    private Funcionario idFuncionario;

    public Orcamentoregistro() {
    }

    public Orcamentoregistro(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public Date getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(Date dataOrcamento) {
        Date oldDataOrcamento = this.dataOrcamento;
        this.dataOrcamento = dataOrcamento;
        changeSupport.firePropertyChange("dataOrcamento", oldDataOrcamento, dataOrcamento);
    }

    public Double getVlrTotalOrcamento() {
        return vlrTotalOrcamento;
    }

    public void setVlrTotalOrcamento(Double vlrTotalOrcamento) {
        Double oldVlrTotalOrcamento = this.vlrTotalOrcamento;
        this.vlrTotalOrcamento = vlrTotalOrcamento;
        changeSupport.firePropertyChange("vlrTotalOrcamento", oldVlrTotalOrcamento, vlrTotalOrcamento);
    }

    @XmlTransient
    public Collection<Orcamentodetalhe> getOrcamentodetalheCollection() {
        return orcamentodetalheCollection;
    }

    public void setOrcamentodetalheCollection(Collection<Orcamentodetalhe> orcamentodetalheCollection) {
        this.orcamentodetalheCollection = orcamentodetalheCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        Cliente oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        Funcionario oldIdFuncionario = this.idFuncionario;
        this.idFuncionario = idFuncionario;
        changeSupport.firePropertyChange("idFuncionario", oldIdFuncionario, idFuncionario);
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
        if (!(object instanceof Orcamentoregistro)) {
            return false;
        }
        Orcamentoregistro other = (Orcamentoregistro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.Orcamentoregistro[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
