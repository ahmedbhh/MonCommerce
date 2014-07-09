/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.gestionFournisseur;

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
public class ProduitFactureFournisseurPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Facture_Fournisseur")
    private long iDFactureFournisseur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produit")
    private long idProduit;

    public ProduitFactureFournisseurPK() {
    }

    public ProduitFactureFournisseurPK(long iDFactureFournisseur, long idProduit) {
        this.iDFactureFournisseur = iDFactureFournisseur;
        this.idProduit = idProduit;
    }

    public long getIDFactureFournisseur() {
        return iDFactureFournisseur;
    }

    public void setIDFactureFournisseur(long iDFactureFournisseur) {
        this.iDFactureFournisseur = iDFactureFournisseur;
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
        hash += (int) iDFactureFournisseur;
        hash += (int) idProduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitFactureFournisseurPK)) {
            return false;
        }
        ProduitFactureFournisseurPK other = (ProduitFactureFournisseurPK) object;
        if (this.iDFactureFournisseur != other.iDFactureFournisseur) {
            return false;
        }
        if (this.idProduit != other.idProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.ProduitFactureFournisseurPK[ iDFactureFournisseur=" + iDFactureFournisseur + ", idProduit=" + idProduit + " ]";
    }
    
}