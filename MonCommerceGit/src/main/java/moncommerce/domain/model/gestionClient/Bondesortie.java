/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.gestionClient;

import moncommerce.domain.model.client.Client;
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
import moncommerce.domain.model.Depot;
import moncommerce.domain.model.Employee;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "bondesortie")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bondesortie.findAll", query = "SELECT b FROM Bondesortie b"),
    @NamedQuery(name = "Bondesortie.findByIDBondesortie", query = "SELECT b FROM Bondesortie b WHERE b.iDBondesortie = :iDBondesortie"),
    @NamedQuery(name = "Bondesortie.findByReferance", query = "SELECT b FROM Bondesortie b WHERE b.referance = :referance"),
    @NamedQuery(name = "Bondesortie.findByDate", query = "SELECT b FROM Bondesortie b WHERE b.date = :date"),
    @NamedQuery(name = "Bondesortie.findByValidee", query = "SELECT b FROM Bondesortie b WHERE b.validee = :validee"),
    @NamedQuery(name = "Bondesortie.findByCodeBarres", query = "SELECT b FROM Bondesortie b WHERE b.codeBarres = :codeBarres"),
    @NamedQuery(name = "Bondesortie.findByDateHeure", query = "SELECT b FROM Bondesortie b WHERE b.dateHeure = :dateHeure"),
    @NamedQuery(name = "Bondesortie.findByRemisetotal", query = "SELECT b FROM Bondesortie b WHERE b.remisetotal = :remisetotal"),
    @NamedQuery(name = "Bondesortie.findByTotalTVA", query = "SELECT b FROM Bondesortie b WHERE b.totalTVA = :totalTVA"),
    @NamedQuery(name = "Bondesortie.findByTotalHT", query = "SELECT b FROM Bondesortie b WHERE b.totalHT = :totalHT"),
    @NamedQuery(name = "Bondesortie.findByTotalttc", query = "SELECT b FROM Bondesortie b WHERE b.totalttc = :totalttc"),
    @NamedQuery(name = "Bondesortie.findBySoldee", query = "SELECT b FROM Bondesortie b WHERE b.soldee = :soldee")})
public class Bondesortie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Bon_de_sortie")
    private Long iDBondesortie;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "observation")
    private String observation;
    @Column(name = "validee")
    private Short validee;
    @Size(max = 50)
    @Column(name = "code_Barres")
    private String codeBarres;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
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
    @JoinColumn(name = "ID_Facture_Clients", referencedColumnName = "ID_Facture_Clients")
    @OneToOne
    private FactureClients iDFactureClients;
    @JoinColumn(name = "ID_Commande_Client", referencedColumnName = "ID_Commande_Client")
    @ManyToOne
    private CommandeClient iDCommandeClient;
    @JoinColumn(name = "ID_depot", referencedColumnName = "ID_depot")
    @ManyToOne
    private Depot iDdepot;
    @JoinColumn(name = "ID_Client", referencedColumnName = "ID_Client")
    @ManyToOne
    private Client iDClient;
    @JoinColumn(name = "IDemployee", referencedColumnName = "IDemployee")
    @ManyToOne
    private Employee iDemployee;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bondesortie")
    private Collection<BondesortieProduit> bondesortieProduitCollection;

    public Bondesortie() {
    }

    public Bondesortie(Long iDBondesortie) {
        this.iDBondesortie = iDBondesortie;
    }

    public Bondesortie(Long iDBondesortie, Date dateHeure) {
        this.iDBondesortie = iDBondesortie;
        this.dateHeure = dateHeure;
    }

    public Long getIDBondesortie() {
        return iDBondesortie;
    }

    public void setIDBondesortie(Long iDBondesortie) {
        this.iDBondesortie = iDBondesortie;
    }

    public String getReferance() {
        return referance;
    }

    public void setReferance(String referance) {
        this.referance = referance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Short getValidee() {
        return validee;
    }

    public void setValidee(Short validee) {
        this.validee = validee;
    }

    public String getCodeBarres() {
        return codeBarres;
    }

    public void setCodeBarres(String codeBarres) {
        this.codeBarres = codeBarres;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
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

    public FactureClients getIDFactureClients() {
        return iDFactureClients;
    }

    public void setIDFactureClients(FactureClients iDFactureClients) {
        this.iDFactureClients = iDFactureClients;
    }

    public CommandeClient getIDCommandeClient() {
        return iDCommandeClient;
    }

    public void setIDCommandeClient(CommandeClient iDCommandeClient) {
        this.iDCommandeClient = iDCommandeClient;
    }

    public Depot getIDdepot() {
        return iDdepot;
    }

    public void setIDdepot(Depot iDdepot) {
        this.iDdepot = iDdepot;
    }

    public Client getIDClient() {
        return iDClient;
    }

    public void setIDClient(Client iDClient) {
        this.iDClient = iDClient;
    }

    public Employee getIDemployee() {
        return iDemployee;
    }

    public void setIDemployee(Employee iDemployee) {
        this.iDemployee = iDemployee;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<BondesortieProduit> getBondesortieProduitCollection() {
        return bondesortieProduitCollection;
    }

    public void setBondesortieProduitCollection(Collection<BondesortieProduit> bondesortieProduitCollection) {
        this.bondesortieProduitCollection = bondesortieProduitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDBondesortie != null ? iDBondesortie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bondesortie)) {
            return false;
        }
        Bondesortie other = (Bondesortie) object;
        if ((this.iDBondesortie == null && other.iDBondesortie != null) || (this.iDBondesortie != null && !this.iDBondesortie.equals(other.iDBondesortie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.Bondesortie[ iDBondesortie=" + iDBondesortie + " ]";
    }
    
}
