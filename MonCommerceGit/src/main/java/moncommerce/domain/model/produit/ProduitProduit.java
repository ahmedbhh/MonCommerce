/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.produit;

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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "produit_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduitProduit.findAll", query = "SELECT p FROM ProduitProduit p"),
    @NamedQuery(name = "ProduitProduit.findByIDProduitComposant", query = "SELECT p FROM ProduitProduit p WHERE p.produitProduitPK.iDProduitComposant = :iDProduitComposant"),
    @NamedQuery(name = "ProduitProduit.findByIDProduitComposee", query = "SELECT p FROM ProduitProduit p WHERE p.produitProduitPK.iDProduitComposee = :iDProduitComposee"),
    @NamedQuery(name = "ProduitProduit.findByQuantitee", query = "SELECT p FROM ProduitProduit p WHERE p.quantitee = :quantitee"),
    @NamedQuery(name = "ProduitProduit.findByDateHeure", query = "SELECT p FROM ProduitProduit p WHERE p.dateHeure = :dateHeure")})
public class ProduitProduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProduitProduitPK produitProduitPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantitee")
    private long quantitee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @JoinColumn(name = "ID_Produit_Composant", referencedColumnName = "id_produit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;
    @JoinColumn(name = "ID_Produit_Composee", referencedColumnName = "id_produit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit1;

    public ProduitProduit() {
    }

    public ProduitProduit(ProduitProduitPK produitProduitPK) {
        this.produitProduitPK = produitProduitPK;
    }

    public ProduitProduit(ProduitProduitPK produitProduitPK, long quantitee, Date dateHeure) {
        this.produitProduitPK = produitProduitPK;
        this.quantitee = quantitee;
        this.dateHeure = dateHeure;
    }

    public ProduitProduit(long iDProduitComposant, long iDProduitComposee) {
        this.produitProduitPK = new ProduitProduitPK(iDProduitComposant, iDProduitComposee);
    }

    public ProduitProduitPK getProduitProduitPK() {
        return produitProduitPK;
    }

    public void setProduitProduitPK(ProduitProduitPK produitProduitPK) {
        this.produitProduitPK = produitProduitPK;
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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Produit getProduit1() {
        return produit1;
    }

    public void setProduit1(Produit produit1) {
        this.produit1 = produit1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produitProduitPK != null ? produitProduitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitProduit)) {
            return false;
        }
        ProduitProduit other = (ProduitProduit) object;
        if ((this.produitProduitPK == null && other.produitProduitPK != null) || (this.produitProduitPK != null && !this.produitProduitPK.equals(other.produitProduitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.ProduitProduit[ produitProduitPK=" + produitProduitPK + " ]";
    }
    
}
