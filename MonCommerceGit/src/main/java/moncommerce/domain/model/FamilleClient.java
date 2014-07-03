/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "famille_client", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Libelle"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FamilleClient.findAll", query = "SELECT f FROM FamilleClient f"),
    @NamedQuery(name = "FamilleClient.findByIDFamilleclient", query = "SELECT f FROM FamilleClient f WHERE f.iDFamilleclient = :iDFamilleclient"),
    @NamedQuery(name = "FamilleClient.findByLibelle", query = "SELECT f FROM FamilleClient f WHERE f.libelle = :libelle"),
    @NamedQuery(name = "FamilleClient.findByDateHeure", query = "SELECT f FROM FamilleClient f WHERE f.dateHeure = :dateHeure")})
public class FamilleClient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFamille_client", nullable = false)
    private Long iDFamilleclient;
    @Size(max = 20)
    @Column(name = "Libelle", length = 20)
    private String libelle;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Obsersavation", length = 2147483647)
    private String obsersavation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "iDFamilleclient", fetch = FetchType.EAGER)
    private Collection<Client> clientCollection;

    public FamilleClient() {
    }

    public FamilleClient(Long iDFamilleclient) {
        this.iDFamilleclient = iDFamilleclient;
    }

    public FamilleClient(Long iDFamilleclient, Date dateHeure) {
        this.iDFamilleclient = iDFamilleclient;
        this.dateHeure = dateHeure;
    }

    public Long getIDFamilleclient() {
        return iDFamilleclient;
    }

    public void setIDFamilleclient(Long iDFamilleclient) {
        this.iDFamilleclient = iDFamilleclient;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getObsersavation() {
        return obsersavation;
    }

    public void setObsersavation(String obsersavation) {
        this.obsersavation = obsersavation;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFamilleclient != null ? iDFamilleclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FamilleClient)) {
            return false;
        }
        FamilleClient other = (FamilleClient) object;
        if ((this.iDFamilleclient == null && other.iDFamilleclient != null) || (this.iDFamilleclient != null && !this.iDFamilleclient.equals(other.iDFamilleclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.FamilleClient[ iDFamilleclient=" + iDFamilleclient + " ]";
    }
    
}
