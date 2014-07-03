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
public class CommandeProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduit", nullable = false)
    private long iDProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCommande_fournisseur", nullable = false)
    private long iDCommandefournisseur;

    public CommandeProduitPK() {
    }

    public CommandeProduitPK(long iDProduit, long iDCommandefournisseur) {
        this.iDProduit = iDProduit;
        this.iDCommandefournisseur = iDCommandefournisseur;
    }

    public long getIDProduit() {
        return iDProduit;
    }

    public void setIDProduit(long iDProduit) {
        this.iDProduit = iDProduit;
    }

    public long getIDCommandefournisseur() {
        return iDCommandefournisseur;
    }

    public void setIDCommandefournisseur(long iDCommandefournisseur) {
        this.iDCommandefournisseur = iDCommandefournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDProduit;
        hash += (int) iDCommandefournisseur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandeProduitPK)) {
            return false;
        }
        CommandeProduitPK other = (CommandeProduitPK) object;
        if (this.iDProduit != other.iDProduit) {
            return false;
        }
        if (this.iDCommandefournisseur != other.iDCommandefournisseur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.CommandeProduitPK[ iDProduit=" + iDProduit + ", iDCommandefournisseur=" + iDCommandefournisseur + " ]";
    }
    
}
