/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.gestionFournisseur.domain.model;

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
public class BonentreeProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduit")
    private long iDProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBonEntree")
    private long iDBonEntree;

    public BonentreeProduitPK() {
    }

    public BonentreeProduitPK(long iDProduit, long iDBonEntree) {
        this.iDProduit = iDProduit;
        this.iDBonEntree = iDBonEntree;
    }

    public long getIDProduit() {
        return iDProduit;
    }

    public void setIDProduit(long iDProduit) {
        this.iDProduit = iDProduit;
    }

    public long getIDBonEntree() {
        return iDBonEntree;
    }

    public void setIDBonEntree(long iDBonEntree) {
        this.iDBonEntree = iDBonEntree;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDProduit;
        hash += (int) iDBonEntree;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BonentreeProduitPK)) {
            return false;
        }
        BonentreeProduitPK other = (BonentreeProduitPK) object;
        if (this.iDProduit != other.iDProduit) {
            return false;
        }
        if (this.iDBonEntree != other.iDBonEntree) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.BonentreeProduitPK[ iDProduit=" + iDProduit + ", iDBonEntree=" + iDBonEntree + " ]";
    }
    
}
