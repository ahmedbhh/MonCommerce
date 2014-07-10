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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findByIDemployee", query = "SELECT e FROM Employee e WHERE e.iDemployee = :iDemployee"),
    @NamedQuery(name = "Employee.findByNom", query = "SELECT e FROM Employee e WHERE e.nom = :nom"),
    @NamedQuery(name = "Employee.findByPrenom", query = "SELECT e FROM Employee e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Employee.findByDateNaissance", query = "SELECT e FROM Employee e WHERE e.dateNaissance = :dateNaissance"),
    @NamedQuery(name = "Employee.findByDateentreeentreprise", query = "SELECT e FROM Employee e WHERE e.dateentreeentreprise = :dateentreeentreprise")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDemployee")
    private Integer iDemployee;
    @Size(max = 20)
    @Column(name = "Nom")
    private String nom;
    @Size(max = 20)
    @Column(name = "Prenom")
    private String prenom;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "Date_entree_entreprise")
    @Temporal(TemporalType.DATE)
    private Date dateentreeentreprise;
    @OneToMany(mappedBy = "iDemployee")
    private Collection<FactureFournisseur> factureFournisseurCollection;
    @OneToMany(mappedBy = "iDemployee")
    private Collection<Bonentree> bonentreeCollection;
    @OneToMany(mappedBy = "iDemployee")
    private Collection<Bondesortie> bondesortieCollection;
    @OneToMany(mappedBy = "iDemployee")
    private Collection<FactureClients> factureClientsCollection;

    public Employee() {
    }

    public Employee(Integer iDemployee) {
        this.iDemployee = iDemployee;
    }

    public Integer getIDemployee() {
        return iDemployee;
    }

    public void setIDemployee(Integer iDemployee) {
        this.iDemployee = iDemployee;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Date getDateentreeentreprise() {
        return dateentreeentreprise;
    }

    public void setDateentreeentreprise(Date dateentreeentreprise) {
        this.dateentreeentreprise = dateentreeentreprise;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<FactureFournisseur> getFactureFournisseurCollection() {
        return factureFournisseurCollection;
    }

    public void setFactureFournisseurCollection(Collection<FactureFournisseur> factureFournisseurCollection) {
        this.factureFournisseurCollection = factureFournisseurCollection;
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
        hash += (iDemployee != null ? iDemployee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.iDemployee == null && other.iDemployee != null) || (this.iDemployee != null && !this.iDemployee.equals(other.iDemployee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.Employee[ iDemployee=" + iDemployee + " ]";
    }
    
}
