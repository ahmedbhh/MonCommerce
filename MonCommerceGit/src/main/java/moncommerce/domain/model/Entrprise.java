/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "entrprise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entrprise.findAll", query = "SELECT e FROM Entrprise e"),
    @NamedQuery(name = "Entrprise.findByIDEntrprise", query = "SELECT e FROM Entrprise e WHERE e.iDEntrprise = :iDEntrprise"),
    @NamedQuery(name = "Entrprise.findByNom", query = "SELECT e FROM Entrprise e WHERE e.nom = :nom"),
    @NamedQuery(name = "Entrprise.findByTelephone", query = "SELECT e FROM Entrprise e WHERE e.telephone = :telephone"),
    @NamedQuery(name = "Entrprise.findByFax", query = "SELECT e FROM Entrprise e WHERE e.fax = :fax"),
    @NamedQuery(name = "Entrprise.findBySlogan", query = "SELECT e FROM Entrprise e WHERE e.slogan = :slogan"),
    @NamedQuery(name = "Entrprise.findByEmail", query = "SELECT e FROM Entrprise e WHERE e.email = :email"),
    @NamedQuery(name = "Entrprise.findByCodePostal", query = "SELECT e FROM Entrprise e WHERE e.codePostal = :codePostal"),
    @NamedQuery(name = "Entrprise.findByVille", query = "SELECT e FROM Entrprise e WHERE e.ville = :ville"),
    @NamedQuery(name = "Entrprise.findByPays", query = "SELECT e FROM Entrprise e WHERE e.pays = :pays"),
    @NamedQuery(name = "Entrprise.findByMatriculefiscale", query = "SELECT e FROM Entrprise e WHERE e.matriculefiscale = :matriculefiscale")})
public class Entrprise implements Serializable {
    @Lob
    @Column(name = "logo")
    private byte[] logo;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDEntrprise")
    private Long iDEntrprise;
    @Size(max = 50)
    @Column(name = "Nom")
    private String nom;
    @Column(name = "Telephone")
    private Integer telephone;
    @Column(name = "Fax")
    private Integer fax;
    @Size(max = 50)
    @Column(name = "slogan")
    private String slogan;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Adresse")
    private String adresse;
    @Column(name = "Code_Postal")
    private Integer codePostal;
    @Size(max = 20)
    @Column(name = "Ville")
    private String ville;
    @Size(max = 64)
    @Column(name = "Pays")
    private String pays;
    @Size(max = 30)
    @Column(name = "Matricule_fiscale")
    private String matriculefiscale;

    public Entrprise() {
    }

    public Entrprise(Long iDEntrprise) {
        this.iDEntrprise = iDEntrprise;
    }

    public Long getIDEntrprise() {
        return iDEntrprise;
    }

    public void setIDEntrprise(Long iDEntrprise) {
        this.iDEntrprise = iDEntrprise;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public String getMatriculefiscale() {
        return matriculefiscale;
    }

    public void setMatriculefiscale(String matriculefiscale) {
        this.matriculefiscale = matriculefiscale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDEntrprise != null ? iDEntrprise.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entrprise)) {
            return false;
        }
        Entrprise other = (Entrprise) object;
        if ((this.iDEntrprise == null && other.iDEntrprise != null) || (this.iDEntrprise != null && !this.iDEntrprise.equals(other.iDEntrprise))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Entrprise[ iDEntrprise=" + iDEntrprise + " ]";
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    
}
