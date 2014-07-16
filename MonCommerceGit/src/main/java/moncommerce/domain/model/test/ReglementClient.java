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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "reglement_client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReglementClient.findAll", query = "SELECT r FROM ReglementClient r"),
    @NamedQuery(name = "ReglementClient.findByIDReglementClient", query = "SELECT r FROM ReglementClient r WHERE r.iDReglementClient = :iDReglementClient"),
    @NamedQuery(name = "ReglementClient.findByDate", query = "SELECT r FROM ReglementClient r WHERE r.date = :date"),
    @NamedQuery(name = "ReglementClient.findByMontant", query = "SELECT r FROM ReglementClient r WHERE r.montant = :montant"),
    @NamedQuery(name = "ReglementClient.findByDateHeure", query = "SELECT r FROM ReglementClient r WHERE r.dateHeure = :dateHeure"),
    @NamedQuery(name = "ReglementClient.findByValidee", query = "SELECT r FROM ReglementClient r WHERE r.validee = :validee"),
    @NamedQuery(name = "ReglementClient.findByEscompte", query = "SELECT r FROM ReglementClient r WHERE r.escompte = :escompte")})
public class ReglementClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Reglement_Client")
    private Long iDReglementClient;
    @Column(name = "Date")
    @Temporal(TemporalType.DATE)
    private Date date;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Montant")
    private BigDecimal montant;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Column(name = "validee")
    private Short validee;
    @Column(name = "Escompte")
    private BigDecimal escompte;
    @JoinTable(name = "facture_clients_reglement_client", joinColumns = {
        @JoinColumn(name = "ID_Reglement_Client", referencedColumnName = "ID_Reglement_Client")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_Facture_Clients", referencedColumnName = "ID_Facture_Clients")})
    @ManyToMany
    private Collection<FactureClients> factureClientsCollection;
    @JoinColumn(name = "ID_Mode_de_reglement", referencedColumnName = "ID_Mode_de_reglement")
    @ManyToOne
    private ModeDeReglement iDModedereglement;
    @JoinColumn(name = "ID_Client", referencedColumnName = "ID_Client")
    @ManyToOne
    private Client iDClient;

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

    public ModeDeReglement getIDModedereglement() {
        return iDModedereglement;
    }

    public void setIDModedereglement(ModeDeReglement iDModedereglement) {
        this.iDModedereglement = iDModedereglement;
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
        return "moncommerce.domain.model.test.ReglementClient[ iDReglementClient=" + iDReglementClient + " ]";
    }
    
}
