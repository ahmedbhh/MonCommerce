/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.test;

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
    @Column(name = "ID_depot")
    private long iDdepot;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produit")
    private long idProduit;

    public ProduitDepotPK() {
    }

    public ProduitDepotPK(long iDdepot, long idProduit) {
        this.iDdepot = iDdepot;
        this.idProduit = idProduit;
    }

    public long getIDdepot() {
        return iDdepot;
    }

    public void setIDdepot(long iDdepot) {
        this.iDdepot = iDdepot;
    }

    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDdepot;
        hash += (int) idProduit;
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
        if (this.idProduit != other.idProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.ProduitDepotPK[ iDdepot=" + iDdepot + ", idProduit=" + idProduit + " ]";
    }
    
}
