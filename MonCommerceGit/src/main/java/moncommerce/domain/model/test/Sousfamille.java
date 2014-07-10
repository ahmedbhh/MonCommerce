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
@Table(name = "sousfamille")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sousfamille.findAll", query = "SELECT s FROM Sousfamille s"),
    @NamedQuery(name = "Sousfamille.findByLibelle", query = "SELECT s FROM Sousfamille s WHERE s.libelle = :libelle"),
    @NamedQuery(name = "Sousfamille.findByDateHeure", query = "SELECT s FROM Sousfamille s WHERE s.dateHeure = :dateHeure")})
public class Sousfamille implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "sousfamille")
    private Collection<Produit> produitCollection;
    @JoinColumn(name = "Famille_sup", referencedColumnName = "Libelle")
    @ManyToOne
    private Famille famillesup;

    public Sousfamille() {
    }

    public Sousfamille(String libelle) {
        this.libelle = libelle;
    }

    public Sousfamille(String libelle, Date dateHeure) {
        this.libelle = libelle;
        this.dateHeure = dateHeure;
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

    public Famille getFamillesup() {
        return famillesup;
    }

    public void setFamillesup(Famille famillesup) {
        this.famillesup = famillesup;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libelle != null ? libelle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sousfamille)) {
            return false;
        }
        Sousfamille other = (Sousfamille) object;
        if ((this.libelle == null && other.libelle != null) || (this.libelle != null && !this.libelle.equals(other.libelle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.Sousfamille[ libelle=" + libelle + " ]";
    }
    
}
