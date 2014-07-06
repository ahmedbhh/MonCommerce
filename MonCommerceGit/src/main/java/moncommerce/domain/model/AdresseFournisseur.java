/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

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
import javax.persistence.Lob;
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
@Table(name = "adresse_fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdresseFournisseur.findAll", query = "SELECT a FROM AdresseFournisseur a"),
    @NamedQuery(name = "AdresseFournisseur.findByIDAdresseFournisseur", query = "SELECT a FROM AdresseFournisseur a WHERE a.iDAdresseFournisseur = :iDAdresseFournisseur"),
    @NamedQuery(name = "AdresseFournisseur.findByCodePostal", query = "SELECT a FROM AdresseFournisseur a WHERE a.codePostal = :codePostal"),
    @NamedQuery(name = "AdresseFournisseur.findByVille", query = "SELECT a FROM AdresseFournisseur a WHERE a.ville = :ville"),
    @NamedQuery(name = "AdresseFournisseur.findByPays", query = "SELECT a FROM AdresseFournisseur a WHERE a.pays = :pays"),
    @NamedQuery(name = "AdresseFournisseur.findByAdresseemail", query = "SELECT a FROM AdresseFournisseur a WHERE a.adresseemail = :adresseemail"),
    @NamedQuery(name = "AdresseFournisseur.findBySiteInternet", query = "SELECT a FROM AdresseFournisseur a WHERE a.siteInternet = :siteInternet"),
    @NamedQuery(name = "AdresseFournisseur.findByTelephone", query = "SELECT a FROM AdresseFournisseur a WHERE a.telephone = :telephone"),
    @NamedQuery(name = "AdresseFournisseur.findByTelephone2", query = "SELECT a FROM AdresseFournisseur a WHERE a.telephone2 = :telephone2"),
    @NamedQuery(name = "AdresseFournisseur.findByFax", query = "SELECT a FROM AdresseFournisseur a WHERE a.fax = :fax"),
    @NamedQuery(name = "AdresseFournisseur.findByPortable", query = "SELECT a FROM AdresseFournisseur a WHERE a.portable = :portable"),
    @NamedQuery(name = "AdresseFournisseur.findByDateHeure", query = "SELECT a FROM AdresseFournisseur a WHERE a.dateHeure = :dateHeure")})
public class AdresseFournisseur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAdresse_Fournisseur")
    private Long iDAdresseFournisseur;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Adresse_1")
    private String adresse1;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "adresse_2")
    private String adresse2;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "adresse_3")
    private String adresse3;
    @Column(name = "Code_Postal")
    private Integer codePostal;
    @Size(max = 20)
    @Column(name = "Ville")
    private String ville;
    @Size(max = 64)
    @Column(name = "Pays")
    private String pays;
    @Size(max = 50)
    @Column(name = "Adresse_email")
    private String adresseemail;
    @Size(max = 50)
    @Column(name = "Site_Internet")
    private String siteInternet;
    @Column(name = "Telephone")
    private Integer telephone;
    @Column(name = "telephone_2")
    private Integer telephone2;
    @Column(name = "Fax")
    private Integer fax;
    @Column(name = "Portable")
    private Integer portable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @JoinColumn(name = "IDFournisseur", referencedColumnName = "IDFournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Fournisseur iDFournisseur;

    public AdresseFournisseur() {
    }

    public AdresseFournisseur(Long iDAdresseFournisseur) {
        this.iDAdresseFournisseur = iDAdresseFournisseur;
    }

    public AdresseFournisseur(Long iDAdresseFournisseur, Date dateHeure) {
        this.iDAdresseFournisseur = iDAdresseFournisseur;
        this.dateHeure = dateHeure;
    }

    public Long getIDAdresseFournisseur() {
        return iDAdresseFournisseur;
    }

    public void setIDAdresseFournisseur(Long iDAdresseFournisseur) {
        this.iDAdresseFournisseur = iDAdresseFournisseur;
    }

    public String getAdresse1() {
        return adresse1;
    }

    public void setAdresse1(String adresse1) {
        this.adresse1 = adresse1;
    }

    public String getAdresse2() {
        return adresse2;
    }

    public void setAdresse2(String adresse2) {
        this.adresse2 = adresse2;
    }

    public String getAdresse3() {
        return adresse3;
    }

    public void setAdresse3(String adresse3) {
        this.adresse3 = adresse3;
    }

    public Integer getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(Integer codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdresseemail() {
        return adresseemail;
    }

    public void setAdresseemail(String adresseemail) {
        this.adresseemail = adresseemail;
    }

    public String getSiteInternet() {
        return siteInternet;
    }

    public void setSiteInternet(String siteInternet) {
        this.siteInternet = siteInternet;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(Integer telephone2) {
        this.telephone2 = telephone2;
    }

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public Integer getPortable() {
        return portable;
    }

    public void setPortable(Integer portable) {
        this.portable = portable;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public Fournisseur getIDFournisseur() {
        return iDFournisseur;
    }

    public void setIDFournisseur(Fournisseur iDFournisseur) {
        this.iDFournisseur = iDFournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAdresseFournisseur != null ? iDAdresseFournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdresseFournisseur)) {
            return false;
        }
        AdresseFournisseur other = (AdresseFournisseur) object;
        if ((this.iDAdresseFournisseur == null && other.iDAdresseFournisseur != null) || (this.iDAdresseFournisseur != null && !this.iDAdresseFournisseur.equals(other.iDAdresseFournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.AdresseFournisseur[ iDAdresseFournisseur=" + iDAdresseFournisseur + " ]";
    }
    
}
