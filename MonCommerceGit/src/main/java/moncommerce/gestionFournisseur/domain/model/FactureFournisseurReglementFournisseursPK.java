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
public class FactureFournisseurReglementFournisseursPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDReglement_fournisseurs")
    private long iDReglementfournisseurs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFacture_Fournisseur")
    private long iDFactureFournisseur;

    public FactureFournisseurReglementFournisseursPK() {
    }

    public FactureFournisseurReglementFournisseursPK(long iDReglementfournisseurs, long iDFactureFournisseur) {
        this.iDReglementfournisseurs = iDReglementfournisseurs;
        this.iDFactureFournisseur = iDFactureFournisseur;
    }

    public long getIDReglementfournisseurs() {
        return iDReglementfournisseurs;
    }

    public void setIDReglementfournisseurs(long iDReglementfournisseurs) {
        this.iDReglementfournisseurs = iDReglementfournisseurs;
    }

    public long getIDFactureFournisseur() {
        return iDFactureFournisseur;
    }

    public void setIDFactureFournisseur(long iDFactureFournisseur) {
        this.iDFactureFournisseur = iDFactureFournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDReglementfournisseurs;
        hash += (int) iDFactureFournisseur;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactureFournisseurReglementFournisseursPK)) {
            return false;
        }
        FactureFournisseurReglementFournisseursPK other = (FactureFournisseurReglementFournisseursPK) object;
        if (this.iDReglementfournisseurs != other.iDReglementfournisseurs) {
            return false;
        }
        if (this.iDFactureFournisseur != other.iDFactureFournisseur) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.FactureFournisseurReglementFournisseursPK[ iDReglementfournisseurs=" + iDReglementfournisseurs + ", iDFactureFournisseur=" + iDFactureFournisseur + " ]";
    }
    
}
