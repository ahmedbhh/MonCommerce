/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

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
import moncommerce.domain.model.produit.Produit;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "bondetransfert_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BondetransfertProduit.findAll", query = "SELECT b FROM BondetransfertProduit b"),
    @NamedQuery(name = "BondetransfertProduit.findByIdProduit", query = "SELECT b FROM BondetransfertProduit b WHERE b.bondetransfertProduitPK.idProduit = :idProduit"),
    @NamedQuery(name = "BondetransfertProduit.findByIDBonDeTransfert", query = "SELECT b FROM BondetransfertProduit b WHERE b.bondetransfertProduitPK.iDBonDeTransfert = :iDBonDeTransfert"),
    @NamedQuery(name = "BondetransfertProduit.findByQuantitee", query = "SELECT b FROM BondetransfertProduit b WHERE b.quantitee = :quantitee"),
    @NamedQuery(name = "BondetransfertProduit.findByDateHeure", query = "SELECT b FROM BondetransfertProduit b WHERE b.dateHeure = :dateHeure")})
public class BondetransfertProduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BondetransfertProduitPK bondetransfertProduitPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantitee")
    private long quantitee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @JoinColumn(name = "IDBonDeTransfert", referencedColumnName = "IDBonDeTransfert", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bondetransfert bondetransfert;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;

    public BondetransfertProduit() {
    }

    public BondetransfertProduit(BondetransfertProduitPK bondetransfertProduitPK) {
        this.bondetransfertProduitPK = bondetransfertProduitPK;
    }

    public BondetransfertProduit(BondetransfertProduitPK bondetransfertProduitPK, long quantitee, Date dateHeure) {
        this.bondetransfertProduitPK = bondetransfertProduitPK;
        this.quantitee = quantitee;
        this.dateHeure = dateHeure;
    }

    public BondetransfertProduit(long idProduit, long iDBonDeTransfert) {
        this.bondetransfertProduitPK = new BondetransfertProduitPK(idProduit, iDBonDeTransfert);
    }

    public BondetransfertProduitPK getBondetransfertProduitPK() {
        return bondetransfertProduitPK;
    }

    public void setBondetransfertProduitPK(BondetransfertProduitPK bondetransfertProduitPK) {
        this.bondetransfertProduitPK = bondetransfertProduitPK;
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

    public Bondetransfert getBondetransfert() {
        return bondetransfert;
    }

    public void setBondetransfert(Bondetransfert bondetransfert) {
        this.bondetransfert = bondetransfert;
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
        hash += (bondetransfertProduitPK != null ? bondetransfertProduitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BondetransfertProduit)) {
            return false;
        }
        BondetransfertProduit other = (BondetransfertProduit) object;
        if ((this.bondetransfertProduitPK == null && other.bondetransfertProduitPK != null) || (this.bondetransfertProduitPK != null && !this.bondetransfertProduitPK.equals(other.bondetransfertProduitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.BondetransfertProduit[ bondetransfertProduitPK=" + bondetransfertProduitPK + " ]";
    }
    
}
