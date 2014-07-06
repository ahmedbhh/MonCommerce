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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "uniteemesure")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uniteemesure.findAll", query = "SELECT u FROM Uniteemesure u"),
    @NamedQuery(name = "Uniteemesure.findByIDUniteeMesure", query = "SELECT u FROM Uniteemesure u WHERE u.iDUniteeMesure = :iDUniteeMesure"),
    @NamedQuery(name = "Uniteemesure.findByUnitee", query = "SELECT u FROM Uniteemesure u WHERE u.unitee = :unitee"),
    @NamedQuery(name = "Uniteemesure.findByDateHeure", query = "SELECT u FROM Uniteemesure u WHERE u.dateHeure = :dateHeure")})
public class Uniteemesure implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDUniteeMesure")
    private Long iDUniteeMesure;
    @Size(max = 20)
    @Column(name = "Unitee")
    private String unitee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "iDUniteeMesure", fetch = FetchType.LAZY)
    private Collection<Produit> produitCollection;

    public Uniteemesure() {
    }

    public Uniteemesure(Long iDUniteeMesure) {
        this.iDUniteeMesure = iDUniteeMesure;
    }

    public Uniteemesure(Long iDUniteeMesure, Date dateHeure) {
        this.iDUniteeMesure = iDUniteeMesure;
        this.dateHeure = dateHeure;
    }

    public Long getIDUniteeMesure() {
        return iDUniteeMesure;
    }

    public void setIDUniteeMesure(Long iDUniteeMesure) {
        this.iDUniteeMesure = iDUniteeMesure;
    }

    public String getUnitee() {
        return unitee;
    }

    public void setUnitee(String unitee) {
        this.unitee = unitee;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDUniteeMesure != null ? iDUniteeMesure.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Uniteemesure)) {
            return false;
        }
        Uniteemesure other = (Uniteemesure) object;
        if ((this.iDUniteeMesure == null && other.iDUniteeMesure != null) || (this.iDUniteeMesure != null && !this.iDUniteeMesure.equals(other.iDUniteeMesure))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Uniteemesure[ iDUniteeMesure=" + iDUniteeMesure + " ]";
    }
    
}
