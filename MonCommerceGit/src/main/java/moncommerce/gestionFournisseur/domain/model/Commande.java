/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.gestionFournisseur.domain.model;

import moncommerce.fournisseur.domain.model.Fournisseur;
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
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "commande")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByIDCommandefournisseur", query = "SELECT c FROM Commande c WHERE c.iDCommandefournisseur = :iDCommandefournisseur"),
    @NamedQuery(name = "Commande.findByReferance", query = "SELECT c FROM Commande c WHERE c.referance = :referance"),
    @NamedQuery(name = "Commande.findByDate", query = "SELECT c FROM Commande c WHERE c.date = :date"),
    @NamedQuery(name = "Commande.findByValidee", query = "SELECT c FROM Commande c WHERE c.validee = :validee"),
    @NamedQuery(name = "Commande.findByEcheance", query = "SELECT c FROM Commande c WHERE c.echeance = :echeance"),
    @NamedQuery(name = "Commande.findByDateHeure", query = "SELECT c FROM Commande c WHERE c.dateHeure = :dateHeure"),
    @NamedQuery(name = "Commande.findByRemisetotal", query = "SELECT c FROM Commande c WHERE c.remisetotal = :remisetotal"),
    @NamedQuery(name = "Commande.findByTotalTVA", query = "SELECT c FROM Commande c WHERE c.totalTVA = :totalTVA"),
    @NamedQuery(name = "Commande.findByTotalHT", query = "SELECT c FROM Commande c WHERE c.totalHT = :totalHT"),
    @NamedQuery(name = "Commande.findByTotalttc", query = "SELECT c FROM Commande c WHERE c.totalttc = :totalttc"),
    @NamedQuery(name = "Commande.findBySoldee", query = "SELECT c FROM Commande c WHERE c.soldee = :soldee")})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCommande_fournisseur")
    private Long iDCommandefournisseur;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "validee")
    private Short validee;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Column(name = "echeance")
    @Temporal(TemporalType.DATE)
    private Date echeance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Remise_total")
    private BigDecimal remisetotal;
    @Column(name = "TotalTVA")
    private BigDecimal totalTVA;
    @Column(name = "TotalHT")
    private BigDecimal totalHT;
    @Column(name = "Totalttc")
    private BigDecimal totalttc;
    @Column(name = "soldee")
    private Short soldee;
    @OneToMany(mappedBy = "iDCommandefournisseur", fetch = FetchType.LAZY)
    private Collection<Accompte> accompteCollection;
    @OneToMany(mappedBy = "iDCommandefournisseur", fetch = FetchType.LAZY)
    private Collection<FactureFournisseur> factureFournisseurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande", fetch = FetchType.LAZY)
    private Collection<CommandeProduit> commandeProduitCollection;
    @OneToMany(mappedBy = "iDCommandefournisseur", fetch = FetchType.LAZY)
    private Collection<Bonentree> bonentreeCollection;
    @JoinColumn(name = "IDFournisseur", referencedColumnName = "IDFournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fournisseur iDFournisseur;

    public Commande() {
    }

    public Commande(Long iDCommandefournisseur) {
        this.iDCommandefournisseur = iDCommandefournisseur;
    }

    public Commande(Long iDCommandefournisseur, Date dateHeure) {
        this.iDCommandefournisseur = iDCommandefournisseur;
        this.dateHeure = dateHeure;
    }

    public Long getIDCommandefournisseur() {
        return iDCommandefournisseur;
    }

    public void setIDCommandefournisseur(Long iDCommandefournisseur) {
        this.iDCommandefournisseur = iDCommandefournisseur;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Short getValidee() {
        return validee;
    }

    public void setValidee(Short validee) {
        this.validee = validee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
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

    public BigDecimal getTotalTVA() {
        return totalTVA;
    }

    public void setTotalTVA(BigDecimal totalTVA) {
        this.totalTVA = totalTVA;
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

    public Short getSoldee() {
        return soldee;
    }

    public void setSoldee(Short soldee) {
        this.soldee = soldee;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Accompte> getAccompteCollection() {
        return accompteCollection;
    }

    public void setAccompteCollection(Collection<Accompte> accompteCollection) {
        this.accompteCollection = accompteCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<FactureFournisseur> getFactureFournisseurCollection() {
        return factureFournisseurCollection;
    }

    public void setFactureFournisseurCollection(Collection<FactureFournisseur> factureFournisseurCollection) {
        this.factureFournisseurCollection = factureFournisseurCollection;
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
    public Collection<Bonentree> getBonentreeCollection() {
        return bonentreeCollection;
    }

    public void setBonentreeCollection(Collection<Bonentree> bonentreeCollection) {
        this.bonentreeCollection = bonentreeCollection;
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
        hash += (iDCommandefournisseur != null ? iDCommandefournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.iDCommandefournisseur == null && other.iDCommandefournisseur != null) || (this.iDCommandefournisseur != null && !this.iDCommandefournisseur.equals(other.iDCommandefournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Commande[ iDCommandefournisseur=" + iDCommandefournisseur + " ]";
    }
    
}
