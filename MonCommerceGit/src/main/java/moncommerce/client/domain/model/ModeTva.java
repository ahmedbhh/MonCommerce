/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.client.domain.model;

import moncommerce.client.domain.model.Client;
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
@Table(name = "mode_tva")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModeTva.findAll", query = "SELECT m FROM ModeTva m"),
    @NamedQuery(name = "ModeTva.findByIDModeTVA", query = "SELECT m FROM ModeTva m WHERE m.iDModeTVA = :iDModeTVA"),
    @NamedQuery(name = "ModeTva.findByLibelle", query = "SELECT m FROM ModeTva m WHERE m.libelle = :libelle"),
    @NamedQuery(name = "ModeTva.findByDateHeure", query = "SELECT m FROM ModeTva m WHERE m.dateHeure = :dateHeure")})
public class ModeTva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMode_TVA")
    private Long iDModeTVA;
    @Size(max = 20)
    @Column(name = "Libelle")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "iDModeTVA", fetch = FetchType.LAZY)
    private Collection<Client> clientCollection;

    public ModeTva() {
    }

    public ModeTva(Long iDModeTVA) {
        this.iDModeTVA = iDModeTVA;
    }

    public ModeTva(Long iDModeTVA, Date dateHeure) {
        this.iDModeTVA = iDModeTVA;
        this.dateHeure = dateHeure;
    }

    public Long getIDModeTVA() {
        return iDModeTVA;
    }

    public void setIDModeTVA(Long iDModeTVA) {
        this.iDModeTVA = iDModeTVA;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
        hash += (iDModeTVA != null ? iDModeTVA.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeTva)) {
            return false;
        }
        ModeTva other = (ModeTva) object;
        if ((this.iDModeTVA == null && other.iDModeTVA != null) || (this.iDModeTVA != null && !this.iDModeTVA.equals(other.iDModeTVA))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.ModeTva[ iDModeTVA=" + iDModeTVA + " ]";
    }
    
}
