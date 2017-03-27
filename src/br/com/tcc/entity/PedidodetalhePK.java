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
 * @author Leonardo P Souza
 */
@Embeddable
public class PedidodetalhePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "idPedidoRegistro")
    private int idPedidoRegistro;
    @Basic(optional = false)
    @Column(name = "idProduto")
    private int idProduto;

    public PedidodetalhePK() {
    }

    public PedidodetalhePK(int idPedidoRegistro, int idProduto) {
        this.idPedidoRegistro = idPedidoRegistro;
        this.idProduto = idProduto;
    }

    public int getIdPedidoRegistro() {
        return idPedidoRegistro;
    }

    public void setIdPedidoRegistro(int idPedidoRegistro) {
        this.idPedidoRegistro = idPedidoRegistro;
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
        hash += (int) idPedidoRegistro;
        hash += (int) idProduto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PedidodetalhePK)) {
            return false;
        }
        PedidodetalhePK other = (PedidodetalhePK) object;
        if (this.idPedidoRegistro != other.idPedidoRegistro) {
            return false;
        }
        if (this.idProduto != other.idProduto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.tcc.entity.PedidodetalhePK[ idPedidoRegistro=" + idPedidoRegistro + ", idProduto=" + idProduto + " ]";
    }
    
}
