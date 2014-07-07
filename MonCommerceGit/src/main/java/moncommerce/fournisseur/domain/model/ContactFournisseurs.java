/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.fournisseur.domain.model;

import moncommerce.client.domain.model.TitreContact;
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

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "contact_fournisseurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContactFournisseurs.findAll", query = "SELECT c FROM ContactFournisseurs c"),
    @NamedQuery(name = "ContactFournisseurs.findByIDContactfournisseurs", query = "SELECT c FROM ContactFournisseurs c WHERE c.iDContactfournisseurs = :iDContactfournisseurs"),
    @NamedQuery(name = "ContactFournisseurs.findByNom", query = "SELECT c FROM ContactFournisseurs c WHERE c.nom = :nom"),
    @NamedQuery(name = "ContactFournisseurs.findByPortable", query = "SELECT c FROM ContactFournisseurs c WHERE c.portable = :portable"),
    @NamedQuery(name = "ContactFournisseurs.findByTelephone", query = "SELECT c FROM ContactFournisseurs c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "ContactFournisseurs.findByAdresseemail", query = "SELECT c FROM ContactFournisseurs c WHERE c.adresseemail = :adresseemail"),
    @NamedQuery(name = "ContactFournisseurs.findByDateHeure", query = "SELECT c FROM ContactFournisseurs c WHERE c.dateHeure = :dateHeure")})
public class ContactFournisseurs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDContact_fournisseurs")
    private Long iDContactfournisseurs;
    @Size(max = 50)
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Portable")
    private Integer portable;
    @Column(name = "Telephone")
    private Integer telephone;
    @Size(max = 50)
    @Column(name = "Adresse_email")
    private String adresseemail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @JoinColumn(name = "IDTitre_Contact", referencedColumnName = "IDTitre_Contact")
    @ManyToOne(fetch = FetchType.LAZY)
    private TitreContact iDTitreContact;
    @JoinColumn(name = "IDFournisseur", referencedColumnName = "IDFournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fournisseur iDFournisseur;
    @JoinColumn(name = "IDFonction_Contact", referencedColumnName = "IDFonction_Contact")
    @ManyToOne(fetch = FetchType.LAZY)
    private FonctionContact iDFonctionContact;

    public ContactFournisseurs() {
    }

    public ContactFournisseurs(Long iDContactfournisseurs) {
        this.iDContactfournisseurs = iDContactfournisseurs;
    }

    public ContactFournisseurs(Long iDContactfournisseurs, Date dateHeure) {
        this.iDContactfournisseurs = iDContactfournisseurs;
        this.dateHeure = dateHeure;
    }

    public Long getIDContactfournisseurs() {
        return iDContactfournisseurs;
    }

    public void setIDContactfournisseurs(Long iDContactfournisseurs) {
        this.iDContactfournisseurs = iDContactfournisseurs;
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

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public String getAdresseemail() {
        return adresseemail;
    }

    public void setAdresseemail(String adresseemail) {
        this.adresseemail = adresseemail;
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

    public Fournisseur getIDFournisseur() {
        return iDFournisseur;
    }

    public void setIDFournisseur(Fournisseur iDFournisseur) {
        this.iDFournisseur = iDFournisseur;
    }

    public FonctionContact getIDFonctionContact() {
        return iDFonctionContact;
    }

    public void setIDFonctionContact(FonctionContact iDFonctionContact) {
        this.iDFonctionContact = iDFonctionContact;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDContactfournisseurs != null ? iDContactfournisseurs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactFournisseurs)) {
            return false;
        }
        ContactFournisseurs other = (ContactFournisseurs) object;
        if ((this.iDContactfournisseurs == null && other.iDContactfournisseurs != null) || (this.iDContactfournisseurs != null && !this.iDContactfournisseurs.equals(other.iDContactfournisseurs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.ContactFournisseurs[ iDContactfournisseurs=" + iDContactfournisseurs + " ]";
    }
    
}
