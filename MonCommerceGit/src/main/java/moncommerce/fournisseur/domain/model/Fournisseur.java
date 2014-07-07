/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.fournisseur.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import moncommerce.gestionFournisseur.domain.model.Bonentree;
import moncommerce.gestionFournisseur.domain.model.Commande;
import moncommerce.gestionFournisseur.domain.model.FactureFournisseur;
import moncommerce.gestionFournisseur.domain.model.ReglementFournisseurs;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "fournisseur")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f"),
    @NamedQuery(name = "Fournisseur.findByIDFournisseur", query = "SELECT f FROM Fournisseur f WHERE f.iDFournisseur = :iDFournisseur"),
    @NamedQuery(name = "Fournisseur.findByNom", query = "SELECT f FROM Fournisseur f WHERE f.nom = :nom"),
    @NamedQuery(name = "Fournisseur.findByCreditAccorde", query = "SELECT f FROM Fournisseur f WHERE f.creditAccorde = :creditAccorde"),
    @NamedQuery(name = "Fournisseur.findByRisque", query = "SELECT f FROM Fournisseur f WHERE f.risque = :risque"),
    @NamedQuery(name = "Fournisseur.findByDateHeure", query = "SELECT f FROM Fournisseur f WHERE f.dateHeure = :dateHeure"),
    @NamedQuery(name = "Fournisseur.findByMatriculefiscale", query = "SELECT f FROM Fournisseur f WHERE f.matriculefiscale = :matriculefiscale")})
public class Fournisseur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFournisseur")
    private Long iDFournisseur;
    @Size(max = 50)
    @Column(name = "Nom")
    private String nom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Credit_Accorde")
    private BigDecimal creditAccorde;
    @Size(max = 50)
    @Column(name = "Risque")
    private String risque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Size(max = 30)
    @Column(name = "Matricule_fiscale")
    private String matriculefiscale;
    @OneToMany(mappedBy = "iDFournisseur", fetch = FetchType.LAZY)
    private Collection<AdresseFournisseur> adresseFournisseurCollection;
    @OneToMany(mappedBy = "iDFournisseur", fetch = FetchType.LAZY)
    private Collection<ContactFournisseurs> contactFournisseursCollection;
    @OneToMany(mappedBy = "iDFournisseur", fetch = FetchType.LAZY)
    private Collection<ReglementFournisseurs> reglementFournisseursCollection;
    @OneToMany(mappedBy = "iDFournisseur", fetch = FetchType.LAZY)
    private Collection<FactureFournisseur> factureFournisseurCollection;
    @JoinColumn(name = "IDFamille_Fournisseur", referencedColumnName = "IDFamille_Fournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private FamilleFournisseur iDFamilleFournisseur;
    @JoinColumn(name = "IDForme_Juridique", referencedColumnName = "IDForme_Juridique")
    @ManyToOne(fetch = FetchType.LAZY)
    private FormeJuridique iDFormeJuridique;
    @OneToMany(mappedBy = "iDFournisseur", fetch = FetchType.LAZY)
    private Collection<Bonentree> bonentreeCollection;
    @OneToMany(mappedBy = "iDFournisseur", fetch = FetchType.LAZY)
    private Collection<Commande> commandeCollection;

    public Fournisseur() {
    }

    public Fournisseur(Long iDFournisseur) {
        this.iDFournisseur = iDFournisseur;
    }

    public Fournisseur(Long iDFournisseur, Date dateHeure) {
        this.iDFournisseur = iDFournisseur;
        this.dateHeure = dateHeure;
    }

    public Long getIDFournisseur() {
        return iDFournisseur;
    }

    public void setIDFournisseur(Long iDFournisseur) {
        this.iDFournisseur = iDFournisseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public BigDecimal getCreditAccorde() {
        return creditAccorde;
    }

    public void setCreditAccorde(BigDecimal creditAccorde) {
        this.creditAccorde = creditAccorde;
    }

    public String getRisque() {
        return risque;
    }

    public void setRisque(String risque) {
        this.risque = risque;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getMatriculefiscale() {
        return matriculefiscale;
    }

    public void setMatriculefiscale(String matriculefiscale) {
        this.matriculefiscale = matriculefiscale;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AdresseFournisseur> getAdresseFournisseurCollection() {
        return adresseFournisseurCollection;
    }

    public void setAdresseFournisseurCollection(Collection<AdresseFournisseur> adresseFournisseurCollection) {
        this.adresseFournisseurCollection = adresseFournisseurCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ContactFournisseurs> getContactFournisseursCollection() {
        return contactFournisseursCollection;
    }

    public void setContactFournisseursCollection(Collection<ContactFournisseurs> contactFournisseursCollection) {
        this.contactFournisseursCollection = contactFournisseursCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ReglementFournisseurs> getReglementFournisseursCollection() {
        return reglementFournisseursCollection;
    }

    public void setReglementFournisseursCollection(Collection<ReglementFournisseurs> reglementFournisseursCollection) {
        this.reglementFournisseursCollection = reglementFournisseursCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<FactureFournisseur> getFactureFournisseurCollection() {
        return factureFournisseurCollection;
    }

    public void setFactureFournisseurCollection(Collection<FactureFournisseur> factureFournisseurCollection) {
        this.factureFournisseurCollection = factureFournisseurCollection;
    }

    public FamilleFournisseur getIDFamilleFournisseur() {
        return iDFamilleFournisseur;
    }

    public void setIDFamilleFournisseur(FamilleFournisseur iDFamilleFournisseur) {
        this.iDFamilleFournisseur = iDFamilleFournisseur;
    }

    public FormeJuridique getIDFormeJuridique() {
        return iDFormeJuridique;
    }

    public void setIDFormeJuridique(FormeJuridique iDFormeJuridique) {
        this.iDFormeJuridique = iDFormeJuridique;
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
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFournisseur != null ? iDFournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.iDFournisseur == null && other.iDFournisseur != null) || (this.iDFournisseur != null && !this.iDFournisseur.equals(other.iDFournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Fournisseur[ iDFournisseur=" + iDFournisseur + " ]";
    }
    
}
