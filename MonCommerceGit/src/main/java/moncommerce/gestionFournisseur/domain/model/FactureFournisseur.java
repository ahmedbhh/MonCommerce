/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.gestionFournisseur.domain.model;

import moncommerce.fournisseur.domain.model.Fournisseur;
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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "facture_fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactureFournisseur.findAll", query = "SELECT f FROM FactureFournisseur f"),
    @NamedQuery(name = "FactureFournisseur.findByIDFactureFournisseur", query = "SELECT f FROM FactureFournisseur f WHERE f.iDFactureFournisseur = :iDFactureFournisseur"),
    @NamedQuery(name = "FactureFournisseur.findByReferance", query = "SELECT f FROM FactureFournisseur f WHERE f.referance = :referance"),
    @NamedQuery(name = "FactureFournisseur.findByCodeBarres", query = "SELECT f FROM FactureFournisseur f WHERE f.codeBarres = :codeBarres"),
    @NamedQuery(name = "FactureFournisseur.findByDate", query = "SELECT f FROM FactureFournisseur f WHERE f.date = :date"),
    @NamedQuery(name = "FactureFournisseur.findByDateEcheance", query = "SELECT f FROM FactureFournisseur f WHERE f.dateEcheance = :dateEcheance"),
    @NamedQuery(name = "FactureFournisseur.findByDateHeure", query = "SELECT f FROM FactureFournisseur f WHERE f.dateHeure = :dateHeure"),
    @NamedQuery(name = "FactureFournisseur.findByTotalHT", query = "SELECT f FROM FactureFournisseur f WHERE f.totalHT = :totalHT"),
    @NamedQuery(name = "FactureFournisseur.findByTotalttc", query = "SELECT f FROM FactureFournisseur f WHERE f.totalttc = :totalttc"),
    @NamedQuery(name = "FactureFournisseur.findByTotalTVA", query = "SELECT f FROM FactureFournisseur f WHERE f.totalTVA = :totalTVA"),
    @NamedQuery(name = "FactureFournisseur.findByRemisetotal", query = "SELECT f FROM FactureFournisseur f WHERE f.remisetotal = :remisetotal"),
    @NamedQuery(name = "FactureFournisseur.findBySoldee", query = "SELECT f FROM FactureFournisseur f WHERE f.soldee = :soldee")})
public class FactureFournisseur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFacture_Fournisseur")
    private Long iDFactureFournisseur;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Size(max = 50)
    @Column(name = "code_Barres")
    private String codeBarres;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Column(name = "date_echeance")
    @Temporal(TemporalType.DATE)
    private Date dateEcheance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TotalHT")
    private BigDecimal totalHT;
    @Column(name = "Totalttc")
    private BigDecimal totalttc;
    @Column(name = "TotalTVA")
    private BigDecimal totalTVA;
    @Column(name = "Remise_total")
    private BigDecimal remisetotal;
    @Column(name = "soldee")
    private Short soldee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factureFournisseur", fetch = FetchType.LAZY)
    private Collection<FactureFournisseurReglementFournisseurs> factureFournisseurReglementFournisseursCollection;
    @OneToMany(mappedBy = "iDFactureFournisseur", fetch = FetchType.LAZY)
    private Collection<Accompte> accompteCollection;
    @JoinColumn(name = "IDCommande_fournisseur", referencedColumnName = "IDCommande_fournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Commande iDCommandefournisseur;
    @JoinColumn(name = "IDFournisseur", referencedColumnName = "IDFournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fournisseur iDFournisseur;
    @OneToMany(mappedBy = "iDFactureFournisseur", fetch = FetchType.LAZY)
    private Collection<Bonentree> bonentreeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "factureFournisseur", fetch = FetchType.LAZY)
    private Collection<ProduitFactureFournisseur> produitFactureFournisseurCollection;

    public FactureFournisseur() {
    }

    public FactureFournisseur(Long iDFactureFournisseur) {
        this.iDFactureFournisseur = iDFactureFournisseur;
    }

    public FactureFournisseur(Long iDFactureFournisseur, Date dateHeure) {
        this.iDFactureFournisseur = iDFactureFournisseur;
        this.dateHeure = dateHeure;
    }

    public Long getIDFactureFournisseur() {
        return iDFactureFournisseur;
    }

    public void setIDFactureFournisseur(Long iDFactureFournisseur) {
        this.iDFactureFournisseur = iDFactureFournisseur;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public String getCodeBarres() {
        return codeBarres;
    }

    public void setCodeBarres(String codeBarres) {
        this.codeBarres = codeBarres;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public BigDecimal getTotalHT() {
        return totalHT;
    }

    public void setTotalHT(BigDecimal totalHT) {
        this.totalHT = totalHT;
    }

    public BigDecimal getTotalttc() {
        return totalttc;
    }

    public void setTotalttc(BigDecimal totalttc) {
        this.totalttc = totalttc;
    }

    public BigDecimal getTotalTVA() {
        return totalTVA;
    }

    public void setTotalTVA(BigDecimal totalTVA) {
        this.totalTVA = totalTVA;
    }

    public BigDecimal getRemisetotal() {
        return remisetotal;
    }

    public void setRemisetotal(BigDecimal remisetotal) {
        this.remisetotal = remisetotal;
    }

    public Short getSoldee() {
        return soldee;
    }

    public void setSoldee(Short soldee) {
        this.soldee = soldee;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<FactureFournisseurReglementFournisseurs> getFactureFournisseurReglementFournisseursCollection() {
        return factureFournisseurReglementFournisseursCollection;
    }

    public void setFactureFournisseurReglementFournisseursCollection(Collection<FactureFournisseurReglementFournisseurs> factureFournisseurReglementFournisseursCollection) {
        this.factureFournisseurReglementFournisseursCollection = factureFournisseurReglementFournisseursCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Accompte> getAccompteCollection() {
        return accompteCollection;
    }

    public void setAccompteCollection(Collection<Accompte> accompteCollection) {
        this.accompteCollection = accompteCollection;
    }

    public Commande getIDCommandefournisseur() {
        return iDCommandefournisseur;
    }

    public void setIDCommandefournisseur(Commande iDCommandefournisseur) {
        this.iDCommandefournisseur = iDCommandefournisseur;
    }

    public Fournisseur getIDFournisseur() {
        return iDFournisseur;
    }

    public void setIDFournisseur(Fournisseur iDFournisseur) {
        this.iDFournisseur = iDFournisseur;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Bonentree> getBonentreeCollection() {
        return bonentreeCollection;
    }

    public void setBonentreeCollection(Collection<Bonentree> bonentreeCollection) {
        this.bonentreeCollection = bonentreeCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ProduitFactureFournisseur> getProduitFactureFournisseurCollection() {
        return produitFactureFournisseurCollection;
    }

    public void setProduitFactureFournisseurCollection(Collection<ProduitFactureFournisseur> produitFactureFournisseurCollection) {
        this.produitFactureFournisseurCollection = produitFactureFournisseurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFactureFournisseur != null ? iDFactureFournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactureFournisseur)) {
            return false;
        }
        FactureFournisseur other = (FactureFournisseur) object;
        if ((this.iDFactureFournisseur == null && other.iDFactureFournisseur != null) || (this.iDFactureFournisseur != null && !this.iDFactureFournisseur.equals(other.iDFactureFournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.FactureFournisseur[ iDFactureFournisseur=" + iDFactureFournisseur + " ]";
    }
    
}
