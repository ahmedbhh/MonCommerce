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
public class CommandeProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produit")
    private long idProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Commande_fournisseur")
    private long iDCommandefournisseur;

    public CommandeProduitPK() {
    }

    public CommandeProduitPK(long idProduit, long iDCommandefournisseur) {
        this.idProduit = idProduit;
        this.iDCommandefournisseur = iDCommandefournisseur;
    }

    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
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
        hash += (int) idProduit;
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
        if (this.idProduit != other.idProduit) {
            return false;
        }
        if (this.iDCommandefournisseur != other.iDCommandefournisseur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.CommandeProduitPK[ idProduit=" + idProduit + ", iDCommandefournisseur=" + iDCommandefournisseur + " ]";
    }
    
}
