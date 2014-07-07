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
import moncommerce.domain.model.Depot;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "bonentree")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bonentree.findAll", query = "SELECT b FROM Bonentree b"),
    @NamedQuery(name = "Bonentree.findByIDBonEntree", query = "SELECT b FROM Bonentree b WHERE b.iDBonEntree = :iDBonEntree"),
    @NamedQuery(name = "Bonentree.findByDate", query = "SELECT b FROM Bonentree b WHERE b.date = :date"),
    @NamedQuery(name = "Bonentree.findByReferance", query = "SELECT b FROM Bonentree b WHERE b.referance = :referance"),
    @NamedQuery(name = "Bonentree.findByValidee", query = "SELECT b FROM Bonentree b WHERE b.validee = :validee"),
    @NamedQuery(name = "Bonentree.findByCodeBarres", query = "SELECT b FROM Bonentree b WHERE b.codeBarres = :codeBarres"),
    @NamedQuery(name = "Bonentree.findByDateHeure", query = "SELECT b FROM Bonentree b WHERE b.dateHeure = :dateHeure"),
    @NamedQuery(name = "Bonentree.findByTotalHT", query = "SELECT b FROM Bonentree b WHERE b.totalHT = :totalHT"),
    @NamedQuery(name = "Bonentree.findByTotalttc", query = "SELECT b FROM Bonentree b WHERE b.totalttc = :totalttc"),
    @NamedQuery(name = "Bonentree.findByTotalTVA", query = "SELECT b FROM Bonentree b WHERE b.totalTVA = :totalTVA"),
    @NamedQuery(name = "Bonentree.findByRemisetotal", query = "SELECT b FROM Bonentree b WHERE b.remisetotal = :remisetotal"),
    @NamedQuery(name = "Bonentree.findBySoldee", query = "SELECT b FROM Bonentree b WHERE b.soldee = :soldee")})
public class Bonentree implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDBonEntree")
    private Long iDBonEntree;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Column(name = "validee")
    private Short validee;
    @Size(max = 100)
    @Column(name = "code_Barres")
    private String codeBarres;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bonentree", fetch = FetchType.LAZY)
    private Collection<BonentreeProduit> bonentreeProduitCollection;
    @JoinColumn(name = "IDCommande_fournisseur", referencedColumnName = "IDCommande_fournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Commande iDCommandefournisseur;
    @JoinColumn(name = "IDFacture_Fournisseur", referencedColumnName = "IDFacture_Fournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private FactureFournisseur iDFactureFournisseur;
    @JoinColumn(name = "IDdepot", referencedColumnName = "IDdepot")
    @ManyToOne(fetch = FetchType.LAZY)
    private Depot iDdepot;
    @JoinColumn(name = "IDFournisseur", referencedColumnName = "IDFournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fournisseur iDFournisseur;

    public Bonentree() {
    }

    public Bonentree(Long iDBonEntree) {
        this.iDBonEntree = iDBonEntree;
    }

    public Bonentree(Long iDBonEntree, Date dateHeure) {
        this.iDBonEntree = iDBonEntree;
        this.dateHeure = dateHeure;
    }

    public Long getIDBonEntree() {
        return iDBonEntree;
    }

    public void setIDBonEntree(Long iDBonEntree) {
        this.iDBonEntree = iDBonEntree;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public Short getValidee() {
        return validee;
    }

    public void setValidee(Short validee) {
        this.validee = validee;
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
    public Collection<BonentreeProduit> getBonentreeProduitCollection() {
        return bonentreeProduitCollection;
    }

    public void setBonentreeProduitCollection(Collection<BonentreeProduit> bonentreeProduitCollection) {
        this.bonentreeProduitCollection = bonentreeProduitCollection;
    }

    public Commande getIDCommandefournisseur() {
        return iDCommandefournisseur;
    }

    public void setIDCommandefournisseur(Commande iDCommandefournisseur) {
        this.iDCommandefournisseur = iDCommandefournisseur;
    }

    public FactureFournisseur getIDFactureFournisseur() {
        return iDFactureFournisseur;
    }

    public void setIDFactureFournisseur(FactureFournisseur iDFactureFournisseur) {
        this.iDFactureFournisseur = iDFactureFournisseur;
    }

    public Depot getIDdepot() {
        return iDdepot;
    }

    public void setIDdepot(Depot iDdepot) {
        this.iDdepot = iDdepot;
    }

    public Fournisseur getIDFournisseur() {
        return iDFournisseur;
    }

    public void setIDFournisseur(Fournisseur iDFournisseur) {
        this.iDFournisseur = iDFournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDBonEntree != null ? iDBonEntree.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bonentree)) {
            return false;
        }
        Bonentree other = (Bonentree) object;
        if ((this.iDBonEntree == null && other.iDBonEntree != null) || (this.iDBonEntree != null && !this.iDBonEntree.equals(other.iDBonEntree))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Bonentree[ iDBonEntree=" + iDBonEntree + " ]";
    }
    
}
