/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.produit.domain.model;

import moncommerce.gestionClient.domain.model.FactureClientProduit;
import moncommerce.gestionClient.domain.model.BondesortieProduit;
import moncommerce.gestionClient.domain.model.LigneCommandeClient;
import moncommerce.gestionClient.domain.model.CommandeProduit;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import moncommerce.domain.model.BondetransfertProduit;
import moncommerce.gestionFournisseur.domain.model.BonentreeProduit;
import moncommerce.gestionFournisseur.domain.model.ProduitFactureFournisseur;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "produit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByIDProduit", query = "SELECT p FROM Produit p WHERE p.iDProduit = :iDProduit"),
    @NamedQuery(name = "Produit.findByReferance", query = "SELECT p FROM Produit p WHERE p.referance = :referance"),
    @NamedQuery(name = "Produit.findByLibelle", query = "SELECT p FROM Produit p WHERE p.libelle = :libelle"),
    @NamedQuery(name = "Produit.findByPrixAchatHT", query = "SELECT p FROM Produit p WHERE p.prixAchatHT = :prixAchatHT"),
    @NamedQuery(name = "Produit.findByPrixMoyenPondere", query = "SELECT p FROM Produit p WHERE p.prixMoyenPondere = :prixMoyenPondere"),
    @NamedQuery(name = "Produit.findByProduitAVendre", query = "SELECT p FROM Produit p WHERE p.produitAVendre = :produitAVendre"),
    @NamedQuery(name = "Produit.findByProduitComposer", query = "SELECT p FROM Produit p WHERE p.produitComposer = :produitComposer"),
    @NamedQuery(name = "Produit.findByPrixVente", query = "SELECT p FROM Produit p WHERE p.prixVente = :prixVente"),
    @NamedQuery(name = "Produit.findByStockAlert", query = "SELECT p FROM Produit p WHERE p.stockAlert = :stockAlert"),
    @NamedQuery(name = "Produit.findByStockrepture", query = "SELECT p FROM Produit p WHERE p.stockrepture = :stockrepture"),
    @NamedQuery(name = "Produit.findByCodeBarres", query = "SELECT p FROM Produit p WHERE p.codeBarres = :codeBarres"),
    @NamedQuery(name = "Produit.findByDateHeure", query = "SELECT p FROM Produit p WHERE p.dateHeure = :dateHeure"),
    @NamedQuery(name = "Produit.findByMarque", query = "SELECT p FROM Produit p WHERE p.marque = :marque")})
public class Produit implements Serializable {
    @Lob
    @Column(name = "Photo")
    private byte[] photo;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDProduit")
    private Long iDProduit;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Size(max = 20)
    @Column(name = "Libelle")
    private String libelle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PrixAchatHT")
    private BigDecimal prixAchatHT;
    @Column(name = "PrixMoyenPondere")
    private BigDecimal prixMoyenPondere;
    @Column(name = "ProduitAVendre")
    private Short produitAVendre;
    @Column(name = "ProduitComposer")
    private Short produitComposer;
    @Column(name = "PrixVente")
    private BigDecimal prixVente;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Column(name = "Stock_Alert")
    private Integer stockAlert;
    @Column(name = "Stock_repture")
    private Integer stockrepture;
    @Size(max = 50)
    @Column(name = "code_Barres")
    private String codeBarres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Size(max = 20)
    @Column(name = "Marque")
    private String marque;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<BondetransfertProduit> bondetransfertProduitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<BonentreeProduit> bonentreeProduitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<LigneCommandeClient> ligneCommandeClientCollection;
    @JoinColumn(name = "Tva", referencedColumnName = "tva")
    @ManyToOne(fetch = FetchType.LAZY)
    private Tva tva;
    @JoinColumn(name = "IDUniteeMesure", referencedColumnName = "IDUniteeMesure")
    @ManyToOne(fetch = FetchType.LAZY)
    private Uniteemesure iDUniteeMesure;
    @JoinColumn(name = "Famille", referencedColumnName = "Libelle")
    @ManyToOne(fetch = FetchType.LAZY)
    private Famille famille;
    @JoinColumn(name = "Sous_famille", referencedColumnName = "Libelle")
    @ManyToOne(fetch = FetchType.LAZY)
    private Sousfamille sousfamille;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<CommandeProduit> commandeProduitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<ProduitDepot> produitDepotCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<ProduitProduit> produitProduitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit1", fetch = FetchType.LAZY)
    private Collection<ProduitProduit> produitProduitCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<BondesortieProduit> bondesortieProduitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<ProduitFactureFournisseur> produitFactureFournisseurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<FactureClientProduit> factureClientProduitCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit", fetch = FetchType.LAZY)
    private Collection<ProduitCodeTarif> produitCodeTarifCollection;

    public Produit() {
    }

    public Produit(Long iDProduit) {
        this.iDProduit = iDProduit;
    }

    public Produit(Long iDProduit, Date dateHeure) {
        this.iDProduit = iDProduit;
        this.dateHeure = dateHeure;
    }

    public Long getIDProduit() {
        return iDProduit;
    }

    public void setIDProduit(Long iDProduit) {
        this.iDProduit = iDProduit;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public BigDecimal getPrixAchatHT() {
        return prixAchatHT;
    }

    public void setPrixAchatHT(BigDecimal prixAchatHT) {
        this.prixAchatHT = prixAchatHT;
    }

    public BigDecimal getPrixMoyenPondere() {
        return prixMoyenPondere;
    }

    public void setPrixMoyenPondere(BigDecimal prixMoyenPondere) {
        this.prixMoyenPondere = prixMoyenPondere;
    }

    public Short getProduitAVendre() {
        return produitAVendre;
    }

    public void setProduitAVendre(Short produitAVendre) {
        this.produitAVendre = produitAVendre;
    }

    public Short getProduitComposer() {
        return produitComposer;
    }

    public void setProduitComposer(Short produitComposer) {
        this.produitComposer = produitComposer;
    }

    public BigDecimal getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(BigDecimal prixVente) {
        this.prixVente = prixVente;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStockAlert() {
        return stockAlert;
    }

    public void setStockAlert(Integer stockAlert) {
        this.stockAlert = stockAlert;
    }

    public Integer getStockrepture() {
        return stockrepture;
    }

    public void setStockrepture(Integer stockrepture) {
        this.stockrepture = stockrepture;
    }

    public String getCodeBarres() {
        return codeBarres;
    }

    public void setCodeBarres(String codeBarres) {
        this.codeBarres = codeBarres;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<BondetransfertProduit> getBondetransfertProduitCollection() {
        return bondetransfertProduitCollection;
    }

    public void setBondetransfertProduitCollection(Collection<BondetransfertProduit> bondetransfertProduitCollection) {
        this.bondetransfertProduitCollection = bondetransfertProduitCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<BonentreeProduit> getBonentreeProduitCollection() {
        return bonentreeProduitCollection;
    }

    public void setBonentreeProduitCollection(Collection<BonentreeProduit> bonentreeProduitCollection) {
        this.bonentreeProduitCollection = bonentreeProduitCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<LigneCommandeClient> getLigneCommandeClientCollection() {
        return ligneCommandeClientCollection;
    }

    public void setLigneCommandeClientCollection(Collection<LigneCommandeClient> ligneCommandeClientCollection) {
        this.ligneCommandeClientCollection = ligneCommandeClientCollection;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public Uniteemesure getIDUniteeMesure() {
        return iDUniteeMesure;
    }

    public void setIDUniteeMesure(Uniteemesure iDUniteeMesure) {
        this.iDUniteeMesure = iDUniteeMesure;
    }

    public Famille getFamille() {
        return famille;
    }

    public void setFamille(Famille famille) {
        this.famille = famille;
    }

    public Sousfamille getSousfamille() {
        return sousfamille;
    }

    public void setSousfamille(Sousfamille sousfamille) {
        this.sousfamille = sousfamille;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<CommandeProduit> getCommandeProduitCollection() {
        return commandeProduitCollection;
    }

    public void setCommandeProduitCollection(Collection<CommandeProduit> commandeProduitCollection) {
        this.commandeProduitCollection = commandeProduitCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProduitDepot> getProduitDepotCollection() {
        return produitDepotCollection;
    }

    public void setProduitDepotCollection(Collection<ProduitDepot> produitDepotCollection) {
        this.produitDepotCollection = produitDepotCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProduitProduit> getProduitProduitCollection() {
        return produitProduitCollection;
    }

    public void setProduitProduitCollection(Collection<ProduitProduit> produitProduitCollection) {
        this.produitProduitCollection = produitProduitCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProduitProduit> getProduitProduitCollection1() {
        return produitProduitCollection1;
    }

    public void setProduitProduitCollection1(Collection<ProduitProduit> produitProduitCollection1) {
        this.produitProduitCollection1 = produitProduitCollection1;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<BondesortieProduit> getBondesortieProduitCollection() {
        return bondesortieProduitCollection;
    }

    public void setBondesortieProduitCollection(Collection<BondesortieProduit> bondesortieProduitCollection) {
        this.bondesortieProduitCollection = bondesortieProduitCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProduitFactureFournisseur> getProduitFactureFournisseurCollection() {
        return produitFactureFournisseurCollection;
    }

    public void setProduitFactureFournisseurCollection(Collection<ProduitFactureFournisseur> produitFactureFournisseurCollection) {
        this.produitFactureFournisseurCollection = produitFactureFournisseurCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<FactureClientProduit> getFactureClientProduitCollection() {
        return factureClientProduitCollection;
    }

    public void setFactureClientProduitCollection(Collection<FactureClientProduit> factureClientProduitCollection) {
        this.factureClientProduitCollection = factureClientProduitCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProduitCodeTarif> getProduitCodeTarifCollection() {
        return produitCodeTarifCollection;
    }

    public void setProduitCodeTarifCollection(Collection<ProduitCodeTarif> produitCodeTarifCollection) {
        this.produitCodeTarifCollection = produitCodeTarifCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProduit != null ? iDProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.iDProduit == null && other.iDProduit != null) || (this.iDProduit != null && !this.iDProduit.equals(other.iDProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Produit[ iDProduit=" + iDProduit + " ]";
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
    
}
