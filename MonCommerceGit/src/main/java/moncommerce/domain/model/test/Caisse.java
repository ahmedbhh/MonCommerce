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
@Table(name = "caisse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caisse.findAll", query = "SELECT c FROM Caisse c"),
    @NamedQuery(name = "Caisse.findByIDCaisse", query = "SELECT c FROM Caisse c WHERE c.iDCaisse = :iDCaisse"),
    @NamedQuery(name = "Caisse.findByLibelle", query = "SELECT c FROM Caisse c WHERE c.libelle = :libelle"),
    @NamedQuery(name = "Caisse.findByDateHeure", query = "SELECT c FROM Caisse c WHERE c.dateHeure = :dateHeure")})
public class Caisse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Caisse")
    private Long iDCaisse;
    @Size(max = 20)
    @Column(name = "Libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @JoinColumn(name = "ID_depot", referencedColumnName = "ID_depot")
    @ManyToOne
    private Depot iDdepot;
    @OneToMany(mappedBy = "iDCaisse")
    private Collection<FactureClients> factureClientsCollection;

    public Caisse() {
    }

    public Caisse(Long iDCaisse) {
        this.iDCaisse = iDCaisse;
    }

    public Caisse(Long iDCaisse, Date dateHeure) {
        this.iDCaisse = iDCaisse;
        this.dateHeure = dateHeure;
    }

    public Long getIDCaisse() {
        return iDCaisse;
    }

    public void setIDCaisse(Long iDCaisse) {
        this.iDCaisse = iDCaisse;
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

    public Depot getIDdepot() {
        return iDdepot;
    }

    public void setIDdepot(Depot iDdepot) {
        this.iDdepot = iDdepot;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<FactureClients> getFactureClientsCollection() {
        return factureClientsCollection;
    }

    public void setFactureClientsCollection(Collection<FactureClients> factureClientsCollection) {
        this.factureClientsCollection = factureClientsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCaisse != null ? iDCaisse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caisse)) {
            return false;
        }
        Caisse other = (Caisse) object;
        if ((this.iDCaisse == null && other.iDCaisse != null) || (this.iDCaisse != null && !this.iDCaisse.equals(other.iDCaisse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.Caisse[ iDCaisse=" + iDCaisse + " ]";
    }
    
}
