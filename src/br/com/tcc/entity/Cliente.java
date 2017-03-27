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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :id"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf"),
    @NamedQuery(name = "Cliente.findByRg", query = "SELECT c FROM Cliente c WHERE c.rg = :rg"),
    @NamedQuery(name = "Cliente.findByEndereco", query = "SELECT c FROM Cliente c WHERE c.endereco = :endereco"),
    @NamedQuery(name = "Cliente.findByDataNascimento", query = "SELECT c FROM Cliente c WHERE c.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Cliente.findByClienteDesde", query = "SELECT c FROM Cliente c WHERE c.clienteDesde = :clienteDesde"),
    @NamedQuery(name = "Cliente.findByFone", query = "SELECT c FROM Cliente c WHERE c.fone = :fone"),
    @NamedQuery(name = "Cliente.findByCelular", query = "SELECT c FROM Cliente c WHERE c.celular = :celular"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")})
public class Cliente implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "rg")
    private String rg;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "dataNascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(name = "clienteDesde")
    @Temporal(TemporalType.DATE)
    private Date clienteDesde;
    @Column(name = "fone")
    private String fone;
    @Column(name = "celular")
    private String celular;
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Pagamentocliente> pagamentoclienteCollection;
    @OneToMany(mappedBy = "idCliente")
    private Collection<Orcamentoregistro> orcamentoregistroCollection;
    @JoinColumn(name = "idBairro", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bairro idBairro;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Vendaregistro> vendaregistroCollection;
    /**
     * Construtor padrão da classe <b>Cliente</b>
     */
    public Cliente() {
    }
    /**
     * Construtor sobrecarregado da classe <b>Unidade</b>
     * @param id inteiro que recebe a id da <b>Unidade</b>
     */
    public Cliente(Integer id) {
        this.id = id;
    }
     /**
     * Método get do <b>id</b>
     * @return retorna um <b>id</b> inteiro
     */
    public Integer getId() {
        return id;
    }
     /**
     * Método set <b>id</b>
     * @param id atribui uma instancia da classe 
     */
    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }
     /**
     * Método get do <b>nome</b>
     * @return retorna um <b>nome</b> String
     */
    public String getNome() {
        return nome;
    }
     /**
     * Método set <b>nome</b>
     * @param nome  uma instancia da classe 
     */
    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }
     /**
     * Método get do <b>cpf</b>
     * @return retorna um <b>cpf</b> String
     */
    public String getCpf() {
        return cpf;
    }
     /**
     * Método set <b>cpf</b>
     * @param cpf  atribui uma instancia da classe 
     */
    public void setCpf(String cpf) {
        String oldCpf = this.cpf;
        this.cpf = cpf;
        changeSupport.firePropertyChange("cpf", oldCpf, cpf);
    }
     /**
     * Método get do <b>rg</b>
     * @return retorna um <b>rg</b> String
     */
    public String getRg() {
        return rg;
    }
     /**
     * Método set <b>rg</b>
     * @param rg  atribui uma instancia da classe 
     */
    public void setRg(String rg) {
        String oldRg = this.rg;
        this.rg = rg;
        changeSupport.firePropertyChange("rg", oldRg, rg);
    }
     /**
     * Método get do <b>endereco</b>
     * @return retorna um <b>endereco</b> String
     */
    public String getEndereco() {
        return endereco;
    }
     /**
     * Método set <b>endereco</b>
     * @param endereco  atribui uma instancia da classe 
     */
    public void setEndereco(String endereco) {
        String oldEndereco = this.endereco;
        this.endereco = endereco;
        changeSupport.firePropertyChange("endereco", oldEndereco, endereco);
    }
     /**
     * Método get do <b>dataNascimento</b>
     * @return retorna um <b>dataNascimento</b> Date
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }
     /**
     * Método set <b>dataNascimento</b>
     * @param dataNascimento  atribui uma instancia da classe 
     */
    public void setDataNascimento(Date dataNascimento) {
        Date oldDataNascimento = this.dataNascimento;
        this.dataNascimento = dataNascimento;
        changeSupport.firePropertyChange("dataNascimento", oldDataNascimento, dataNascimento);
    }
     /**
     * Método get do <b>clienteDesde</b>
     * @return retorna um <b>descricao</b> Date
     */
    public Date getClienteDesde() {
        return clienteDesde;
    }
     /**
     * Método set <b>clienteDesde</b>
     * @param clienteDesde  atribui uma instancia da classe 
     */
    public void setClienteDesde(Date clienteDesde) {
        Date oldClienteDesde = this.clienteDesde;
        this.clienteDesde = clienteDesde;
        changeSupport.firePropertyChange("clienteDesde", oldClienteDesde, clienteDesde);
    }
     /**
     * Método get do <b>fone</b>
     * @return retorna um <b>fone</b> String
     */
    public String getFone() {
        return fone;
    }
     /**
     * Método set <b>fone</b>
     * @param fone  atribui uma instancia da classe 
     */
    public void setFone(String fone) {
        String oldFone = this.fone;
        this.fone = fone;
        changeSupport.firePropertyChange("fone", oldFone, fone);
    }
     /**
     * Método get do <b>celular</b>
     * @return retorna um <b>celular</b> String
     */
    public String getCelular() {
        return celular;
    }
     /**
     * Método set <b>celular</b>
     * @param celular  atribui uma instancia da classe 
     */
    public void setCelular(String celular) {
        String oldCelular = this.celular;
        this.celular = celular;
        changeSupport.firePropertyChange("celular", oldCelular, celular);
    }
     /**
     * Método get do <b>email</b>
     * @return retorna um <b>email</b> String
     */
    public String getEmail() {
        return email;
    }
     /**
     * Método set <b>email</b>
     * @param email  atribui uma instancia da classe 
     */
    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    @XmlTransient
    public Collection<Pagamentocliente> getPagamentoclienteCollection() {
        return pagamentoclienteCollection;
    }

    public void setPagamentoclienteCollection(Collection<Pagamentocliente> pagamentoclienteCollection) {
        this.pagamentoclienteCollection = pagamentoclienteCollection;
    }

    @XmlTransient
    public Collection<Orcamentoregistro> getOrcamentoregistroCollection() {
        return orcamentoregistroCollection;
    }

    public void setOrcamentoregistroCollection(Collection<Orcamentoregistro> orcamentoregistroCollection) {
        this.orcamentoregistroCollection = orcamentoregistroCollection;
    }

    public Bairro getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Bairro idBairro) {
        Bairro oldIdBairro = this.idBairro;
        this.idBairro = idBairro;
        changeSupport.firePropertyChange("idBairro", oldIdBairro, idBairro);
    }

    @XmlTransient
    public Collection<Vendaregistro> getVendaregistroCollection() {
        return vendaregistroCollection;
    }

    public void setVendaregistroCollection(Collection<Vendaregistro> vendaregistroCollection) {
        this.vendaregistroCollection = vendaregistroCollection;
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
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
