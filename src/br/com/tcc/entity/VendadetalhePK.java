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
public class VendadetalhePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idVendaRegistro")
    private int idVendaRegistro;
    @Basic(optional = false)
    @Column(name = "idProduto")
    private int idProduto;

    public VendadetalhePK() {
    }

    public VendadetalhePK(int idVendaRegistro, int idProduto) {
        this.idVendaRegistro = idVendaRegistro;
        this.idProduto = idProduto;
    }

    public int getIdVendaRegistro() {
        return idVendaRegistro;
    }

    public void setIdVendaRegistro(int idVendaRegistro) {
        this.idVendaRegistro = idVendaRegistro;
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
        hash += (int) idVendaRegistro;
        hash += (int) idProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VendadetalhePK)) {
            return false;
        }
        VendadetalhePK other = (VendadetalhePK) object;
        if (this.idVendaRegistro != other.idVendaRegistro) {
            return false;
        }
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idProduto+"";
    }
    
}
