/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "accompte_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccompteClient.findAll", query = "SELECT a FROM AccompteClient a"),
    @NamedQuery(name = "AccompteClient.findByIDAccompteClient", query = "SELECT a FROM AccompteClient a WHERE a.iDAccompteClient = :iDAccompteClient"),
    @NamedQuery(name = "AccompteClient.findByDate", query = "SELECT a FROM AccompteClient a WHERE a.date = :date"),
    @NamedQuery(name = "AccompteClient.findByMontant", query = "SELECT a FROM AccompteClient a WHERE a.montant = :montant"),
    @NamedQuery(name = "AccompteClient.findByDateHeure", query = "SELECT a FROM AccompteClient a WHERE a.dateHeure = :dateHeure")})
public class AccompteClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDAccompte_Client")
    private Long iDAccompteClient;
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
    @OneToMany(mappedBy = "iDAccompteClient", fetch = FetchType.LAZY)
    private Collection<DetailPayment> detailPaymentCollection;
    @JoinColumn(name = "IDMode_de_reglement", referencedColumnName = "IDMode_de_reglement")
    @ManyToOne(fetch = FetchType.LAZY)
    private ModeDeReglement iDModedereglement;
    @JoinColumn(name = "IDFacture_Clients", referencedColumnName = "IDFacture_Clients")
    @ManyToOne(fetch = FetchType.LAZY)
    private FactureClients iDFactureClients;
    @JoinColumn(name = "IDCommande_Client", referencedColumnName = "IDCommande_Client")
    @ManyToOne(fetch = FetchType.LAZY)
    private CommandeClient iDCommandeClient;

    public AccompteClient() {
    }

    public AccompteClient(Long iDAccompteClient) {
        this.iDAccompteClient = iDAccompteClient;
    }

    public AccompteClient(Long iDAccompteClient, Date dateHeure) {
        this.iDAccompteClient = iDAccompteClient;
        this.dateHeure = dateHeure;
    }

    public Long getIDAccompteClient() {
        return iDAccompteClient;
    }

    public void setIDAccompteClient(Long iDAccompteClient) {
        this.iDAccompteClient = iDAccompteClient;
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

    @XmlTransient
    @JsonIgnore
    public Collection<DetailPayment> getDetailPaymentCollection() {
        return detailPaymentCollection;
    }

    public void setDetailPaymentCollection(Collection<DetailPayment> detailPaymentCollection) {
        this.detailPaymentCollection = detailPaymentCollection;
    }

    public ModeDeReglement getIDModedereglement() {
        return iDModedereglement;
    }

    public void setIDModedereglement(ModeDeReglement iDModedereglement) {
        this.iDModedereglement = iDModedereglement;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDAccompteClient != null ? iDAccompteClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccompteClient)) {
            return false;
        }
        AccompteClient other = (AccompteClient) object;
        if ((this.iDAccompteClient == null && other.iDAccompteClient != null) || (this.iDAccompteClient != null && !this.iDAccompteClient.equals(other.iDAccompteClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.AccompteClient[ iDAccompteClient=" + iDAccompteClient + " ]";
    }
    
}
