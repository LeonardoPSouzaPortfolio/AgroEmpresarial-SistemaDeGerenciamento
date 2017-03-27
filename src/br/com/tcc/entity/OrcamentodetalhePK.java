/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Leonardo
 */
@Embeddable
public class OrcamentodetalhePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idOrcamentoRegistro")
    private int idOrcamentoRegistro;
    @Basic(optional = false)
    @Column(name = "idProduto")
    private int idProduto;

    public OrcamentodetalhePK() {
    }

    public OrcamentodetalhePK(int idOrcamentoRegistro, int idProduto) {
        this.idOrcamentoRegistro = idOrcamentoRegistro;
        this.idProduto = idProduto;
    }

    public int getIdOrcamentoRegistro() {
        return idOrcamentoRegistro;
    }

    public void setIdOrcamentoRegistro(int idOrcamentoRegistro) {
        this.idOrcamentoRegistro = idOrcamentoRegistro;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idOrcamentoRegistro;
        hash += (int) idProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrcamentodetalhePK)) {
            return false;
        }
        OrcamentodetalhePK other = (OrcamentodetalhePK) object;
        if (this.idOrcamentoRegistro != other.idOrcamentoRegistro) {
            return false;
        }
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.OrcamentodetalhePK[ idOrcamentoRegistro=" + idOrcamentoRegistro + ", idProduto=" + idProduto + " ]";
    }
    
}
