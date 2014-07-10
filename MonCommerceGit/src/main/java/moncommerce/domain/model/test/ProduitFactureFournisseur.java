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

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "produit_facture_fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduitFactureFournisseur.findAll", query = "SELECT p FROM ProduitFactureFournisseur p"),
    @NamedQuery(name = "ProduitFactureFournisseur.findByIDFactureFournisseur", query = "SELECT p FROM ProduitFactureFournisseur p WHERE p.produitFactureFournisseurPK.iDFactureFournisseur = :iDFactureFournisseur"),
    @NamedQuery(name = "ProduitFactureFournisseur.findByIdProduit", query = "SELECT p FROM ProduitFactureFournisseur p WHERE p.produitFactureFournisseurPK.idProduit = :idProduit"),
    @NamedQuery(name = "ProduitFactureFournisseur.findByQuantitee", query = "SELECT p FROM ProduitFactureFournisseur p WHERE p.quantitee = :quantitee"),
    @NamedQuery(name = "ProduitFactureFournisseur.findByPrixAchatHT", query = "SELECT p FROM ProduitFactureFournisseur p WHERE p.prixAchatHT = :prixAchatHT"),
    @NamedQuery(name = "ProduitFactureFournisseur.findByRemise", query = "SELECT p FROM ProduitFactureFournisseur p WHERE p.remise = :remise"),
    @NamedQuery(name = "ProduitFactureFournisseur.findByDateHeure", query = "SELECT p FROM ProduitFactureFournisseur p WHERE p.dateHeure = :dateHeure"),
    @NamedQuery(name = "ProduitFactureFournisseur.findByPoidsUnitaireBrute", query = "SELECT p FROM ProduitFactureFournisseur p WHERE p.poidsUnitaireBrute = :poidsUnitaireBrute"),
    @NamedQuery(name = "ProduitFactureFournisseur.findByPoidsUnitaireNet", query = "SELECT p FROM ProduitFactureFournisseur p WHERE p.poidsUnitaireNet = :poidsUnitaireNet"),
    @NamedQuery(name = "ProduitFactureFournisseur.findByNombreParcolis", query = "SELECT p FROM ProduitFactureFournisseur p WHERE p.nombreParcolis = :nombreParcolis"),
    @NamedQuery(name = "ProduitFactureFournisseur.findByNombreColis", query = "SELECT p FROM ProduitFactureFournisseur p WHERE p.nombreColis = :nombreColis")})
public class ProduitFactureFournisseur implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProduitFactureFournisseurPK produitFactureFournisseurPK;
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
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;
    @JoinColumn(name = "ID_Facture_Fournisseur", referencedColumnName = "ID_Facture_Fournisseur", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FactureFournisseur factureFournisseur;

    public ProduitFactureFournisseur() {
    }

    public ProduitFactureFournisseur(ProduitFactureFournisseurPK produitFactureFournisseurPK) {
        this.produitFactureFournisseurPK = produitFactureFournisseurPK;
    }

    public ProduitFactureFournisseur(ProduitFactureFournisseurPK produitFactureFournisseurPK, long quantitee, BigDecimal prixAchatHT, BigDecimal remise, Date dateHeure, String description, int poidsUnitaireBrute, int poidsUnitaireNet, int nombreParcolis, int nombreColis) {
        this.produitFactureFournisseurPK = produitFactureFournisseurPK;
        this.quantitee = quantitee;
        this.prixAchatHT = prixAchatHT;
        this.remise = remise;
        this.dateHeure = dateHeure;
        this.description = description;
        this.poidsUnitaireBrute = poidsUnitaireBrute;
        this.poidsUnitaireNet = poidsUnitaireNet;
        this.nombreParcolis = nombreParcolis;
        this.nombreColis = nombreColis;
    }

    public ProduitFactureFournisseur(long iDFactureFournisseur, long idProduit) {
        this.produitFactureFournisseurPK = new ProduitFactureFournisseurPK(iDFactureFournisseur, idProduit);
    }

    public ProduitFactureFournisseurPK getProduitFactureFournisseurPK() {
        return produitFactureFournisseurPK;
    }

    public void setProduitFactureFournisseurPK(ProduitFactureFournisseurPK produitFactureFournisseurPK) {
        this.produitFactureFournisseurPK = produitFactureFournisseurPK;
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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public FactureFournisseur getFactureFournisseur() {
        return factureFournisseur;
    }

    public void setFactureFournisseur(FactureFournisseur factureFournisseur) {
        this.factureFournisseur = factureFournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produitFactureFournisseurPK != null ? produitFactureFournisseurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitFactureFournisseur)) {
            return false;
        }
        ProduitFactureFournisseur other = (ProduitFactureFournisseur) object;
        if ((this.produitFactureFournisseurPK == null && other.produitFactureFournisseurPK != null) || (this.produitFactureFournisseurPK != null && !this.produitFactureFournisseurPK.equals(other.produitFactureFournisseurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.ProduitFactureFournisseur[ produitFactureFournisseurPK=" + produitFactureFournisseurPK + " ]";
    }
    
}
