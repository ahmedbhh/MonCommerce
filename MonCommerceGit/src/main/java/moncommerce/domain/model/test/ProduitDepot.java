/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.test;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "produit_depot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduitDepot.findAll", query = "SELECT p FROM ProduitDepot p"),
    @NamedQuery(name = "ProduitDepot.findByIDdepot", query = "SELECT p FROM ProduitDepot p WHERE p.produitDepotPK.iDdepot = :iDdepot"),
    @NamedQuery(name = "ProduitDepot.findByIdProduit", query = "SELECT p FROM ProduitDepot p WHERE p.produitDepotPK.idProduit = :idProduit"),
    @NamedQuery(name = "ProduitDepot.findByQuantitee", query = "SELECT p FROM ProduitDepot p WHERE p.quantitee = :quantitee"),
    @NamedQuery(name = "ProduitDepot.findByDateHeure", query = "SELECT p FROM ProduitDepot p WHERE p.dateHeure = :dateHeure"),
    @NamedQuery(name = "ProduitDepot.findByEmplacement", query = "SELECT p FROM ProduitDepot p WHERE p.emplacement = :emplacement")})
public class ProduitDepot implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProduitDepotPK produitDepotPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantitee")
    private long quantitee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "emplacement")
    private String emplacement;
    @JoinColumn(name = "ID_depot", referencedColumnName = "ID_depot", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Depot depot;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;

    public ProduitDepot() {
    }

    public ProduitDepot(ProduitDepotPK produitDepotPK) {
        this.produitDepotPK = produitDepotPK;
    }

    public ProduitDepot(ProduitDepotPK produitDepotPK, long quantitee, Date dateHeure, String emplacement) {
        this.produitDepotPK = produitDepotPK;
        this.quantitee = quantitee;
        this.dateHeure = dateHeure;
        this.emplacement = emplacement;
    }

    public ProduitDepot(long iDdepot, long idProduit) {
        this.produitDepotPK = new ProduitDepotPK(iDdepot, idProduit);
    }

    public ProduitDepotPK getProduitDepotPK() {
        return produitDepotPK;
    }

    public void setProduitDepotPK(ProduitDepotPK produitDepotPK) {
        this.produitDepotPK = produitDepotPK;
    }

    public long getQuantitee() {
        return quantitee;
    }

    public void setQuantitee(long quantitee) {
        this.quantitee = quantitee;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produitDepotPK != null ? produitDepotPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitDepot)) {
            return false;
        }
        ProduitDepot other = (ProduitDepot) object;
        if ((this.produitDepotPK == null && other.produitDepotPK != null) || (this.produitDepotPK != null && !this.produitDepotPK.equals(other.produitDepotPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.ProduitDepot[ produitDepotPK=" + produitDepotPK + " ]";
    }
    
}
