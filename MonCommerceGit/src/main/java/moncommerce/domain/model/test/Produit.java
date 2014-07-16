/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Produit.findByIdProduit", query = "SELECT p FROM Produit p WHERE p.idProduit = :idProduit"),
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
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_produit")
    private Long idProduit;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Size(max = 20)
    @Column(name = "Libelle")
    private String libelle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Prix_Achat_HT")
    private BigDecimal prixAchatHT;
    @Column(name = "Prix_Moyen_Pondere")
    private BigDecimal prixMoyenPondere;
    @Column(name = "Produit_A_Vendre")
    private Short produitAVendre;
    @Column(name = "Produit_Composer")
    private Short produitComposer;
    @Lob
    @Column(name = "Photo")
    private byte[] photo;
    @Column(name = "Prix_Vente")
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
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Size(max = 20)
    @Column(name = "Marque")
    private String marque;
    @JoinColumn(name = "Tva", referencedColumnName = "tva")
    @ManyToOne
    private Tva tva;
    @JoinColumn(name = "ID_Unitee_Mesure", referencedColumnName = "ID_Unitee_Mesure")
    @ManyToOne
    private Uniteemesure iDUniteeMesure;
    @JoinColumn(name = "Famille", referencedColumnName = "Libelle")
    @ManyToOne
    private Famille famille;
    @JoinColumn(name = "Sous_famille", referencedColumnName = "Libelle")
    @ManyToOne
    private Sousfamille sousfamille;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<FactureClientProduit> factureClientProduitCollection;

    public Produit() {
    }

    public Produit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public Produit(Long idProduit, Date dateHeure) {
        this.idProduit = idProduit;
        this.dateHeure = dateHeure;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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
    public Collection<FactureClientProduit> getFactureClientProduitCollection() {
        return factureClientProduitCollection;
    }

    public void setFactureClientProduitCollection(Collection<FactureClientProduit> factureClientProduitCollection) {
        this.factureClientProduitCollection = factureClientProduitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduit != null ? idProduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idProduit == null && other.idProduit != null) || (this.idProduit != null && !this.idProduit.equals(other.idProduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.Produit[ idProduit=" + idProduit + " ]";
    }
    
}
