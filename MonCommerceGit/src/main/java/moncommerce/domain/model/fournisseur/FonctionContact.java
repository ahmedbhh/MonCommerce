/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.fournisseur;

import moncommerce.domain.model.client.Contact;
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
@Table(name = "fonction_contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FonctionContact.findAll", query = "SELECT f FROM FonctionContact f"),
    @NamedQuery(name = "FonctionContact.findByIDFonctionContact", query = "SELECT f FROM FonctionContact f WHERE f.iDFonctionContact = :iDFonctionContact"),
    @NamedQuery(name = "FonctionContact.findByLibelle", query = "SELECT f FROM FonctionContact f WHERE f.libelle = :libelle"),
    @NamedQuery(name = "FonctionContact.findByDateHeure", query = "SELECT f FROM FonctionContact f WHERE f.dateHeure = :dateHeure")})
public class FonctionContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Fonction_Contact")
    private Long iDFonctionContact;
    @Size(max = 20)
    @Column(name = "Libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "iDFonctionContact")
    private Collection<Contact> contactCollection;
    @OneToMany(mappedBy = "iDFonctionContact")
    private Collection<ContactFournisseurs> contactFournisseursCollection;

    public FonctionContact() {
    }

    public FonctionContact(Long iDFonctionContact) {
        this.iDFonctionContact = iDFonctionContact;
    }

    public FonctionContact(Long iDFonctionContact, Date dateHeure) {
        this.iDFonctionContact = iDFonctionContact;
        this.dateHeure = dateHeure;
    }

    public Long getIDFonctionContact() {
        return iDFonctionContact;
    }

    public void setIDFonctionContact(Long iDFonctionContact) {
        this.iDFonctionContact = iDFonctionContact;
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
    public Collection<Contact> getContactCollection() {
        return contactCollection;
    }

    public void setContactCollection(Collection<Contact> contactCollection) {
        this.contactCollection = contactCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ContactFournisseurs> getContactFournisseursCollection() {
        return contactFournisseursCollection;
    }

    public void setContactFournisseursCollection(Collection<ContactFournisseurs> contactFournisseursCollection) {
        this.contactFournisseursCollection = contactFournisseursCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFonctionContact != null ? iDFonctionContact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FonctionContact)) {
            return false;
        }
        FonctionContact other = (FonctionContact) object;
        if ((this.iDFonctionContact == null && other.iDFonctionContact != null) || (this.iDFonctionContact != null && !this.iDFonctionContact.equals(other.iDFonctionContact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.FonctionContact[ iDFonctionContact=" + iDFonctionContact + " ]";
    }
    
}
