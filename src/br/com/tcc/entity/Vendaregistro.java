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
 * @author Leonardo P Souza
 */
@Entity
@Table(name = "vendaregistro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vendaregistro.findAll", query = "SELECT v FROM Vendaregistro v"),
    @NamedQuery(name = "Vendaregistro.findById", query = "SELECT v FROM Vendaregistro v WHERE v.id = :id"),
    @NamedQuery(name = "Vendaregistro.findByDataVenda", query = "SELECT v FROM Vendaregistro v WHERE v.dataVenda = :dataVenda"),
    @NamedQuery(name = "Vendaregistro.findByVlrSugerido", query = "SELECT v FROM Vendaregistro v WHERE v.vlrSugerido = :vlrSugerido"),
    @NamedQuery(name = "Vendaregistro.findByDesconto", query = "SELECT v FROM Vendaregistro v WHERE v.desconto = :desconto"),
    @NamedQuery(name = "Vendaregistro.findByTotalVenda", query = "SELECT v FROM Vendaregistro v WHERE v.totalVenda = :totalVenda"),
    @NamedQuery(name = "Vendaregistro.findByParcela", query = "SELECT v FROM Vendaregistro v WHERE v.parcela = :parcela"),
    @NamedQuery(name = "Vendaregistro.findByVencimento", query = "SELECT v FROM Vendaregistro v WHERE v.vencimento = :vencimento"),
    @NamedQuery(name = "Vendaregistro.findByAtivo", query = "SELECT v FROM Vendaregistro v WHERE v.ativo = :ativo"),
    @NamedQuery(name = "Vendaregistro.findByRecebeu", query = "SELECT v FROM Vendaregistro v WHERE v.recebeu = :recebeu"),
    @NamedQuery(name = "Vendaregistro.findByJuro", query = "SELECT v FROM Vendaregistro v WHERE v.juro = :juro"),
    @NamedQuery(name = "Vendaregistro.findByRestante", query = "SELECT v FROM Vendaregistro v WHERE v.restante = :restante"),
    @NamedQuery(name = "Vendaregistro.findByValorfinal", query = "SELECT v FROM Vendaregistro v WHERE v.valorfinal = :valorfinal")})
public class Vendaregistro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "dataVenda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "vlrSugerido")
    private Double vlrSugerido;
    @Column(name = "desconto")
    private Double desconto;
    @Column(name = "totalVenda")
    private Double totalVenda;
    @Column(name = "parcela")
    private String parcela;
    @Column(name = "1vencimento")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    @Column(name = "ativo")
    private String ativo;
    @Basic(optional = false)
    @Column(name = "recebeu")
    private double recebeu;
    @Basic(optional = false)
    @Column(name = "juro")
    private double juro;
    @Basic(optional = false)
    @Column(name = "restante")
    private double restante;
    @Basic(optional = false)
    @Column(name = "valorfinal")
    private double valorfinal;
    @JoinColumn(name = "idCliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Cliente idCliente;
    @JoinColumn(name = "idFuncionario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Funcionario idFuncionario;
    @JoinColumn(name = "idTipoPagamento", referencedColumnName = "id")
    @ManyToOne
    private Tipopagamento idTipoPagamento;

    public Vendaregistro() {
    }

    public Vendaregistro(Integer id) {
        this.id = id;
    }

    public Vendaregistro(Integer id, double recebeu, double juro, double restante, double valorfinal) {
        this.id = id;
        this.recebeu = recebeu;
        this.juro = juro;
        this.restante = restante;
        this.valorfinal = valorfinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getVlrSugerido() {
        return vlrSugerido;
    }

    public void setVlrSugerido(Double vlrSugerido) {
        this.vlrSugerido = vlrSugerido;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getTotalVenda() {
        return totalVenda;
    }

    public void setTotalVenda(Double totalVenda) {
        this.totalVenda = totalVenda;
    }

    public String getParcela() {
        return parcela;
    }

    public void setParcela(String parcela) {
        this.parcela = parcela;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public double getRecebeu() {
        return recebeu;
    }

    public void setRecebeu(double recebeu) {
        this.recebeu = recebeu;
    }

    public double getJuro() {
        return juro;
    }

    public void setJuro(double juro) {
        this.juro = juro;
    }

    public double getRestante() {
        return restante;
    }

    public void setRestante(double restante) {
        this.restante = restante;
    }

    public double getValorfinal() {
        return valorfinal;
    }

    public void setValorfinal(double valorfinal) {
        this.valorfinal = valorfinal;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public Funcionario getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
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
        if (!(object instanceof Vendaregistro)) {
            return false;
        }
        Vendaregistro other = (Vendaregistro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.Vendaregistro[ id=" + id + " ]";
    }
    
}
