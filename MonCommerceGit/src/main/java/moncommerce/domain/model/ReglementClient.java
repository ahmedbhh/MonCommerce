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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
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
@Table(name = "reglement_client", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Referance"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReglementClient.findAll", query = "SELECT r FROM ReglementClient r"),
    @NamedQuery(name = "ReglementClient.findByIDReglementClient", query = "SELECT r FROM ReglementClient r WHERE r.iDReglementClient = :iDReglementClient"),
    @NamedQuery(name = "ReglementClient.findByDate", query = "SELECT r FROM ReglementClient r WHERE r.date = :date"),
    @NamedQuery(name = "ReglementClient.findByMontant", query = "SELECT r FROM ReglementClient r WHERE r.montant = :montant"),
    @NamedQuery(name = "ReglementClient.findByDateHeure", query = "SELECT r FROM ReglementClient r WHERE r.dateHeure = :dateHeure"),
    @NamedQuery(name = "ReglementClient.findByValidee", query = "SELECT r FROM ReglementClient r WHERE r.validee = :validee"),
    @NamedQuery(name = "ReglementClient.findByReferance", query = "SELECT r FROM ReglementClient r WHERE r.referance = :referance"),
    @NamedQuery(name = "ReglementClient.findByEscompte", query = "SELECT r FROM ReglementClient r WHERE r.escompte = :escompte")})
public class ReglementClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDReglement_Client", nullable = false)
    private Long iDReglementClient;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Montant", precision = 24, scale = 6)
    private BigDecimal montant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Column(name = "validee")
    private Short validee;
    @Size(max = 20)
    @Column(name = "Referance", length = 20)
    private String referance;
    @Column(name = "Escompte", precision = 24, scale = 6)
    private BigDecimal escompte;
    @ManyToMany(mappedBy = "reglementClientCollection", fetch = FetchType.EAGER)
    private Collection<FactureClients> factureClientsCollection;
    @JoinColumn(name = "IDClient", referencedColumnName = "IDClient")
    @ManyToOne(fetch = FetchType.EAGER)
    private Client iDClient;
    @JoinColumn(name = "IDMode_de_reglement", referencedColumnName = "IDMode_de_reglement")
    @ManyToOne(fetch = FetchType.EAGER)
    private ModeDeReglement iDModedereglement;
    @OneToMany(mappedBy = "iDReglementClient", fetch = FetchType.EAGER)
    private Collection<DetailPayment> detailPaymentCollection;

    public ReglementClient() {
    }

    public ReglementClient(Long iDReglementClient) {
        this.iDReglementClient = iDReglementClient;
    }

    public ReglementClient(Long iDReglementClient, Date dateHeure) {
        this.iDReglementClient = iDReglementClient;
        this.dateHeure = dateHeure;
    }

    public Long getIDReglementClient() {
        return iDReglementClient;
    }

    public void setIDReglementClient(Long iDReglementClient) {
        this.iDReglementClient = iDReglementClient;
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

    public ModeDeReglement getIDModedereglement() {
        return iDModedereglement;
    }

    public void setIDModedereglement(ModeDeReglement iDModedereglement) {
        this.iDModedereglement = iDModedereglement;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<DetailPayment> getDetailPaymentCollection() {
        return detailPaymentCollection;
    }

    public void setDetailPaymentCollection(Collection<DetailPayment> detailPaymentCollection) {
        this.detailPaymentCollection = detailPaymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDReglementClient != null ? iDReglementClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReglementClient)) {
            return false;
        }
        ReglementClient other = (ReglementClient) object;
        if ((this.iDReglementClient == null && other.iDReglementClient != null) || (this.iDReglementClient != null && !this.iDReglementClient.equals(other.iDReglementClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.ReglementClient[ iDReglementClient=" + iDReglementClient + " ]";
    }
    
}
