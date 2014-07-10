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
@Table(name = "client")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIDClient", query = "SELECT c FROM Client c WHERE c.iDClient = :iDClient"),
    @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    @NamedQuery(name = "Client.findByRisque", query = "SELECT c FROM Client c WHERE c.risque = :risque"),
    @NamedQuery(name = "Client.findByEncours", query = "SELECT c FROM Client c WHERE c.encours = :encours"),
    @NamedQuery(name = "Client.findByBloquee", query = "SELECT c FROM Client c WHERE c.bloquee = :bloquee"),
    @NamedQuery(name = "Client.findByDateHeure", query = "SELECT c FROM Client c WHERE c.dateHeure = :dateHeure"),
    @NamedQuery(name = "Client.findByMatriculefiscale", query = "SELECT c FROM Client c WHERE c.matriculefiscale = :matriculefiscale")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_Client")
    private Long iDClient;
    @Size(max = 30)
    @Column(name = "Nom")
    private String nom;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Obsersavation")
    private String obsersavation;
    @Size(max = 20)
    @Column(name = "Risque")
    private String risque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Encours")
    private BigDecimal encours;
    @Column(name = "bloquee")
    private Short bloquee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Heure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @Size(max = 30)
    @Column(name = "Matricule_fiscale")
    private String matriculefiscale;
    @JoinColumn(name = "ID_Famille_client", referencedColumnName = "ID_Famille_client")
    @ManyToOne
    private FamilleClient iDFamilleclient;
    @JoinColumn(name = "ID_Mode_TVA", referencedColumnName = "ID_Mode_TVA")
    @ManyToOne
    private ModeTva iDModeTVA;
    @JoinColumn(name = "ID_Code_tarif", referencedColumnName = "ID_Code_tarif")
    @ManyToOne
    private CodeTarif iDCodetarif;
    @OneToMany(mappedBy = "iDClient")
    private Collection<Contact> contactCollection;
    @OneToMany(mappedBy = "iDClient")
    private Collection<AdresseFacturation> adresseFacturationCollection;
    @OneToMany(mappedBy = "iDClient")
    private Collection<ReglementClient> reglementClientCollection;
    @OneToMany(mappedBy = "iDClient")
    private Collection<CommandeClient> commandeClientCollection;
    @OneToMany(mappedBy = "iDClient")
    private Collection<Bondesortie> bondesortieCollection;
    @OneToMany(mappedBy = "iDClient")
    private Collection<FactureClients> factureClientsCollection;

    public Client() {
    }

    public Client(Long iDClient) {
        this.iDClient = iDClient;
    }

    public Client(Long iDClient, Date dateHeure) {
        this.iDClient = iDClient;
        this.dateHeure = dateHeure;
    }

    public Long getIDClient() {
        return iDClient;
    }

    public void setIDClient(Long iDClient) {
        this.iDClient = iDClient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getObsersavation() {
        return obsersavation;
    }

    public void setObsersavation(String obsersavation) {
        this.obsersavation = obsersavation;
    }

    public String getRisque() {
        return risque;
    }

    public void setRisque(String risque) {
        this.risque = risque;
    }

    public BigDecimal getEncours() {
        return encours;
    }

    public void setEncours(BigDecimal encours) {
        this.encours = encours;
    }

    public Short getBloquee() {
        return bloquee;
    }

    public void setBloquee(Short bloquee) {
        this.bloquee = bloquee;
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

    public FamilleClient getIDFamilleclient() {
        return iDFamilleclient;
    }

    public void setIDFamilleclient(FamilleClient iDFamilleclient) {
        this.iDFamilleclient = iDFamilleclient;
    }

    public ModeTva getIDModeTVA() {
        return iDModeTVA;
    }

    public void setIDModeTVA(ModeTva iDModeTVA) {
        this.iDModeTVA = iDModeTVA;
    }

    public CodeTarif getIDCodetarif() {
        return iDCodetarif;
    }

    public void setIDCodetarif(CodeTarif iDCodetarif) {
        this.iDCodetarif = iDCodetarif;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Contact> getContactCollection() {
        return contactCollection;
    }

    public void setContactCollection(Collection<Contact> contactCollection) {
        this.contactCollection = contactCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AdresseFacturation> getAdresseFacturationCollection() {
        return adresseFacturationCollection;
    }

    public void setAdresseFacturationCollection(Collection<AdresseFacturation> adresseFacturationCollection) {
        this.adresseFacturationCollection = adresseFacturationCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ReglementClient> getReglementClientCollection() {
        return reglementClientCollection;
    }

    public void setReglementClientCollection(Collection<ReglementClient> reglementClientCollection) {
        this.reglementClientCollection = reglementClientCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<CommandeClient> getCommandeClientCollection() {
        return commandeClientCollection;
    }

    public void setCommandeClientCollection(Collection<CommandeClient> commandeClientCollection) {
        this.commandeClientCollection = commandeClientCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Bondesortie> getBondesortieCollection() {
        return bondesortieCollection;
    }

    public void setBondesortieCollection(Collection<Bondesortie> bondesortieCollection) {
        this.bondesortieCollection = bondesortieCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<FactureClients> getFactureClientsCollection() {
        return factureClientsCollection;
    }

    public void setFactureClientsCollection(Collection<FactureClients> factureClientsCollection) {
        this.factureClientsCollection = factureClientsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDClient != null ? iDClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.iDClient == null && other.iDClient != null) || (this.iDClient != null && !this.iDClient.equals(other.iDClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.Client[ iDClient=" + iDClient + " ]";
    }
    
}
