/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.test;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "forme_juridique")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormeJuridique.findAll", query = "SELECT f FROM FormeJuridique f"),
    @NamedQuery(name = "FormeJuridique.findByIDFormeJuridique", query = "SELECT f FROM FormeJuridique f WHERE f.iDFormeJuridique = :iDFormeJuridique"),
    @NamedQuery(name = "FormeJuridique.findByLibelle", query = "SELECT f FROM FormeJuridique f WHERE f.libelle = :libelle"),
    @NamedQuery(name = "FormeJuridique.findByDateHeure", query = "SELECT f FROM FormeJuridique f WHERE f.dateHeure = :dateHeure")})
public class FormeJuridique implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Forme_Juridique")
    private Long iDFormeJuridique;
    @Size(max = 20)
    @Column(name = "Libelle")
    private String libelle;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "iDFormeJuridique")
    private Collection<Fournisseur> fournisseurCollection;

    public FormeJuridique() {
    }

    public FormeJuridique(Long iDFormeJuridique) {
        this.iDFormeJuridique = iDFormeJuridique;
    }

    public FormeJuridique(Long iDFormeJuridique, Date dateHeure) {
        this.iDFormeJuridique = iDFormeJuridique;
        this.dateHeure = dateHeure;
    }

    public Long getIDFormeJuridique() {
        return iDFormeJuridique;
    }

    public void setIDFormeJuridique(Long iDFormeJuridique) {
        this.iDFormeJuridique = iDFormeJuridique;
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
        hash += (iDFormeJuridique != null ? iDFormeJuridique.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormeJuridique)) {
            return false;
        }
        FormeJuridique other = (FormeJuridique) object;
        if ((this.iDFormeJuridique == null && other.iDFormeJuridique != null) || (this.iDFormeJuridique != null && !this.iDFormeJuridique.equals(other.iDFormeJuridique))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.FormeJuridique[ iDFormeJuridique=" + iDFormeJuridique + " ]";
    }
    
}
