/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.test;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "bonentree_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BonentreeProduit.findAll", query = "SELECT b FROM BonentreeProduit b"),
    @NamedQuery(name = "BonentreeProduit.findByIdProduit", query = "SELECT b FROM BonentreeProduit b WHERE b.bonentreeProduitPK.idProduit = :idProduit"),
    @NamedQuery(name = "BonentreeProduit.findByIDBonEntree", query = "SELECT b FROM BonentreeProduit b WHERE b.bonentreeProduitPK.iDBonEntree = :iDBonEntree"),
    @NamedQuery(name = "BonentreeProduit.findByQuantitee", query = "SELECT b FROM BonentreeProduit b WHERE b.quantitee = :quantitee"),
    @NamedQuery(name = "BonentreeProduit.findByPrixAchatHT", query = "SELECT b FROM BonentreeProduit b WHERE b.prixAchatHT = :prixAchatHT"),
    @NamedQuery(name = "BonentreeProduit.findByRemise", query = "SELECT b FROM BonentreeProduit b WHERE b.remise = :remise"),
    @NamedQuery(name = "BonentreeProduit.findByDateHeure", query = "SELECT b FROM BonentreeProduit b WHERE b.dateHeure = :dateHeure"),
    @NamedQuery(name = "BonentreeProduit.findByPoidsUnitaireBrute", query = "SELECT b FROM BonentreeProduit b WHERE b.poidsUnitaireBrute = :poidsUnitaireBrute"),
    @NamedQuery(name = "BonentreeProduit.findByPoidsUnitaireNet", query = "SELECT b FROM BonentreeProduit b WHERE b.poidsUnitaireNet = :poidsUnitaireNet"),
    @NamedQuery(name = "BonentreeProduit.findByNombreParcolis", query = "SELECT b FROM BonentreeProduit b WHERE b.nombreParcolis = :nombreParcolis"),
    @NamedQuery(name = "BonentreeProduit.findByNombreColis", query = "SELECT b FROM BonentreeProduit b WHERE b.nombreColis = :nombreColis")})
public class BonentreeProduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BonentreeProduitPK bonentreeProduitPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantitee")
    private long quantitee;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Prix_Achat_HT")
    private BigDecimal prixAchatHT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Remise")
    private BigDecimal remise;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Poids_Unitaire_Brute")
    private int poidsUnitaireBrute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Poids_Unitaire_Net")
    private int poidsUnitaireNet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nombre_Par_colis")
    private int nombreParcolis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre_Colis")
    private int nombreColis;
    @JoinColumn(name = "ID_Bon_Entree", referencedColumnName = "ID_Bon_Entree", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bonentree bonentree;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;

    public BonentreeProduit() {
    }

    public BonentreeProduit(BonentreeProduitPK bonentreeProduitPK) {
        this.bonentreeProduitPK = bonentreeProduitPK;
    }

    public BonentreeProduit(BonentreeProduitPK bonentreeProduitPK, long quantitee, BigDecimal prixAchatHT, BigDecimal remise, Date dateHeure, int poidsUnitaireBrute, int poidsUnitaireNet, int nombreParcolis, int nombreColis) {
        this.bonentreeProduitPK = bonentreeProduitPK;
        this.quantitee = quantitee;
        this.prixAchatHT = prixAchatHT;
        this.remise = remise;
        this.dateHeure = dateHeure;
        this.poidsUnitaireBrute = poidsUnitaireBrute;
        this.poidsUnitaireNet = poidsUnitaireNet;
        this.nombreParcolis = nombreParcolis;
        this.nombreColis = nombreColis;
    }

    public BonentreeProduit(long idProduit, long iDBonEntree) {
        this.bonentreeProduitPK = new BonentreeProduitPK(idProduit, iDBonEntree);
    }

    public BonentreeProduitPK getBonentreeProduitPK() {
        return bonentreeProduitPK;
    }

    public void setBonentreeProduitPK(BonentreeProduitPK bonentreeProduitPK) {
        this.bonentreeProduitPK = bonentreeProduitPK;
    }

    public long getQuantitee() {
        return quantitee;
    }

    public void setQuantitee(long quantitee) {
        this.quantitee = quantitee;
    }

    public BigDecimal getPrixAchatHT() {
        return prixAchatHT;
    }

    public void setPrixAchatHT(BigDecimal prixAchatHT) {
        this.prixAchatHT = prixAchatHT;
    }

    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public int getPoidsUnitaireBrute() {
        return poidsUnitaireBrute;
    }

    public void setPoidsUnitaireBrute(int poidsUnitaireBrute) {
        this.poidsUnitaireBrute = poidsUnitaireBrute;
    }

    public int getPoidsUnitaireNet() {
        return poidsUnitaireNet;
    }

    public void setPoidsUnitaireNet(int poidsUnitaireNet) {
        this.poidsUnitaireNet = poidsUnitaireNet;
    }

    public int getNombreParcolis() {
        return nombreParcolis;
    }

    public void setNombreParcolis(int nombreParcolis) {
        this.nombreParcolis = nombreParcolis;
    }

    public int getNombreColis() {
        return nombreColis;
    }

    public void setNombreColis(int nombreColis) {
        this.nombreColis = nombreColis;
    }

    public Bonentree getBonentree() {
        return bonentree;
    }

    public void setBonentree(Bonentree bonentree) {
        this.bonentree = bonentree;
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
        hash += (bonentreeProduitPK != null ? bonentreeProduitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BonentreeProduit)) {
            return false;
        }
        BonentreeProduit other = (BonentreeProduit) object;
        if ((this.bonentreeProduitPK == null && other.bonentreeProduitPK != null) || (this.bonentreeProduitPK != null && !this.bonentreeProduitPK.equals(other.bonentreeProduitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.BonentreeProduit[ bonentreeProduitPK=" + bonentreeProduitPK + " ]";
    }
    
}
