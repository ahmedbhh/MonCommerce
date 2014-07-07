/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.gestionFournisseur.domain.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "facture_fournisseur_reglement_fournisseurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactureFournisseurReglementFournisseurs.findAll", query = "SELECT f FROM FactureFournisseurReglementFournisseurs f"),
    @NamedQuery(name = "FactureFournisseurReglementFournisseurs.findByIDReglementfournisseurs", query = "SELECT f FROM FactureFournisseurReglementFournisseurs f WHERE f.factureFournisseurReglementFournisseursPK.iDReglementfournisseurs = :iDReglementfournisseurs"),
    @NamedQuery(name = "FactureFournisseurReglementFournisseurs.findByIDFactureFournisseur", query = "SELECT f FROM FactureFournisseurReglementFournisseurs f WHERE f.factureFournisseurReglementFournisseursPK.iDFactureFournisseur = :iDFactureFournisseur"),
    @NamedQuery(name = "FactureFournisseurReglementFournisseurs.findByType", query = "SELECT f FROM FactureFournisseurReglementFournisseurs f WHERE f.type = :type"),
    @NamedQuery(name = "FactureFournisseurReglementFournisseurs.findBySoldee", query = "SELECT f FROM FactureFournisseurReglementFournisseurs f WHERE f.soldee = :soldee")})
public class FactureFournisseurReglementFournisseurs implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FactureFournisseurReglementFournisseursPK factureFournisseurReglementFournisseursPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "soldee")
    private short soldee;
    @JoinColumn(name = "IDFacture_Fournisseur", referencedColumnName = "IDFacture_Fournisseur", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private FactureFournisseur factureFournisseur;
    @JoinColumn(name = "IDReglement_fournisseurs", referencedColumnName = "IDReglement_fournisseurs", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReglementFournisseurs reglementFournisseurs;

    public FactureFournisseurReglementFournisseurs() {
    }

    public FactureFournisseurReglementFournisseurs(FactureFournisseurReglementFournisseursPK factureFournisseurReglementFournisseursPK) {
        this.factureFournisseurReglementFournisseursPK = factureFournisseurReglementFournisseursPK;
    }

    public FactureFournisseurReglementFournisseurs(FactureFournisseurReglementFournisseursPK factureFournisseurReglementFournisseursPK, String type, short soldee) {
        this.factureFournisseurReglementFournisseursPK = factureFournisseurReglementFournisseursPK;
        this.type = type;
        this.soldee = soldee;
    }

    public FactureFournisseurReglementFournisseurs(long iDReglementfournisseurs, long iDFactureFournisseur) {
        this.factureFournisseurReglementFournisseursPK = new FactureFournisseurReglementFournisseursPK(iDReglementfournisseurs, iDFactureFournisseur);
    }

    public FactureFournisseurReglementFournisseursPK getFactureFournisseurReglementFournisseursPK() {
        return factureFournisseurReglementFournisseursPK;
    }

    public void setFactureFournisseurReglementFournisseursPK(FactureFournisseurReglementFournisseursPK factureFournisseurReglementFournisseursPK) {
        this.factureFournisseurReglementFournisseursPK = factureFournisseurReglementFournisseursPK;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public short getSoldee() {
        return soldee;
    }

    public void setSoldee(short soldee) {
        this.soldee = soldee;
    }

    public FactureFournisseur getFactureFournisseur() {
        return factureFournisseur;
    }

    public void setFactureFournisseur(FactureFournisseur factureFournisseur) {
        this.factureFournisseur = factureFournisseur;
    }

    public ReglementFournisseurs getReglementFournisseurs() {
        return reglementFournisseurs;
    }

    public void setReglementFournisseurs(ReglementFournisseurs reglementFournisseurs) {
        this.reglementFournisseurs = reglementFournisseurs;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (factureFournisseurReglementFournisseursPK != null ? factureFournisseurReglementFournisseursPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactureFournisseurReglementFournisseurs)) {
            return false;
        }
        FactureFournisseurReglementFournisseurs other = (FactureFournisseurReglementFournisseurs) object;
        if ((this.factureFournisseurReglementFournisseursPK == null && other.factureFournisseurReglementFournisseursPK != null) || (this.factureFournisseurReglementFournisseursPK != null && !this.factureFournisseurReglementFournisseursPK.equals(other.factureFournisseurReglementFournisseursPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.FactureFournisseurReglementFournisseurs[ factureFournisseurReglementFournisseursPK=" + factureFournisseurReglementFournisseursPK + " ]";
    }
    
}
