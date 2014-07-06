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
public class BondesortieProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduit")
    private long iDProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBondeSortie")
    private long iDBondeSortie;

    public BondesortieProduitPK() {
    }

    public BondesortieProduitPK(long iDProduit, long iDBondeSortie) {
        this.iDProduit = iDProduit;
        this.iDBondeSortie = iDBondeSortie;
    }

    public long getIDProduit() {
        return iDProduit;
    }

    public void setIDProduit(long iDProduit) {
        this.iDProduit = iDProduit;
    }

    public long getIDBondeSortie() {
        return iDBondeSortie;
    }

    public void setIDBondeSortie(long iDBondeSortie) {
        this.iDBondeSortie = iDBondeSortie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDProduit;
        hash += (int) iDBondeSortie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BondesortieProduitPK)) {
            return false;
        }
        BondesortieProduitPK other = (BondesortieProduitPK) object;
        if (this.iDProduit != other.iDProduit) {
            return false;
        }
        if (this.iDBondeSortie != other.iDBondeSortie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.BondesortieProduitPK[ iDProduit=" + iDProduit + ", iDBondeSortie=" + iDBondeSortie + " ]";
    }
    
}
