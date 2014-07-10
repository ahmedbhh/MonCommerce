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
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "facture_clients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FactureClients.findAll", query = "SELECT f FROM FactureClients f"),
    @NamedQuery(name = "FactureClients.findByIDFactureClients", query = "SELECT f FROM FactureClients f WHERE f.iDFactureClients = :iDFactureClients"),
    @NamedQuery(name = "FactureClients.findByReferance", query = "SELECT f FROM FactureClients f WHERE f.referance = :referance"),
    @NamedQuery(name = "FactureClients.findByCodeBarres", query = "SELECT f FROM FactureClients f WHERE f.codeBarres = :codeBarres"),
    @NamedQuery(name = "FactureClients.findByDate", query = "SELECT f FROM FactureClients f WHERE f.date = :date"),
    @NamedQuery(name = "FactureClients.findByEcheance", query = "SELECT f FROM FactureClients f WHERE f.echeance = :echeance"),
    @NamedQuery(name = "FactureClients.findByDateHeure", query = "SELECT f FROM FactureClients f WHERE f.dateHeure = :dateHeure"),
    @NamedQuery(name = "FactureClients.findByValidee", query = "SELECT f FROM FactureClients f WHERE f.validee = :validee"),
    @NamedQuery(name = "FactureClients.findByRemisetotal", query = "SELECT f FROM FactureClients f WHERE f.remisetotal = :remisetotal"),
    @NamedQuery(name = "FactureClients.findByTotalTVA", query = "SELECT f FROM FactureClients f WHERE f.totalTVA = :totalTVA"),
    @NamedQuery(name = "FactureClients.findByTotalHT", query = "SELECT f FROM FactureClients f WHERE f.totalHT = :totalHT"),
    @NamedQuery(name = "FactureClients.findByTotalttc", query = "SELECT f FROM FactureClients f WHERE f.totalttc = :totalttc"),
    @NamedQuery(name = "FactureClients.findBySoldee", query = "SELECT f FROM FactureClients f WHERE f.soldee = :soldee"),
    @NamedQuery(name = "FactureClients.findByTembree", query = "SELECT f FROM FactureClients f WHERE f.tembree = :tembree")})
public class FactureClients implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Facture_Clients")
    private Long iDFactureClients;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Size(max = 50)
    @Column(name = "code_Barres")
    private String codeBarres;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "remarque")
    private String remarque;
    @Column(name = "echeance")
    @Temporal(TemporalType.DATE)
    private Date echeance;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Column(name = "validee")
    private Short validee;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Remise_total")
    private BigDecimal remisetotal;
    @Column(name = "Total_TVA")
    private BigDecimal totalTVA;
    @Column(name = "Total_HT")
    private BigDecimal totalHT;
    @Column(name = "Total_ttc")
    private BigDecimal totalttc;
    @Column(name = "soldee")
    private Short soldee;
    @Column(name = "Tembree")
    private Short tembree;
    @ManyToMany(mappedBy = "factureClientsCollection")
    private Collection<ReglementClient> reglementClientCollection;
    @OneToOne(mappedBy = "iDFactureClients")
    private Bondesortie bondesortie;
    @JoinColumn(name = "ID_Caisse", referencedColumnName = "ID_Caisse")
    @ManyToOne
    private Caisse iDCaisse;
    @JoinColumn(name = "IDemployee", referencedColumnName = "IDemployee")
    @ManyToOne
    private Employee iDemployee;
    @JoinColumn(name = "ID_Commande_Client", referencedColumnName = "ID_Commande_Client")
    @ManyToOne
    private CommandeClient iDCommandeClient;
    @JoinColumn(name = "ID_Client", referencedColumnName = "ID_Client")
    @ManyToOne
    private Client iDClient;
    @JoinColumn(name = "ID_Mode_de_reglement", referencedColumnName = "ID_Mode_de_reglement")
    @ManyToOne
    private ModeDeReglement iDModedereglement;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "factureClients")
    private FactureClientProduit factureClientProduit;
    @OneToMany(mappedBy = "iDFactureClients")
    private Collection<AccompteClient> accompteClientCollection;

    public FactureClients() {
    }

    public FactureClients(Long iDFactureClients) {
        this.iDFactureClients = iDFactureClients;
    }

    public FactureClients(Long iDFactureClients, Date dateHeure) {
        this.iDFactureClients = iDFactureClients;
        this.dateHeure = dateHeure;
    }

    public Long getIDFactureClients() {
        return iDFactureClients;
    }

    public void setIDFactureClients(Long iDFactureClients) {
        this.iDFactureClients = iDFactureClients;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public String getCodeBarres() {
        return codeBarres;
    }

    public void setCodeBarres(String codeBarres) {
        this.codeBarres = codeBarres;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRemarque() {
        return remarque;
    }

    public void setRemarque(String remarque) {
        this.remarque = remarque;
    }

    public Date getEcheance() {
        return echeance;
    }

    public void setEcheance(Date echeance) {
        this.echeance = echeance;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    public Short getValidee() {
        return validee;
    }

    public void setValidee(Short validee) {
        this.validee = validee;
    }

    public BigDecimal getRemisetotal() {
        return remisetotal;
    }

    public void setRemisetotal(BigDecimal remisetotal) {
        this.remisetotal = remisetotal;
    }

    public BigDecimal getTotalTVA() {
        return totalTVA;
    }

    public void setTotalTVA(BigDecimal totalTVA) {
        this.totalTVA = totalTVA;
    }

    public BigDecimal getTotalHT() {
        return totalHT;
    }

    public void setTotalHT(BigDecimal totalHT) {
        this.totalHT = totalHT;
    }

    public BigDecimal getTotalttc() {
        return totalttc;
    }

    public void setTotalttc(BigDecimal totalttc) {
        this.totalttc = totalttc;
    }

    public Short getSoldee() {
        return soldee;
    }

    public void setSoldee(Short soldee) {
        this.soldee = soldee;
    }

    public Short getTembree() {
        return tembree;
    }

    public void setTembree(Short tembree) {
        this.tembree = tembree;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ReglementClient> getReglementClientCollection() {
        return reglementClientCollection;
    }

    public void setReglementClientCollection(Collection<ReglementClient> reglementClientCollection) {
        this.reglementClientCollection = reglementClientCollection;
    }

    public Bondesortie getBondesortie() {
        return bondesortie;
    }

    public void setBondesortie(Bondesortie bondesortie) {
        this.bondesortie = bondesortie;
    }

    public Caisse getIDCaisse() {
        return iDCaisse;
    }

    public void setIDCaisse(Caisse iDCaisse) {
        this.iDCaisse = iDCaisse;
    }

    public Employee getIDemployee() {
        return iDemployee;
    }

    public void setIDemployee(Employee iDemployee) {
        this.iDemployee = iDemployee;
    }

    public CommandeClient getIDCommandeClient() {
        return iDCommandeClient;
    }

    public void setIDCommandeClient(CommandeClient iDCommandeClient) {
        this.iDCommandeClient = iDCommandeClient;
    }

    public Client getIDClient() {
        return iDClient;
    }

    public void setIDClient(Client iDClient) {
        this.iDClient = iDClient;
    }

    public ModeDeReglement getIDModedereglement() {
        return iDModedereglement;
    }

    public void setIDModedereglement(ModeDeReglement iDModedereglement) {
        this.iDModedereglement = iDModedereglement;
    }

    public FactureClientProduit getFactureClientProduit() {
        return factureClientProduit;
    }

    public void setFactureClientProduit(FactureClientProduit factureClientProduit) {
        this.factureClientProduit = factureClientProduit;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AccompteClient> getAccompteClientCollection() {
        return accompteClientCollection;
    }

    public void setAccompteClientCollection(Collection<AccompteClient> accompteClientCollection) {
        this.accompteClientCollection = accompteClientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFactureClients != null ? iDFactureClients.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactureClients)) {
            return false;
        }
        FactureClients other = (FactureClients) object;
        if ((this.iDFactureClients == null && other.iDFactureClients != null) || (this.iDFactureClients != null && !this.iDFactureClients.equals(other.iDFactureClients))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.FactureClients[ iDFactureClients=" + iDFactureClients + " ]";
    }
    
}
