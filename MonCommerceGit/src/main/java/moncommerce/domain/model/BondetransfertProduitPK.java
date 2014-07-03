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
public class BondetransfertProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduit", nullable = false)
    private long iDProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBonDeTransfert", nullable = false)
    private long iDBonDeTransfert;

    public BondetransfertProduitPK() {
    }

    public BondetransfertProduitPK(long iDProduit, long iDBonDeTransfert) {
        this.iDProduit = iDProduit;
        this.iDBonDeTransfert = iDBonDeTransfert;
    }

    public long getIDProduit() {
        return iDProduit;
    }

    public void setIDProduit(long iDProduit) {
        this.iDProduit = iDProduit;
    }

    public long getIDBonDeTransfert() {
        return iDBonDeTransfert;
    }

    public void setIDBonDeTransfert(long iDBonDeTransfert) {
        this.iDBonDeTransfert = iDBonDeTransfert;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDProduit;
        hash += (int) iDBonDeTransfert;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BondetransfertProduitPK)) {
            return false;
        }
        BondetransfertProduitPK other = (BondetransfertProduitPK) object;
        if (this.iDProduit != other.iDProduit) {
            return false;
        }
        if (this.iDBonDeTransfert != other.iDBonDeTransfert) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.BondetransfertProduitPK[ iDProduit=" + iDProduit + ", iDBonDeTransfert=" + iDBonDeTransfert + " ]";
    }
    
}
