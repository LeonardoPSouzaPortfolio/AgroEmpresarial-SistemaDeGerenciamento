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
public class EntradaprodutodetalhePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idEntradaRegistro")
    private int idEntradaRegistro;
    @Basic(optional = false)
    @Column(name = "idProduto")
    private int idProduto;

    public EntradaprodutodetalhePK() {
    }

    public EntradaprodutodetalhePK(int idEntradaRegistro, int idProduto) {
        this.idEntradaRegistro = idEntradaRegistro;
        this.idProduto = idProduto;
    }

    public int getIdEntradaRegistro() {
        return idEntradaRegistro;
    }

    public void setIdEntradaRegistro(int idEntradaRegistro) {
        this.idEntradaRegistro = idEntradaRegistro;
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
        hash += (int) idEntradaRegistro;
        hash += (int) idProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntradaprodutodetalhePK)) {
            return false;
        }
        EntradaprodutodetalhePK other = (EntradaprodutodetalhePK) object;
        if (this.idEntradaRegistro != other.idEntradaRegistro) {
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
