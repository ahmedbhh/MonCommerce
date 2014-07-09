/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.produit;

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
    @Column(name = "ID_Code_tarif")
    private long iDCodetarif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produit")
    private long idProduit;

    public ProduitCodeTarifPK() {
    }

    public ProduitCodeTarifPK(long iDCodetarif, long idProduit) {
        this.iDCodetarif = iDCodetarif;
        this.idProduit = idProduit;
    }

    public long getIDCodetarif() {
        return iDCodetarif;
    }

    public void setIDCodetarif(long iDCodetarif) {
        this.iDCodetarif = iDCodetarif;
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
        hash += (int) iDCodetarif;
        hash += (int) idProduit;
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
        if (this.idProduit != other.idProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.ProduitCodeTarifPK[ iDCodetarif=" + iDCodetarif + ", idProduit=" + idProduit + " ]";
    }
    
}
