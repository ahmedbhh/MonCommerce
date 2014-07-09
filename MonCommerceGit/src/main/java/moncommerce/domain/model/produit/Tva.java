/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.produit;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "tva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tva.findAll", query = "SELECT t FROM Tva t"),
    @NamedQuery(name = "Tva.findByIdTva", query = "SELECT t FROM Tva t WHERE t.idTva = :idTva"),
    @NamedQuery(name = "Tva.findByTva", query = "SELECT t FROM Tva t WHERE t.tva = :tva"),
    @NamedQuery(name = "Tva.findByLibelle", query = "SELECT t FROM Tva t WHERE t.libelle = :libelle"),
    @NamedQuery(name = "Tva.findByDateHeure", query = "SELECT t FROM Tva t WHERE t.dateHeure = :dateHeure")})
public class Tva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TVA")
    private Long idTva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tva")
    private double tva;
    @Size(max = 20)
    @Column(name = "Libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "tva")
    private Collection<Produit> produitCollection;

    public Tva() {
    }

    public Tva(Long idTva) {
        this.idTva = idTva;
    }

    public Tva(Long idTva, double tva, Date dateHeure) {
        this.idTva = idTva;
        this.tva = tva;
        this.dateHeure = dateHeure;
    }

    public Long getIdTva() {
        return idTva;
    }

    public void setIdTva(Long idTva) {
        this.idTva = idTva;
    }

    public double getTva() {
        return tva;
    }

    public void setTva(double tva) {
        this.tva = tva;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTva != null ? idTva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tva)) {
            return false;
        }
        Tva other = (Tva) object;
        if ((this.idTva == null && other.idTva != null) || (this.idTva != null && !this.idTva.equals(other.idTva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.Tva[ idTva=" + idTva + " ]";
    }
    
}
