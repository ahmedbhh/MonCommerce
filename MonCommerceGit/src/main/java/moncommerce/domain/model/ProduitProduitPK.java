/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author AHMED
 */
@Embeddable
public class ProduitProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduitComposant", nullable = false)
    private long iDProduitComposant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduitComposee", nullable = false)
    private long iDProduitComposee;

    public ProduitProduitPK() {
    }

    public ProduitProduitPK(long iDProduitComposant, long iDProduitComposee) {
        this.iDProduitComposant = iDProduitComposant;
        this.iDProduitComposee = iDProduitComposee;
    }

    public long getIDProduitComposant() {
        return iDProduitComposant;
    }

    public void setIDProduitComposant(long iDProduitComposant) {
        this.iDProduitComposant = iDProduitComposant;
    }

    public long getIDProduitComposee() {
        return iDProduitComposee;
    }

    public void setIDProduitComposee(long iDProduitComposee) {
        this.iDProduitComposee = iDProduitComposee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDProduitComposant;
        hash += (int) iDProduitComposee;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitProduitPK)) {
            return false;
        }
        ProduitProduitPK other = (ProduitProduitPK) object;
        if (this.iDProduitComposant != other.iDProduitComposant) {
            return false;
        }
        if (this.iDProduitComposee != other.iDProduitComposee) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.ProduitProduitPK[ iDProduitComposant=" + iDProduitComposant + ", iDProduitComposee=" + iDProduitComposee + " ]";
    }
    
}
