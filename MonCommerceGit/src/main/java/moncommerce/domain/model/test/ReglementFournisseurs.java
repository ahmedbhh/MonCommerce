/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "reglement_fournisseurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReglementFournisseurs.findAll", query = "SELECT r FROM ReglementFournisseurs r"),
    @NamedQuery(name = "ReglementFournisseurs.findByIDReglementfournisseurs", query = "SELECT r FROM ReglementFournisseurs r WHERE r.iDReglementfournisseurs = :iDReglementfournisseurs"),
    @NamedQuery(name = "ReglementFournisseurs.findByDate", query = "SELECT r FROM ReglementFournisseurs r WHERE r.date = :date"),
    @NamedQuery(name = "ReglementFournisseurs.findByDateHeure", query = "SELECT r FROM ReglementFournisseurs r WHERE r.dateHeure = :dateHeure"),
    @NamedQuery(name = "ReglementFournisseurs.findByMontant", query = "SELECT r FROM ReglementFournisseurs r WHERE r.montant = :montant"),
    @NamedQuery(name = "ReglementFournisseurs.findByValidee", query = "SELECT r FROM ReglementFournisseurs r WHERE r.validee = :validee"),
    @NamedQuery(name = "ReglementFournisseurs.findByReferance", query = "SELECT r FROM ReglementFournisseurs r WHERE r.referance = :referance"),
    @NamedQuery(name = "ReglementFournisseurs.findByEscompte", query = "SELECT r FROM ReglementFournisseurs r WHERE r.escompte = :escompte")})
public class ReglementFournisseurs implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Reglement_fournisseurs")
    private Long iDReglementfournisseurs;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Montant")
    private BigDecimal montant;
    @Column(name = "validee")
    private Short validee;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Column(name = "Escompte")
    private BigDecimal escompte;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reglementFournisseurs")
    private Collection<FactureFournisseurReglementFournisseurs> factureFournisseurReglementFournisseursCollection;
    @JoinColumn(name = "ID_Fournisseur", referencedColumnName = "ID_Fournisseur")
    @ManyToOne
    private Fournisseur iDFournisseur;
    @JoinColumn(name = "ID_Mode_de_reglement", referencedColumnName = "ID_Mode_de_reglement")
    @ManyToOne
    private ModeDeReglement iDModedereglement;

    public ReglementFournisseurs() {
    }

    public ReglementFournisseurs(Long iDReglementfournisseurs) {
        this.iDReglementfournisseurs = iDReglementfournisseurs;
    }

    public ReglementFournisseurs(Long iDReglementfournisseurs, Date dateHeure) {
        this.iDReglementfournisseurs = iDReglementfournisseurs;
        this.dateHeure = dateHeure;
    }

    public Long getIDReglementfournisseurs() {
        return iDReglementfournisseurs;
    }

    public void setIDReglementfournisseurs(Long iDReglementfournisseurs) {
        this.iDReglementfournisseurs = iDReglementfournisseurs;
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

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Short getValidee() {
        return validee;
    }

    public void setValidee(Short validee) {
        this.validee = validee;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public BigDecimal getEscompte() {
        return escompte;
    }

    public void setEscompte(BigDecimal escompte) {
        this.escompte = escompte;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<FactureFournisseurReglementFournisseurs> getFactureFournisseurReglementFournisseursCollection() {
        return factureFournisseurReglementFournisseursCollection;
    }

    public void setFactureFournisseurReglementFournisseursCollection(Collection<FactureFournisseurReglementFournisseurs> factureFournisseurReglementFournisseursCollection) {
        this.factureFournisseurReglementFournisseursCollection = factureFournisseurReglementFournisseursCollection;
    }

    public Fournisseur getIDFournisseur() {
        return iDFournisseur;
    }

    public void setIDFournisseur(Fournisseur iDFournisseur) {
        this.iDFournisseur = iDFournisseur;
    }

    public ModeDeReglement getIDModedereglement() {
        return iDModedereglement;
    }

    public void setIDModedereglement(ModeDeReglement iDModedereglement) {
        this.iDModedereglement = iDModedereglement;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDReglementfournisseurs != null ? iDReglementfournisseurs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReglementFournisseurs)) {
            return false;
        }
        ReglementFournisseurs other = (ReglementFournisseurs) object;
        if ((this.iDReglementfournisseurs == null && other.iDReglementfournisseurs != null) || (this.iDReglementfournisseurs != null && !this.iDReglementfournisseurs.equals(other.iDReglementfournisseurs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.ReglementFournisseurs[ iDReglementfournisseurs=" + iDReglementfournisseurs + " ]";
    }
    
}
