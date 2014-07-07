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
public class ProduitFactureFournisseurPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFacture_Fournisseur")
    private long iDFactureFournisseur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduit")
    private long iDProduit;

    public ProduitFactureFournisseurPK() {
    }

    public ProduitFactureFournisseurPK(long iDFactureFournisseur, long iDProduit) {
        this.iDFactureFournisseur = iDFactureFournisseur;
        this.iDProduit = iDProduit;
    }

    public long getIDFactureFournisseur() {
        return iDFactureFournisseur;
    }

    public void setIDFactureFournisseur(long iDFactureFournisseur) {
        this.iDFactureFournisseur = iDFactureFournisseur;
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
        hash += (int) iDFactureFournisseur;
        hash += (int) iDProduit;
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
        if (this.iDProduit != other.iDProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.ProduitFactureFournisseurPK[ iDFactureFournisseur=" + iDFactureFournisseur + ", iDProduit=" + iDProduit + " ]";
    }
    
}
