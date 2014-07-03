/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "facture_client_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactureClientProduit.findAll", query = "SELECT f FROM FactureClientProduit f"),
    @NamedQuery(name = "FactureClientProduit.findByIDProduit", query = "SELECT f FROM FactureClientProduit f WHERE f.factureClientProduitPK.iDProduit = :iDProduit"),
    @NamedQuery(name = "FactureClientProduit.findByIDFactureClient", query = "SELECT f FROM FactureClientProduit f WHERE f.factureClientProduitPK.iDFactureClient = :iDFactureClient"),
    @NamedQuery(name = "FactureClientProduit.findByQuantitee", query = "SELECT f FROM FactureClientProduit f WHERE f.quantitee = :quantitee"),
    @NamedQuery(name = "FactureClientProduit.findByPrixUnitaireHT", query = "SELECT f FROM FactureClientProduit f WHERE f.prixUnitaireHT = :prixUnitaireHT"),
    @NamedQuery(name = "FactureClientProduit.findByRemise", query = "SELECT f FROM FactureClientProduit f WHERE f.remise = :remise"),
    @NamedQuery(name = "FactureClientProduit.findByDateHeure", query = "SELECT f FROM FactureClientProduit f WHERE f.dateHeure = :dateHeure"),
    @NamedQuery(name = "FactureClientProduit.findByPoidsUnitaireBrute", query = "SELECT f FROM FactureClientProduit f WHERE f.poidsUnitaireBrute = :poidsUnitaireBrute"),
    @NamedQuery(name = "FactureClientProduit.findByPoidsUnitaireNet", query = "SELECT f FROM FactureClientProduit f WHERE f.poidsUnitaireNet = :poidsUnitaireNet"),
    @NamedQuery(name = "FactureClientProduit.findByNombreParcolis", query = "SELECT f FROM FactureClientProduit f WHERE f.nombreParcolis = :nombreParcolis"),
    @NamedQuery(name = "FactureClientProduit.findByNombreColis", query = "SELECT f FROM FactureClientProduit f WHERE f.nombreColis = :nombreColis")})
public class FactureClientProduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected FactureClientProduitPK factureClientProduitPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantitee", nullable = false)
    private long quantitee;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "prixUnitaireHT", nullable = false, precision = 24, scale = 6)
    private BigDecimal prixUnitaireHT;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Remise", nullable = false, precision = 24, scale = 6)
    private BigDecimal remise;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Description", nullable = false, length = 2147483647)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Poids_Unitaire_Brute", nullable = false)
    private int poidsUnitaireBrute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Poids_Unitaire_Net", nullable = false)
    private int poidsUnitaireNet;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Nombre_Par_colis", nullable = false)
    private int nombreParcolis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre_Colis", nullable = false)
    private int nombreColis;
    @JoinColumn(name = "IDFacture_Client", referencedColumnName = "IDFacture_Clients", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private FactureClients factureClients;
    @JoinColumn(name = "IDProduit", referencedColumnName = "IDProduit", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Produit produit;

    public FactureClientProduit() {
    }

    public FactureClientProduit(FactureClientProduitPK factureClientProduitPK) {
        this.factureClientProduitPK = factureClientProduitPK;
    }

    public FactureClientProduit(FactureClientProduitPK factureClientProduitPK, long quantitee, BigDecimal prixUnitaireHT, BigDecimal remise, Date dateHeure, String description, int poidsUnitaireBrute, int poidsUnitaireNet, int nombreParcolis, int nombreColis) {
        this.factureClientProduitPK = factureClientProduitPK;
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

    public FactureClientProduit(long iDProduit, long iDFactureClient) {
        this.factureClientProduitPK = new FactureClientProduitPK(iDProduit, iDFactureClient);
    }

    public FactureClientProduitPK getFactureClientProduitPK() {
        return factureClientProduitPK;
    }

    public void setFactureClientProduitPK(FactureClientProduitPK factureClientProduitPK) {
        this.factureClientProduitPK = factureClientProduitPK;
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

    public FactureClients getFactureClients() {
        return factureClients;
    }

    public void setFactureClients(FactureClients factureClients) {
        this.factureClients = factureClients;
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
        hash += (factureClientProduitPK != null ? factureClientProduitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactureClientProduit)) {
            return false;
        }
        FactureClientProduit other = (FactureClientProduit) object;
        if ((this.factureClientProduitPK == null && other.factureClientProduitPK != null) || (this.factureClientProduitPK != null && !this.factureClientProduitPK.equals(other.factureClientProduitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.FactureClientProduit[ factureClientProduitPK=" + factureClientProduitPK + " ]";
    }
    
}
