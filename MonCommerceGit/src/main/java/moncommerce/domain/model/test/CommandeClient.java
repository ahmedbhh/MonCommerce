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
@Table(name = "commande_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommandeClient.findAll", query = "SELECT c FROM CommandeClient c"),
    @NamedQuery(name = "CommandeClient.findByIDCommandeClient", query = "SELECT c FROM CommandeClient c WHERE c.iDCommandeClient = :iDCommandeClient"),
    @NamedQuery(name = "CommandeClient.findByReferance", query = "SELECT c FROM CommandeClient c WHERE c.referance = :referance"),
    @NamedQuery(name = "CommandeClient.findByDate", query = "SELECT c FROM CommandeClient c WHERE c.date = :date"),
    @NamedQuery(name = "CommandeClient.findByDateHeure", query = "SELECT c FROM CommandeClient c WHERE c.dateHeure = :dateHeure"),
    @NamedQuery(name = "CommandeClient.findByEcheance", query = "SELECT c FROM CommandeClient c WHERE c.echeance = :echeance"),
    @NamedQuery(name = "CommandeClient.findByValidee", query = "SELECT c FROM CommandeClient c WHERE c.validee = :validee"),
    @NamedQuery(name = "CommandeClient.findByRemisetotal", query = "SELECT c FROM CommandeClient c WHERE c.remisetotal = :remisetotal"),
    @NamedQuery(name = "CommandeClient.findByTotalTVA", query = "SELECT c FROM CommandeClient c WHERE c.totalTVA = :totalTVA"),
    @NamedQuery(name = "CommandeClient.findByTotalHT", query = "SELECT c FROM CommandeClient c WHERE c.totalHT = :totalHT"),
    @NamedQuery(name = "CommandeClient.findByTotalttc", query = "SELECT c FROM CommandeClient c WHERE c.totalttc = :totalttc"),
    @NamedQuery(name = "CommandeClient.findBySoldee", query = "SELECT c FROM CommandeClient c WHERE c.soldee = :soldee")})
public class CommandeClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Commande_Client")
    private Long iDCommandeClient;
    @Size(max = 20)
    @Column(name = "Referance")
    private String referance;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "remarque")
    private String remarque;
    @Column(name = "echeance")
    @Temporal(TemporalType.DATE)
    private Date echeance;
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
    @OneToMany(mappedBy = "iDCommandeClient")
    private Collection<FactureClients> factureClientsCollection;
    @JoinColumn(name = "ID_Client", referencedColumnName = "ID_Client")
    @ManyToOne
    private Client iDClient;

    public CommandeClient() {
    }

    public CommandeClient(Long iDCommandeClient) {
        this.iDCommandeClient = iDCommandeClient;
    }

    public CommandeClient(Long iDCommandeClient, Date dateHeure) {
        this.iDCommandeClient = iDCommandeClient;
        this.dateHeure = dateHeure;
    }

    public Long getIDCommandeClient() {
        return iDCommandeClient;
    }

    public void setIDCommandeClient(Long iDCommandeClient) {
        this.iDCommandeClient = iDCommandeClient;
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

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
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

    @XmlTransient
    @JsonIgnore
    public Collection<FactureClients> getFactureClientsCollection() {
        return factureClientsCollection;
    }

    public void setFactureClientsCollection(Collection<FactureClients> factureClientsCollection) {
        this.factureClientsCollection = factureClientsCollection;
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
        hash += (iDCommandeClient != null ? iDCommandeClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommandeClient)) {
            return false;
        }
        CommandeClient other = (CommandeClient) object;
        if ((this.iDCommandeClient == null && other.iDCommandeClient != null) || (this.iDCommandeClient != null && !this.iDCommandeClient.equals(other.iDCommandeClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.CommandeClient[ iDCommandeClient=" + iDCommandeClient + " ]";
    }
    
}
