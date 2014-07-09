/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.gestionClient;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import moncommerce.domain.model.produit.Produit;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "bondesortie_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BondesortieProduit.findAll", query = "SELECT b FROM BondesortieProduit b"),
    @NamedQuery(name = "BondesortieProduit.findByIdProduit", query = "SELECT b FROM BondesortieProduit b WHERE b.bondesortieProduitPK.idProduit = :idProduit"),
    @NamedQuery(name = "BondesortieProduit.findByIDBondesortie", query = "SELECT b FROM BondesortieProduit b WHERE b.bondesortieProduitPK.iDBondesortie = :iDBondesortie"),
    @NamedQuery(name = "BondesortieProduit.findByQuantitee", query = "SELECT b FROM BondesortieProduit b WHERE b.quantitee = :quantitee"),
    @NamedQuery(name = "BondesortieProduit.findByPrixUnitaireHT", query = "SELECT b FROM BondesortieProduit b WHERE b.prixUnitaireHT = :prixUnitaireHT"),
    @NamedQuery(name = "BondesortieProduit.findByRemise", query = "SELECT b FROM BondesortieProduit b WHERE b.remise = :remise"),
    @NamedQuery(name = "BondesortieProduit.findByDateHeure", query = "SELECT b FROM BondesortieProduit b WHERE b.dateHeure = :dateHeure"),
    @NamedQuery(name = "BondesortieProduit.findByPoidsUnitaireBrute", query = "SELECT b FROM BondesortieProduit b WHERE b.poidsUnitaireBrute = :poidsUnitaireBrute"),
    @NamedQuery(name = "BondesortieProduit.findByPoidsUnitaireNet", query = "SELECT b FROM BondesortieProduit b WHERE b.poidsUnitaireNet = :poidsUnitaireNet"),
    @NamedQuery(name = "BondesortieProduit.findByNombreParcolis", query = "SELECT b FROM BondesortieProduit b WHERE b.nombreParcolis = :nombreParcolis"),
    @NamedQuery(name = "BondesortieProduit.findByNombreColis", query = "SELECT b FROM BondesortieProduit b WHERE b.nombreColis = :nombreColis")})
public class BondesortieProduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BondesortieProduitPK bondesortieProduitPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantitee")
    private long quantitee;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix_Unitaire_HT")
    private BigDecimal prixUnitaireHT;
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
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Description")
    private String description;
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
    @JoinColumn(name = "ID_Bon_de_sortie", referencedColumnName = "ID_Bon_de_sortie", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Bondesortie bondesortie;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;

    public BondesortieProduit() {
    }

    public BondesortieProduit(BondesortieProduitPK bondesortieProduitPK) {
        this.bondesortieProduitPK = bondesortieProduitPK;
    }

    public BondesortieProduit(BondesortieProduitPK bondesortieProduitPK, long quantitee, BigDecimal prixUnitaireHT, BigDecimal remise, Date dateHeure, String description, int poidsUnitaireBrute, int poidsUnitaireNet, int nombreParcolis, int nombreColis) {
        this.bondesortieProduitPK = bondesortieProduitPK;
        this.quantitee = quantitee;
        this.prixUnitaireHT = prixUnitaireHT;
        this.remise = remise;
        this.dateHeure = dateHeure;
        this.description = description;
        this.poidsUnitaireBrute = poidsUnitaireBrute;
        this.poidsUnitaireNet = poidsUnitaireNet;
        this.nombreParcolis = nombreParcolis;
        this.nombreColis = nombreColis;
    }

    public BondesortieProduit(long idProduit, long iDBondesortie) {
        this.bondesortieProduitPK = new BondesortieProduitPK(idProduit, iDBondesortie);
    }

    public BondesortieProduitPK getBondesortieProduitPK() {
        return bondesortieProduitPK;
    }

    public void setBondesortieProduitPK(BondesortieProduitPK bondesortieProduitPK) {
        this.bondesortieProduitPK = bondesortieProduitPK;
    }

    public long getQuantitee() {
        return quantitee;
    }

    public void setQuantitee(long quantitee) {
        this.quantitee = quantitee;
    }

    public BigDecimal getPrixUnitaireHT() {
        return prixUnitaireHT;
    }

    public void setPrixUnitaireHT(BigDecimal prixUnitaireHT) {
        this.prixUnitaireHT = prixUnitaireHT;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Bondesortie getBondesortie() {
        return bondesortie;
    }

    public void setBondesortie(Bondesortie bondesortie) {
        this.bondesortie = bondesortie;
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
        hash += (bondesortieProduitPK != null ? bondesortieProduitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BondesortieProduit)) {
            return false;
        }
        BondesortieProduit other = (BondesortieProduit) object;
        if ((this.bondesortieProduitPK == null && other.bondesortieProduitPK != null) || (this.bondesortieProduitPK != null && !this.bondesortieProduitPK.equals(other.bondesortieProduitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.BondesortieProduit[ bondesortieProduitPK=" + bondesortieProduitPK + " ]";
    }
    
}
