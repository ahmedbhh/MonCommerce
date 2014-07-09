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
@Table(name = "ligne_commande_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LigneCommandeClient.findAll", query = "SELECT l FROM LigneCommandeClient l"),
    @NamedQuery(name = "LigneCommandeClient.findByIDCommandeClient", query = "SELECT l FROM LigneCommandeClient l WHERE l.ligneCommandeClientPK.iDCommandeClient = :iDCommandeClient"),
    @NamedQuery(name = "LigneCommandeClient.findByIdProduit", query = "SELECT l FROM LigneCommandeClient l WHERE l.ligneCommandeClientPK.idProduit = :idProduit"),
    @NamedQuery(name = "LigneCommandeClient.findByQuantitee", query = "SELECT l FROM LigneCommandeClient l WHERE l.quantitee = :quantitee"),
    @NamedQuery(name = "LigneCommandeClient.findByPrixUnitaireHT", query = "SELECT l FROM LigneCommandeClient l WHERE l.prixUnitaireHT = :prixUnitaireHT"),
    @NamedQuery(name = "LigneCommandeClient.findByRemise", query = "SELECT l FROM LigneCommandeClient l WHERE l.remise = :remise"),
    @NamedQuery(name = "LigneCommandeClient.findByDateHeure", query = "SELECT l FROM LigneCommandeClient l WHERE l.dateHeure = :dateHeure"),
    @NamedQuery(name = "LigneCommandeClient.findByPoidsUnitaireBrute", query = "SELECT l FROM LigneCommandeClient l WHERE l.poidsUnitaireBrute = :poidsUnitaireBrute"),
    @NamedQuery(name = "LigneCommandeClient.findByPoidsUnitaireNet", query = "SELECT l FROM LigneCommandeClient l WHERE l.poidsUnitaireNet = :poidsUnitaireNet"),
    @NamedQuery(name = "LigneCommandeClient.findByNombreParcolis", query = "SELECT l FROM LigneCommandeClient l WHERE l.nombreParcolis = :nombreParcolis"),
    @NamedQuery(name = "LigneCommandeClient.findByNombreColis", query = "SELECT l FROM LigneCommandeClient l WHERE l.nombreColis = :nombreColis")})
public class LigneCommandeClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected LigneCommandeClientPK ligneCommandeClientPK;
    @Column(name = "quantitee")
    private Integer quantitee;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix_Unitaire_HT")
    private BigDecimal prixUnitaireHT;
    @Column(name = "Remise")
    private BigDecimal remise;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Column(name = "Poids_Unitaire_Brute")
    private Integer poidsUnitaireBrute;
    @Column(name = "Poids_Unitaire_Net")
    private Integer poidsUnitaireNet;
    @Column(name = "Nombre_Par_colis")
    private Integer nombreParcolis;
    @Column(name = "nombre_Colis")
    private Integer nombreColis;
    @JoinColumn(name = "ID_Commande_Client", referencedColumnName = "ID_Commande_Client", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CommandeClient commandeClient;
    @JoinColumn(name = "id_produit", referencedColumnName = "id_produit", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;

    public LigneCommandeClient() {
    }

    public LigneCommandeClient(LigneCommandeClientPK ligneCommandeClientPK) {
        this.ligneCommandeClientPK = ligneCommandeClientPK;
    }

    public LigneCommandeClient(LigneCommandeClientPK ligneCommandeClientPK, Date dateHeure) {
        this.ligneCommandeClientPK = ligneCommandeClientPK;
        this.dateHeure = dateHeure;
    }

    public LigneCommandeClient(long iDCommandeClient, long idProduit) {
        this.ligneCommandeClientPK = new LigneCommandeClientPK(iDCommandeClient, idProduit);
    }

    public LigneCommandeClientPK getLigneCommandeClientPK() {
        return ligneCommandeClientPK;
    }

    public void setLigneCommandeClientPK(LigneCommandeClientPK ligneCommandeClientPK) {
        this.ligneCommandeClientPK = ligneCommandeClientPK;
    }

    public Integer getQuantitee() {
        return quantitee;
    }

    public void setQuantitee(Integer quantitee) {
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

    public Integer getPoidsUnitaireBrute() {
        return poidsUnitaireBrute;
    }

    public void setPoidsUnitaireBrute(Integer poidsUnitaireBrute) {
        this.poidsUnitaireBrute = poidsUnitaireBrute;
    }

    public Integer getPoidsUnitaireNet() {
        return poidsUnitaireNet;
    }

    public void setPoidsUnitaireNet(Integer poidsUnitaireNet) {
        this.poidsUnitaireNet = poidsUnitaireNet;
    }

    public Integer getNombreParcolis() {
        return nombreParcolis;
    }

    public void setNombreParcolis(Integer nombreParcolis) {
        this.nombreParcolis = nombreParcolis;
    }

    public Integer getNombreColis() {
        return nombreColis;
    }

    public void setNombreColis(Integer nombreColis) {
        this.nombreColis = nombreColis;
    }

    public CommandeClient getCommandeClient() {
        return commandeClient;
    }

    public void setCommandeClient(CommandeClient commandeClient) {
        this.commandeClient = commandeClient;
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
        hash += (ligneCommandeClientPK != null ? ligneCommandeClientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneCommandeClient)) {
            return false;
        }
        LigneCommandeClient other = (LigneCommandeClient) object;
        if ((this.ligneCommandeClientPK == null && other.ligneCommandeClientPK != null) || (this.ligneCommandeClientPK != null && !this.ligneCommandeClientPK.equals(other.ligneCommandeClientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.LigneCommandeClient[ ligneCommandeClientPK=" + ligneCommandeClientPK + " ]";
    }
    
}
