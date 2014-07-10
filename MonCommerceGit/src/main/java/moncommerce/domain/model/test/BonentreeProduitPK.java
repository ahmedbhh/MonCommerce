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
public class BonentreeProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produit")
    private long idProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Bon_Entree")
    private long iDBonEntree;

    public BonentreeProduitPK() {
    }

    public BonentreeProduitPK(long idProduit, long iDBonEntree) {
        this.idProduit = idProduit;
        this.iDBonEntree = iDBonEntree;
    }

    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
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
        hash += (int) idProduit;
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
        if (this.idProduit != other.idProduit) {
            return false;
        }
        if (this.iDBonEntree != other.iDBonEntree) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.BonentreeProduitPK[ idProduit=" + idProduit + ", iDBonEntree=" + iDBonEntree + " ]";
    }
    
}
