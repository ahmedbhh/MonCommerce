/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

import moncommerce.gestionFournisseur.domain.model.Bonentree;
import moncommerce.produit.domain.model.ProduitDepot;
import moncommerce.gestionClient.domain.model.Caisse;
import moncommerce.gestionClient.domain.model.Bondesortie;
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
import javax.persistence.Lob;
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
@Table(name = "depot")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Depot.findAll", query = "SELECT d FROM Depot d"),
    @NamedQuery(name = "Depot.findByIDdepot", query = "SELECT d FROM Depot d WHERE d.iDdepot = :iDdepot"),
    @NamedQuery(name = "Depot.findByReferance", query = "SELECT d FROM Depot d WHERE d.referance = :referance"),
    @NamedQuery(name = "Depot.findByFax", query = "SELECT d FROM Depot d WHERE d.fax = :fax"),
    @NamedQuery(name = "Depot.findByTelephone", query = "SELECT d FROM Depot d WHERE d.telephone = :telephone"),
    @NamedQuery(name = "Depot.findBySurface", query = "SELECT d FROM Depot d WHERE d.surface = :surface"),
    @NamedQuery(name = "Depot.findByCoutLoyer", query = "SELECT d FROM Depot d WHERE d.coutLoyer = :coutLoyer"),
    @NamedQuery(name = "Depot.findByAutreCharge", query = "SELECT d FROM Depot d WHERE d.autreCharge = :autreCharge"),
    @NamedQuery(name = "Depot.findByDateHeure", query = "SELECT d FROM Depot d WHERE d.dateHeure = :dateHeure")})
public class Depot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDdepot")
    private Long iDdepot;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "Fax")
    private Integer fax;
    @Column(name = "Telephone")
    private Integer telephone;
    @Column(name = "Surface")
    private Integer surface;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coutLoyer")
    private BigDecimal coutLoyer;
    @Column(name = "autre_charge")
    private BigDecimal autreCharge;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "idDepotRecepteur", fetch = FetchType.LAZY)
    private Collection<Bondetransfert> bondetransfertCollection;
    @OneToMany(mappedBy = "iDdepot", fetch = FetchType.LAZY)
    private Collection<Bondetransfert> bondetransfertCollection1;
    @OneToMany(mappedBy = "iDdepot", fetch = FetchType.LAZY)
    private Collection<Caisse> caisseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "depot", fetch = FetchType.LAZY)
    private Collection<ProduitDepot> produitDepotCollection;
    @OneToMany(mappedBy = "iDdepot", fetch = FetchType.LAZY)
    private Collection<Bonentree> bonentreeCollection;
    @OneToMany(mappedBy = "iDdepot", fetch = FetchType.LAZY)
    private Collection<Bondesortie> bondesortieCollection;

    public Depot() {
    }

    public Depot(Long iDdepot) {
        this.iDdepot = iDdepot;
    }

    public Depot(Long iDdepot, Date dateHeure) {
        this.iDdepot = iDdepot;
        this.dateHeure = dateHeure;
    }

    public Long getIDdepot() {
        return iDdepot;
    }

    public void setIDdepot(Long iDdepot) {
        this.iDdepot = iDdepot;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getSurface() {
        return surface;
    }

    public void setSurface(Integer surface) {
        this.surface = surface;
    }

    public BigDecimal getCoutLoyer() {
        return coutLoyer;
    }

    public void setCoutLoyer(BigDecimal coutLoyer) {
        this.coutLoyer = coutLoyer;
    }

    public BigDecimal getAutreCharge() {
        return autreCharge;
    }

    public void setAutreCharge(BigDecimal autreCharge) {
        this.autreCharge = autreCharge;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Bondetransfert> getBondetransfertCollection() {
        return bondetransfertCollection;
    }

    public void setBondetransfertCollection(Collection<Bondetransfert> bondetransfertCollection) {
        this.bondetransfertCollection = bondetransfertCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Bondetransfert> getBondetransfertCollection1() {
        return bondetransfertCollection1;
    }

    public void setBondetransfertCollection1(Collection<Bondetransfert> bondetransfertCollection1) {
        this.bondetransfertCollection1 = bondetransfertCollection1;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Caisse> getCaisseCollection() {
        return caisseCollection;
    }

    public void setCaisseCollection(Collection<Caisse> caisseCollection) {
        this.caisseCollection = caisseCollection;
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
    public Collection<Bonentree> getBonentreeCollection() {
        return bonentreeCollection;
    }

    public void setBonentreeCollection(Collection<Bonentree> bonentreeCollection) {
        this.bonentreeCollection = bonentreeCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Bondesortie> getBondesortieCollection() {
        return bondesortieCollection;
    }

    public void setBondesortieCollection(Collection<Bondesortie> bondesortieCollection) {
        this.bondesortieCollection = bondesortieCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDdepot != null ? iDdepot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) object;
        if ((this.iDdepot == null && other.iDdepot != null) || (this.iDdepot != null && !this.iDdepot.equals(other.iDdepot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Depot[ iDdepot=" + iDdepot + " ]";
    }
    
}
