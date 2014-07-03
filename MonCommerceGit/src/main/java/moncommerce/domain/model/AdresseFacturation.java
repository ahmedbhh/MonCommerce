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
@Table(name = "adresse facturation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdresseFacturation.findAll", query = "SELECT a FROM AdresseFacturation a"),
    @NamedQuery(name = "AdresseFacturation.findByIDAdresse", query = "SELECT a FROM AdresseFacturation a WHERE a.iDAdresse = :iDAdresse"),
    @NamedQuery(name = "AdresseFacturation.findByCodePostale", query = "SELECT a FROM AdresseFacturation a WHERE a.codePostale = :codePostale"),
    @NamedQuery(name = "AdresseFacturation.findByVille", query = "SELECT a FROM AdresseFacturation a WHERE a.ville = :ville"),
    @NamedQuery(name = "AdresseFacturation.findByPays", query = "SELECT a FROM AdresseFacturation a WHERE a.pays = :pays"),
    @NamedQuery(name = "AdresseFacturation.findByAdresseemail", query = "SELECT a FROM AdresseFacturation a WHERE a.adresseemail = :adresseemail"),
    @NamedQuery(name = "AdresseFacturation.findBySiteInternet", query = "SELECT a FROM AdresseFacturation a WHERE a.siteInternet = :siteInternet"),
    @NamedQuery(name = "AdresseFacturation.findByTelephone", query = "SELECT a FROM AdresseFacturation a WHERE a.telephone = :telephone"),
    @NamedQuery(name = "AdresseFacturation.findByFax", query = "SELECT a FROM AdresseFacturation a WHERE a.fax = :fax"),
    @NamedQuery(name = "AdresseFacturation.findByTelephone2", query = "SELECT a FROM AdresseFacturation a WHERE a.telephone2 = :telephone2"),
    @NamedQuery(name = "AdresseFacturation.findByPortable", query = "SELECT a FROM AdresseFacturation a WHERE a.portable = :portable"),
    @NamedQuery(name = "AdresseFacturation.findByFormejuridique", query = "SELECT a FROM AdresseFacturation a WHERE a.formejuridique = :formejuridique"),
    @NamedQuery(name = "AdresseFacturation.findByDateHeure", query = "SELECT a FROM AdresseFacturation a WHERE a.dateHeure = :dateHeure")})
public class AdresseFacturation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAdresse", nullable = false)
    private Long iDAdresse;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Adresse", length = 2147483647)
    private String adresse;
    @Size(max = 10)
    @Column(name = "Code_Postale", length = 10)
    private String codePostale;
    @Size(max = 20)
    @Column(name = "Ville", length = 20)
    private String ville;
    @Size(max = 64)
    @Column(name = "Pays", length = 64)
    private String pays;
    @Size(max = 260)
    @Column(name = "Adresse_email", length = 260)
    private String adresseemail;
    @Size(max = 260)
    @Column(name = "Site_Internet", length = 260)
    private String siteInternet;
    @Column(name = "Telephone")
    private Integer telephone;
    @Column(name = "Fax")
    private Integer fax;
    @Column(name = "telephone_2")
    private Integer telephone2;
    @Column(name = "Portable")
    private Integer portable;
    @Size(max = 50)
    @Column(name = "Forme_juridique", length = 50)
    private String formejuridique;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @JoinColumn(name = "IDClient", referencedColumnName = "IDClient")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client iDClient;

    public AdresseFacturation() {
    }

    public AdresseFacturation(Long iDAdresse) {
        this.iDAdresse = iDAdresse;
    }

    public AdresseFacturation(Long iDAdresse, Date dateHeure) {
        this.iDAdresse = iDAdresse;
        this.dateHeure = dateHeure;
    }

    public Long getIDAdresse() {
        return iDAdresse;
    }

    public void setIDAdresse(Long iDAdresse) {
        this.iDAdresse = iDAdresse;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
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

    public Integer getFax() {
        return fax;
    }

    public void setFax(Integer fax) {
        this.fax = fax;
    }

    public Integer getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(Integer telephone2) {
        this.telephone2 = telephone2;
    }

    public Integer getPortable() {
        return portable;
    }

    public void setPortable(Integer portable) {
        this.portable = portable;
    }

    public String getFormejuridique() {
        return formejuridique;
    }

    public void setFormejuridique(String formejuridique) {
        this.formejuridique = formejuridique;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
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
        hash += (iDAdresse != null ? iDAdresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdresseFacturation)) {
            return false;
        }
        AdresseFacturation other = (AdresseFacturation) object;
        if ((this.iDAdresse == null && other.iDAdresse != null) || (this.iDAdresse != null && !this.iDAdresse.equals(other.iDAdresse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.AdresseFacturation[ iDAdresse=" + iDAdresse + " ]";
    }
    
}
