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
@Table(name = "commande_produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommandeProduit.findAll", query = "SELECT c FROM CommandeProduit c"),
    @NamedQuery(name = "CommandeProduit.findByIDProduit", query = "SELECT c FROM CommandeProduit c WHERE c.commandeProduitPK.iDProduit = :iDProduit"),
    @NamedQuery(name = "CommandeProduit.findByIDCommandefournisseur", query = "SELECT c FROM CommandeProduit c WHERE c.commandeProduitPK.iDCommandefournisseur = :iDCommandefournisseur"),
    @NamedQuery(name = "CommandeProduit.findByQuantitee", query = "SELECT c FROM CommandeProduit c WHERE c.quantitee = :quantitee"),
    @NamedQuery(name = "CommandeProduit.findByPrixAchatHT", query = "SELECT c FROM CommandeProduit c WHERE c.prixAchatHT = :prixAchatHT"),
    @NamedQuery(name = "CommandeProduit.findByRemise", query = "SELECT c FROM CommandeProduit c WHERE c.remise = :remise"),
    @NamedQuery(name = "CommandeProduit.findByDateHeure", query = "SELECT c FROM CommandeProduit c WHERE c.dateHeure = :dateHeure"),
    @NamedQuery(name = "CommandeProduit.findByRemisetotal", query = "SELECT c FROM CommandeProduit c WHERE c.remisetotal = :remisetotal"),
    @NamedQuery(name = "CommandeProduit.findByTva", query = "SELECT c FROM CommandeProduit c WHERE c.tva = :tva"),
    @NamedQuery(name = "CommandeProduit.findByDescription", query = "SELECT c FROM CommandeProduit c WHERE c.description = :description")})
public class CommandeProduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CommandeProduitPK commandeProduitPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantitee", nullable = false)
    private long quantitee;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrixAchatHT", nullable = false, precision = 24, scale = 6)
    private BigDecimal prixAchatHT;
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
    @Column(name = "Remise_total", nullable = false, precision = 24, scale = 6)
    private BigDecimal remisetotal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tva", nullable = false)
    private double tva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Description", nullable = false, length = 50)
    private String description;
    @JoinColumn(name = "IDProduit", referencedColumnName = "IDProduit", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Produit produit;
    @JoinColumn(name = "IDCommande_fournisseur", referencedColumnName = "IDCommande_fournisseur", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Commande commande;

    public CommandeProduit() {
    }

    public CommandeProduit(CommandeProduitPK commandeProduitPK) {
        this.commandeProduitPK = commandeProduitPK;
    }

    public CommandeProduit(CommandeProduitPK commandeProduitPK, long quantitee, BigDecimal prixAchatHT, BigDecimal remise, Date dateHeure, BigDecimal remisetotal, double tva, String description) {
        this.commandeProduitPK = commandeProduitPK;
        this.quantitee = quantitee;
        this.prixAchatHT = prixAchatHT;
        this.remise = remise;
        this.dateHeure = dateHeure;
        this.remisetotal = remisetotal;
        this.tva = tva;
        this.description = description;
    }

    public CommandeProduit(long iDProduit, long iDCommandefournisseur) {
        this.commandeProduitPK = new CommandeProduitPK(iDProduit, iDCommandefournisseur);
    }

    public CommandeProduitPK getCommandeProduitPK() {
        return commandeProduitPK;
    }

    public void setCommandeProduitPK(CommandeProduitPK commandeProduitPK) {
        this.commandeProduitPK = commandeProduitPK;
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

    public BigDecimal getRemisetotal() {
        return remisetotal;
    }

    public void setRemisetotal(BigDecimal remisetotal) {
        this.remisetotal = remisetotal;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commandeProduitPK != null ? commandeProduitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandeProduit)) {
            return false;
        }
        CommandeProduit other = (CommandeProduit) object;
        if ((this.commandeProduitPK == null && other.commandeProduitPK != null) || (this.commandeProduitPK != null && !this.commandeProduitPK.equals(other.commandeProduitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.CommandeProduit[ commandeProduitPK=" + commandeProduitPK + " ]";
    }
    
}
