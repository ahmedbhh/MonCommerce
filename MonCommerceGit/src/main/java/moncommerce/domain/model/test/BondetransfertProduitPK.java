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
public class BondetransfertProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produit")
    private long idProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDBonDeTransfert")
    private long iDBonDeTransfert;

    public BondetransfertProduitPK() {
    }

    public BondetransfertProduitPK(long idProduit, long iDBonDeTransfert) {
        this.idProduit = idProduit;
        this.iDBonDeTransfert = iDBonDeTransfert;
    }

    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
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
        hash += (int) idProduit;
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
        if (this.idProduit != other.idProduit) {
            return false;
        }
        if (this.iDBonDeTransfert != other.iDBonDeTransfert) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.BondetransfertProduitPK[ idProduit=" + idProduit + ", iDBonDeTransfert=" + iDBonDeTransfert + " ]";
    }
    
}
