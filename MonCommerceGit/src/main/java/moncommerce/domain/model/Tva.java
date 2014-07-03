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
import javax.persistence.UniqueConstraint;
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
@Table(name = "tva", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"tva"}),
    @UniqueConstraint(columnNames = {"Libelle"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tva.findAll", query = "SELECT t FROM Tva t"),
    @NamedQuery(name = "Tva.findByIdtva", query = "SELECT t FROM Tva t WHERE t.idtva = :idtva"),
    @NamedQuery(name = "Tva.findByTva", query = "SELECT t FROM Tva t WHERE t.tva = :tva"),
    @NamedQuery(name = "Tva.findByLibelle", query = "SELECT t FROM Tva t WHERE t.libelle = :libelle"),
    @NamedQuery(name = "Tva.findByDateHeure", query = "SELECT t FROM Tva t WHERE t.dateHeure = :dateHeure")})
public class Tva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTVA", nullable = false)
    private Long idtva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tva", nullable = false)
    private double tva;
    @Size(max = 20)
    @Column(name = "Libelle", length = 20)
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "tva", fetch = FetchType.EAGER)
    private Collection<Produit> produitCollection;

    public Tva() {
    }

    public Tva(Long idtva) {
        this.idtva = idtva;
    }

    public Tva(Long idtva, double tva, Date dateHeure) {
        this.idtva = idtva;
        this.tva = tva;
        this.dateHeure = dateHeure;
    }

    public Long getIdtva() {
        return idtva;
    }

    public void setIdtva(Long idtva) {
        this.idtva = idtva;
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
        hash += (idtva != null ? idtva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tva)) {
            return false;
        }
        Tva other = (Tva) object;
        if ((this.idtva == null && other.idtva != null) || (this.idtva != null && !this.idtva.equals(other.idtva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Tva[ idtva=" + idtva + " ]";
    }
    
}
