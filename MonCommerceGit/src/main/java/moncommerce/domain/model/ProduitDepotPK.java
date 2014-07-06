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
public class ProduitDepotPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDdepot")
    private long iDdepot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduit")
    private long iDProduit;

    public ProduitDepotPK() {
    }

    public ProduitDepotPK(long iDdepot, long iDProduit) {
        this.iDdepot = iDdepot;
        this.iDProduit = iDProduit;
    }

    public long getIDdepot() {
        return iDdepot;
    }

    public void setIDdepot(long iDdepot) {
        this.iDdepot = iDdepot;
    }

    public long getIDProduit() {
        return iDProduit;
    }

    public void setIDProduit(long iDProduit) {
        this.iDProduit = iDProduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDdepot;
        hash += (int) iDProduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitDepotPK)) {
            return false;
        }
        ProduitDepotPK other = (ProduitDepotPK) object;
        if (this.iDdepot != other.iDdepot) {
            return false;
        }
        if (this.iDProduit != other.iDProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.ProduitDepotPK[ iDdepot=" + iDdepot + ", iDProduit=" + iDProduit + " ]";
    }
    
}
