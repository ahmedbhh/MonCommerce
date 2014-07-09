/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

import java.io.Serializable;
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
@Table(name = "bondetransfert")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bondetransfert.findAll", query = "SELECT b FROM Bondetransfert b"),
    @NamedQuery(name = "Bondetransfert.findByIDBonDeTransfert", query = "SELECT b FROM Bondetransfert b WHERE b.iDBonDeTransfert = :iDBonDeTransfert"),
    @NamedQuery(name = "Bondetransfert.findByDate", query = "SELECT b FROM Bondetransfert b WHERE b.date = :date"),
    @NamedQuery(name = "Bondetransfert.findByReferance", query = "SELECT b FROM Bondetransfert b WHERE b.referance = :referance"),
    @NamedQuery(name = "Bondetransfert.findByCodeBarres", query = "SELECT b FROM Bondetransfert b WHERE b.codeBarres = :codeBarres"),
    @NamedQuery(name = "Bondetransfert.findByHeure", query = "SELECT b FROM Bondetransfert b WHERE b.heure = :heure"),
    @NamedQuery(name = "Bondetransfert.findByValidee", query = "SELECT b FROM Bondetransfert b WHERE b.validee = :validee"),
    @NamedQuery(name = "Bondetransfert.findByDateHeure", query = "SELECT b FROM Bondetransfert b WHERE b.dateHeure = :dateHeure")})
public class Bondetransfert implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDBonDeTransfert")
    private Long iDBonDeTransfert;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Size(max = 100)
    @Column(name = "code_Barres")
    private String codeBarres;
    @Column(name = "Heure")
    @Temporal(TemporalType.TIME)
    private Date heure;
    @Column(name = "validee")
    private Short validee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @JoinColumn(name = "ID_depot", referencedColumnName = "ID_depot")
    @ManyToOne
    private Depot iDdepot;
    @JoinColumn(name = "IdDepotRecepteur", referencedColumnName = "ID_depot")
    @ManyToOne
    private Depot idDepotRecepteur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bondetransfert")
    private Collection<BondetransfertProduit> bondetransfertProduitCollection;

    public Bondetransfert() {
    }

    public Bondetransfert(Long iDBonDeTransfert) {
        this.iDBonDeTransfert = iDBonDeTransfert;
    }

    public Bondetransfert(Long iDBonDeTransfert, Date dateHeure) {
        this.iDBonDeTransfert = iDBonDeTransfert;
        this.dateHeure = dateHeure;
    }

    public Long getIDBonDeTransfert() {
        return iDBonDeTransfert;
    }

    public void setIDBonDeTransfert(Long iDBonDeTransfert) {
        this.iDBonDeTransfert = iDBonDeTransfert;
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

    public String getCodeBarres() {
        return codeBarres;
    }

    public void setCodeBarres(String codeBarres) {
        this.codeBarres = codeBarres;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public Short getValidee() {
        return validee;
    }

    public void setValidee(Short validee) {
        this.validee = validee;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public Depot getIDdepot() {
        return iDdepot;
    }

    public void setIDdepot(Depot iDdepot) {
        this.iDdepot = iDdepot;
    }

    public Depot getIdDepotRecepteur() {
        return idDepotRecepteur;
    }

    public void setIdDepotRecepteur(Depot idDepotRecepteur) {
        this.idDepotRecepteur = idDepotRecepteur;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<BondetransfertProduit> getBondetransfertProduitCollection() {
        return bondetransfertProduitCollection;
    }

    public void setBondetransfertProduitCollection(Collection<BondetransfertProduit> bondetransfertProduitCollection) {
        this.bondetransfertProduitCollection = bondetransfertProduitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDBonDeTransfert != null ? iDBonDeTransfert.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bondetransfert)) {
            return false;
        }
        Bondetransfert other = (Bondetransfert) object;
        if ((this.iDBonDeTransfert == null && other.iDBonDeTransfert != null) || (this.iDBonDeTransfert != null && !this.iDBonDeTransfert.equals(other.iDBonDeTransfert))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.Bondetransfert[ iDBonDeTransfert=" + iDBonDeTransfert + " ]";
    }
    
}
