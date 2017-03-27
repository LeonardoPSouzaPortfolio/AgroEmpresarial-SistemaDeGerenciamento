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
@Table(name = "pagamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagamento.findAll", query = "SELECT p FROM Pagamento p"),
    @NamedQuery(name = "Pagamento.findByIdPagamento", query = "SELECT p FROM Pagamento p WHERE p.idPagamento = :idPagamento"),
    @NamedQuery(name = "Pagamento.findByIdvenda", query = "SELECT p FROM Pagamento p WHERE p.idvenda = :idvenda"),
    @NamedQuery(name = "Pagamento.findByDataPagamento", query = "SELECT p FROM Pagamento p WHERE p.dataPagamento = :dataPagamento"),
    @NamedQuery(name = "Pagamento.findByVencimento", query = "SELECT p FROM Pagamento p WHERE p.vencimento = :vencimento"),
    @NamedQuery(name = "Pagamento.findByJuros", query = "SELECT p FROM Pagamento p WHERE p.juros = :juros"),
    @NamedQuery(name = "Pagamento.findByDesconto", query = "SELECT p FROM Pagamento p WHERE p.desconto = :desconto"),
    @NamedQuery(name = "Pagamento.findByRecebeu", query = "SELECT p FROM Pagamento p WHERE p.recebeu = :recebeu"),
    @NamedQuery(name = "Pagamento.findByRestante", query = "SELECT p FROM Pagamento p WHERE p.restante = :restante"),
    @NamedQuery(name = "Pagamento.findByValorFinal", query = "SELECT p FROM Pagamento p WHERE p.valorFinal = :valorFinal")})
public class Pagamento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPagamento")
    private Integer idPagamento;
    @Column(name = "idvenda")
    private Integer idvenda;
    @Column(name = "dataPagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;
    @Column(name = "vencimento")
    @Temporal(TemporalType.DATE)
    private Date vencimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "juros")
    private Double juros;
    @Column(name = "desconto")
    private Double desconto;
    @Column(name = "recebeu")
    private Double recebeu;
    @Column(name = "restante")
    private Double restante;
    @Column(name = "valorFinal")
    private Double valorFinal;

    public Pagamento() {
    }

    public Pagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Integer getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(Integer idvenda) {
        this.idvenda = idvenda;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Double getJuros() {
        return juros;
    }

    public void setJuros(Double juros) {
        this.juros = juros;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getRecebeu() {
        return recebeu;
    }

    public void setRecebeu(Double recebeu) {
        this.recebeu = recebeu;
    }

    public Double getRestante() {
        return restante;
    }

    public void setRestante(Double restante) {
        this.restante = restante;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagamento != null ? idPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagamento)) {
            return false;
        }
        Pagamento other = (Pagamento) object;
        if ((this.idPagamento == null && other.idPagamento != null) || (this.idPagamento != null && !this.idPagamento.equals(other.idPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.Pagamento[ idPagamento=" + idPagamento + " ]";
    }
    
}
