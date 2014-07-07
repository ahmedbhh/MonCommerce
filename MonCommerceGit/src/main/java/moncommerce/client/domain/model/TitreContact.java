/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.client.domain.model;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import moncommerce.fournisseur.domain.model.ContactFournisseurs;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "titre_contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TitreContact.findAll", query = "SELECT t FROM TitreContact t"),
    @NamedQuery(name = "TitreContact.findByIDTitreContact", query = "SELECT t FROM TitreContact t WHERE t.iDTitreContact = :iDTitreContact"),
    @NamedQuery(name = "TitreContact.findByLibelle", query = "SELECT t FROM TitreContact t WHERE t.libelle = :libelle")})
public class TitreContact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTitre_Contact")
    private Long iDTitreContact;
    @Size(max = 20)
    @Column(name = "Libelle")
    private String libelle;
    @OneToMany(mappedBy = "iDTitreContact", fetch = FetchType.LAZY)
    private Collection<Contact> contactCollection;
    @OneToMany(mappedBy = "iDTitreContact", fetch = FetchType.LAZY)
    private Collection<ContactFournisseurs> contactFournisseursCollection;

    public TitreContact() {
    }

    public TitreContact(Long iDTitreContact) {
        this.iDTitreContact = iDTitreContact;
    }

    public Long getIDTitreContact() {
        return iDTitreContact;
    }

    public void setIDTitreContact(Long iDTitreContact) {
        this.iDTitreContact = iDTitreContact;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
        hash += (iDTitreContact != null ? iDTitreContact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TitreContact)) {
            return false;
        }
        TitreContact other = (TitreContact) object;
        if ((this.iDTitreContact == null && other.iDTitreContact != null) || (this.iDTitreContact != null && !this.iDTitreContact.equals(other.iDTitreContact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.TitreContact[ iDTitreContact=" + iDTitreContact + " ]";
    }
    
}
