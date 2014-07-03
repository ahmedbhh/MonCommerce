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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "produit_code_tarif")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProduitCodeTarif.findAll", query = "SELECT p FROM ProduitCodeTarif p"),
    @NamedQuery(name = "ProduitCodeTarif.findByIDCodetarif", query = "SELECT p FROM ProduitCodeTarif p WHERE p.produitCodeTarifPK.iDCodetarif = :iDCodetarif"),
    @NamedQuery(name = "ProduitCodeTarif.findByIDProduit", query = "SELECT p FROM ProduitCodeTarif p WHERE p.produitCodeTarifPK.iDProduit = :iDProduit"),
    @NamedQuery(name = "ProduitCodeTarif.findByPrixVente", query = "SELECT p FROM ProduitCodeTarif p WHERE p.prixVente = :prixVente"),
    @NamedQuery(name = "ProduitCodeTarif.findByQuantitee", query = "SELECT p FROM ProduitCodeTarif p WHERE p.quantitee = :quantitee"),
    @NamedQuery(name = "ProduitCodeTarif.findByDateHeure", query = "SELECT p FROM ProduitCodeTarif p WHERE p.dateHeure = :dateHeure")})
public class ProduitCodeTarif implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProduitCodeTarifPK produitCodeTarifPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PrixVente", nullable = false, precision = 24, scale = 6)
    private BigDecimal prixVente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantitee", nullable = false)
    private long quantitee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @JoinColumn(name = "IDCode_tarif", referencedColumnName = "IDCode_tarif", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private CodeTarif codeTarif;
    @JoinColumn(name = "IDProduit", referencedColumnName = "IDProduit", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Produit produit;

    public ProduitCodeTarif() {
    }

    public ProduitCodeTarif(ProduitCodeTarifPK produitCodeTarifPK) {
        this.produitCodeTarifPK = produitCodeTarifPK;
    }

    public ProduitCodeTarif(ProduitCodeTarifPK produitCodeTarifPK, BigDecimal prixVente, long quantitee, Date dateHeure) {
        this.produitCodeTarifPK = produitCodeTarifPK;
        this.prixVente = prixVente;
        this.quantitee = quantitee;
        this.dateHeure = dateHeure;
    }

    public ProduitCodeTarif(long iDCodetarif, long iDProduit) {
        this.produitCodeTarifPK = new ProduitCodeTarifPK(iDCodetarif, iDProduit);
    }

    public ProduitCodeTarifPK getProduitCodeTarifPK() {
        return produitCodeTarifPK;
    }

    public void setProduitCodeTarifPK(ProduitCodeTarifPK produitCodeTarifPK) {
        this.produitCodeTarifPK = produitCodeTarifPK;
    }

    public BigDecimal getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(BigDecimal prixVente) {
        this.prixVente = prixVente;
    }

    public long getQuantitee() {
        return quantitee;
    }

    public void setQuantitee(long quantitee) {
        this.quantitee = quantitee;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public CodeTarif getCodeTarif() {
        return codeTarif;
    }

    public void setCodeTarif(CodeTarif codeTarif) {
        this.codeTarif = codeTarif;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produitCodeTarifPK != null ? produitCodeTarifPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduitCodeTarif)) {
            return false;
        }
        ProduitCodeTarif other = (ProduitCodeTarif) object;
        if ((this.produitCodeTarifPK == null && other.produitCodeTarifPK != null) || (this.produitCodeTarifPK != null && !this.produitCodeTarifPK.equals(other.produitCodeTarifPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.ProduitCodeTarif[ produitCodeTarifPK=" + produitCodeTarifPK + " ]";
    }
    
}
