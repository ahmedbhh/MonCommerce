/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.client.domain.model;

import moncommerce.client.domain.model.Client;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import moncommerce.fournisseur.domain.model.FonctionContact;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "contact")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Contact.findAll", query = "SELECT c FROM Contact c"),
    @NamedQuery(name = "Contact.findByIDContact", query = "SELECT c FROM Contact c WHERE c.iDContact = :iDContact"),
    @NamedQuery(name = "Contact.findByNom", query = "SELECT c FROM Contact c WHERE c.nom = :nom"),
    @NamedQuery(name = "Contact.findByPortable", query = "SELECT c FROM Contact c WHERE c.portable = :portable"),
    @NamedQuery(name = "Contact.findByFax", query = "SELECT c FROM Contact c WHERE c.fax = :fax"),
    @NamedQuery(name = "Contact.findByAdresseemail", query = "SELECT c FROM Contact c WHERE c.adresseemail = :adresseemail"),
    @NamedQuery(name = "Contact.findBySkype", query = "SELECT c FROM Contact c WHERE c.skype = :skype"),
    @NamedQuery(name = "Contact.findByPrincipale", query = "SELECT c FROM Contact c WHERE c.principale = :principale"),
    @NamedQuery(name = "Contact.findByDate", query = "SELECT c FROM Contact c WHERE c.date = :date"),
    @NamedQuery(name = "Contact.findByDateHeure", query = "SELECT c FROM Contact c WHERE c.dateHeure = :dateHeure")})
public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDContact")
    private Long iDContact;
    @Size(max = 40)
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Portable")
    private Integer portable;
    @Column(name = "Fax")
    private Integer fax;
    @Size(max = 50)
    @Column(name = "Adresse_email")
    private String adresseemail;
    @Size(max = 50)
    @Column(name = "Skype")
    private String skype;
    @Column(name = "Principale")
    private Short principale;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @JoinColumn(name = "IDTitre_Contact", referencedColumnName = "IDTitre_Contact")
    @ManyToOne(fetch = FetchType.LAZY)
    private TitreContact iDTitreContact;
    @JoinColumn(name = "IDFonction_Contact", referencedColumnName = "IDFonction_Contact")
    @ManyToOne(fetch = FetchType.LAZY)
    private FonctionContact iDFonctionContact;
    @JoinColumn(name = "IDClient", referencedColumnName = "IDClient")
    @ManyToOne(fetch = FetchType.LAZY)
    private Client iDClient;

    public Contact() {
    }

    public Contact(Long iDContact) {
        this.iDContact = iDContact;
    }

    public Contact(Long iDContact, Date dateHeure) {
        this.iDContact = iDContact;
        this.dateHeure = dateHeure;
    }

    public Long getIDContact() {
        return iDContact;
    }

    public void setIDContact(Long iDContact) {
        this.iDContact = iDContact;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPortable() {
        return portable;
    }

    public void setPortable(Integer portable) {
        this.portable = portable;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public String getAdresseemail() {
        return adresseemail;
    }

    public void setAdresseemail(String adresseemail) {
        this.adresseemail = adresseemail;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Short getPrincipale() {
        return principale;
    }

    public void setPrincipale(Short principale) {
        this.principale = principale;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public TitreContact getIDTitreContact() {
        return iDTitreContact;
    }

    public void setIDTitreContact(TitreContact iDTitreContact) {
        this.iDTitreContact = iDTitreContact;
    }

    public FonctionContact getIDFonctionContact() {
        return iDFonctionContact;
    }

    public void setIDFonctionContact(FonctionContact iDFonctionContact) {
        this.iDFonctionContact = iDFonctionContact;
    }

    public Client getIDClient() {
        return iDClient;
    }

    public void setIDClient(Client iDClient) {
        this.iDClient = iDClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDContact != null ? iDContact.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) object;
        if ((this.iDContact == null && other.iDContact != null) || (this.iDContact != null && !this.iDContact.equals(other.iDContact))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Contact[ iDContact=" + iDContact + " ]";
    }
    
}
