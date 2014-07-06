/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "accompte")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accompte.findAll", query = "SELECT a FROM Accompte a"),
    @NamedQuery(name = "Accompte.findByIDAccompte", query = "SELECT a FROM Accompte a WHERE a.iDAccompte = :iDAccompte"),
    @NamedQuery(name = "Accompte.findByDate", query = "SELECT a FROM Accompte a WHERE a.date = :date"),
    @NamedQuery(name = "Accompte.findByMontant", query = "SELECT a FROM Accompte a WHERE a.montant = :montant"),
    @NamedQuery(name = "Accompte.findByDateHeure", query = "SELECT a FROM Accompte a WHERE a.dateHeure = :dateHeure")})
public class Accompte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAccompte")
    private Long iDAccompte;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Montant")
    private BigDecimal montant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @JoinColumn(name = "IDMode_de_reglement", referencedColumnName = "IDMode_de_reglement")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModeDeReglement iDModedereglement;
    @JoinColumn(name = "IDFacture_Fournisseur", referencedColumnName = "IDFacture_Fournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private FactureFournisseur iDFactureFournisseur;
    @JoinColumn(name = "IDCommande_fournisseur", referencedColumnName = "IDCommande_fournisseur")
    @ManyToOne(fetch = FetchType.LAZY)
    private Commande iDCommandefournisseur;

    public Accompte() {
    }

    public Accompte(Long iDAccompte) {
        this.iDAccompte = iDAccompte;
    }

    public Accompte(Long iDAccompte, Date dateHeure) {
        this.iDAccompte = iDAccompte;
        this.dateHeure = dateHeure;
    }

    public Long getIDAccompte() {
        return iDAccompte;
    }

    public void setIDAccompte(Long iDAccompte) {
        this.iDAccompte = iDAccompte;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public ModeDeReglement getIDModedereglement() {
        return iDModedereglement;
    }

    public void setIDModedereglement(ModeDeReglement iDModedereglement) {
        this.iDModedereglement = iDModedereglement;
    }

    public FactureFournisseur getIDFactureFournisseur() {
        return iDFactureFournisseur;
    }

    public void setIDFactureFournisseur(FactureFournisseur iDFactureFournisseur) {
        this.iDFactureFournisseur = iDFactureFournisseur;
    }

    public Commande getIDCommandefournisseur() {
        return iDCommandefournisseur;
    }

    public void setIDCommandefournisseur(Commande iDCommandefournisseur) {
        this.iDCommandefournisseur = iDCommandefournisseur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAccompte != null ? iDAccompte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accompte)) {
            return false;
        }
        Accompte other = (Accompte) object;
        if ((this.iDAccompte == null && other.iDAccompte != null) || (this.iDAccompte != null && !this.iDAccompte.equals(other.iDAccompte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.Accompte[ iDAccompte=" + iDAccompte + " ]";
    }
    
}
