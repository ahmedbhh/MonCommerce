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
public class ProduitCodeTarifPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCode_tarif", nullable = false)
    private long iDCodetarif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduit", nullable = false)
    private long iDProduit;

    public ProduitCodeTarifPK() {
    }

    public ProduitCodeTarifPK(long iDCodetarif, long iDProduit) {
        this.iDCodetarif = iDCodetarif;
        this.iDProduit = iDProduit;
    }

    public long getIDCodetarif() {
        return iDCodetarif;
    }

    public void setIDCodetarif(long iDCodetarif) {
        this.iDCodetarif = iDCodetarif;
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
        hash += (int) iDCodetarif;
        hash += (int) iDProduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitCodeTarifPK)) {
            return false;
        }
        ProduitCodeTarifPK other = (ProduitCodeTarifPK) object;
        if (this.iDCodetarif != other.iDCodetarif) {
            return false;
        }
        if (this.iDProduit != other.iDProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.ProduitCodeTarifPK[ iDCodetarif=" + iDCodetarif + ", iDProduit=" + iDProduit + " ]";
    }
    
}
