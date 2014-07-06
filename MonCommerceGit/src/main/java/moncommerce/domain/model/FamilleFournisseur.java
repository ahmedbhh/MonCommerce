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
@Table(name = "famille_fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamilleFournisseur.findAll", query = "SELECT f FROM FamilleFournisseur f"),
    @NamedQuery(name = "FamilleFournisseur.findByIDFamilleFournisseur", query = "SELECT f FROM FamilleFournisseur f WHERE f.iDFamilleFournisseur = :iDFamilleFournisseur"),
    @NamedQuery(name = "FamilleFournisseur.findByLibelle", query = "SELECT f FROM FamilleFournisseur f WHERE f.libelle = :libelle"),
    @NamedQuery(name = "FamilleFournisseur.findByDateHeure", query = "SELECT f FROM FamilleFournisseur f WHERE f.dateHeure = :dateHeure")})
public class FamilleFournisseur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFamille_Fournisseur")
    private Long iDFamilleFournisseur;
    @Size(max = 20)
    @Column(name = "Libelle")
    private String libelle;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "iDFamilleFournisseur", fetch = FetchType.LAZY)
    private Collection<Fournisseur> fournisseurCollection;

    public FamilleFournisseur() {
    }

    public FamilleFournisseur(Long iDFamilleFournisseur) {
        this.iDFamilleFournisseur = iDFamilleFournisseur;
    }

    public FamilleFournisseur(Long iDFamilleFournisseur, Date dateHeure) {
        this.iDFamilleFournisseur = iDFamilleFournisseur;
        this.dateHeure = dateHeure;
    }

    public Long getIDFamilleFournisseur() {
        return iDFamilleFournisseur;
    }

    public void setIDFamilleFournisseur(Long iDFamilleFournisseur) {
        this.iDFamilleFournisseur = iDFamilleFournisseur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Fournisseur> getFournisseurCollection() {
        return fournisseurCollection;
    }

    public void setFournisseurCollection(Collection<Fournisseur> fournisseurCollection) {
        this.fournisseurCollection = fournisseurCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFamilleFournisseur != null ? iDFamilleFournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamilleFournisseur)) {
            return false;
        }
        FamilleFournisseur other = (FamilleFournisseur) object;
        if ((this.iDFamilleFournisseur == null && other.iDFamilleFournisseur != null) || (this.iDFamilleFournisseur != null && !this.iDFamilleFournisseur.equals(other.iDFamilleFournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.FamilleFournisseur[ iDFamilleFournisseur=" + iDFamilleFournisseur + " ]";
    }
    
}
