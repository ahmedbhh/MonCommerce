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
@Table(name = "famille")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Famille.findAll", query = "SELECT f FROM Famille f"),
    @NamedQuery(name = "Famille.findByIDFamille", query = "SELECT f FROM Famille f WHERE f.iDFamille = :iDFamille"),
    @NamedQuery(name = "Famille.findByLibelle", query = "SELECT f FROM Famille f WHERE f.libelle = :libelle"),
    @NamedQuery(name = "Famille.findByDateHeure", query = "SELECT f FROM Famille f WHERE f.dateHeure = :dateHeure")})
public class Famille implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFamille")
    private Long iDFamille;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "famille", fetch = FetchType.LAZY)
    private Collection<Produit> produitCollection;
    @OneToMany(mappedBy = "famillesup", fetch = FetchType.LAZY)
    private Collection<Sousfamille> sousfamilleCollection;

    public Famille() {
    }

    public Famille(Long iDFamille) {
        this.iDFamille = iDFamille;
    }

    public Famille(Long iDFamille, String libelle, Date dateHeure) {
        this.iDFamille = iDFamille;
        this.libelle = libelle;
        this.dateHeure = dateHeure;
    }

    public Long getIDFamille() {
        return iDFamille;
    }

    public void setIDFamille(Long iDFamille) {
        this.iDFamille = iDFamille;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

    @XmlTransient
    @JsonIgnore
    public Collection<Sousfamille> getSousfamilleCollection() {
        return sousfamilleCollection;
    }

    public void setSousfamilleCollection(Collection<Sousfamille> sousfamilleCollection) {
        this.sousfamilleCollection = sousfamilleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFamille != null ? iDFamille.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Famille)) {
            return false;
        }
        Famille other = (Famille) object;
        if ((this.iDFamille == null && other.iDFamille != null) || (this.iDFamille != null && !this.iDFamille.equals(other.iDFamille))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Famille[ iDFamille=" + iDFamille + " ]";
    }
    
}
