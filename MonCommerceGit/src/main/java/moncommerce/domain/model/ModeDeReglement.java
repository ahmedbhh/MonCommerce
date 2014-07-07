/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

import moncommerce.gestionFournisseur.domain.model.Accompte;
import moncommerce.gestionFournisseur.domain.model.ReglementFournisseurs;
import moncommerce.gestionClient.domain.model.FactureClients;
import moncommerce.gestionClient.domain.model.AccompteClient;
import moncommerce.gestionClient.domain.model.ReglementClient;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.Type;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "mode_de_reglement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ModeDeReglement.findAll", query = "SELECT m FROM ModeDeReglement m"),
    @NamedQuery(name = "ModeDeReglement.findByIDModedereglement", query = "SELECT m FROM ModeDeReglement m WHERE m.iDModedereglement = :iDModedereglement"),
    @NamedQuery(name = "ModeDeReglement.findByLibelle", query = "SELECT m FROM ModeDeReglement m WHERE m.libelle = :libelle"),
    @NamedQuery(name = "ModeDeReglement.findByDateHeure", query = "SELECT m FROM ModeDeReglement m WHERE m.dateHeure = :dateHeure")})
public class ModeDeReglement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMode_de_reglement")
    private Long iDModedereglement;
    @Size(max = 20)
    @Column(name = "Libelle")
    private String libelle;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Type(type="timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "iDModedereglement", fetch = FetchType.LAZY)
    private Collection<ReglementClient> reglementClientCollection;
    @OneToMany(mappedBy = "iDModedereglement", fetch = FetchType.LAZY)
    private Collection<Accompte> accompteCollection;
    @OneToMany(mappedBy = "iDModedereglement", fetch = FetchType.LAZY)
    private Collection<ReglementFournisseurs> reglementFournisseursCollection;
    @OneToMany(mappedBy = "iDModedereglement", fetch = FetchType.LAZY)
    private Collection<FactureClients> factureClientsCollection;
    @OneToMany(mappedBy = "iDModedereglement", fetch = FetchType.LAZY)
    private Collection<AccompteClient> accompteClientCollection;

    public ModeDeReglement() {
    }

    public ModeDeReglement(Long iDModedereglement) {
        this.iDModedereglement = iDModedereglement;
    }

    public ModeDeReglement(Long iDModedereglement, Date dateHeure) {
        this.iDModedereglement = iDModedereglement;
        this.dateHeure = dateHeure;
    }

    public Long getIDModedereglement() {
        return iDModedereglement;
    }

    public void setIDModedereglement(Long iDModedereglement) {
        this.iDModedereglement = iDModedereglement;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(Date dateHeure) {
        this.dateHeure = dateHeure;
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
    public Collection<Accompte> getAccompteCollection() {
        return accompteCollection;
    }

    public void setAccompteCollection(Collection<Accompte> accompteCollection) {
        this.accompteCollection = accompteCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ReglementFournisseurs> getReglementFournisseursCollection() {
        return reglementFournisseursCollection;
    }

    public void setReglementFournisseursCollection(Collection<ReglementFournisseurs> reglementFournisseursCollection) {
        this.reglementFournisseursCollection = reglementFournisseursCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<FactureClients> getFactureClientsCollection() {
        return factureClientsCollection;
    }

    public void setFactureClientsCollection(Collection<FactureClients> factureClientsCollection) {
        this.factureClientsCollection = factureClientsCollection;
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
        hash += (iDModedereglement != null ? iDModedereglement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ModeDeReglement)) {
            return false;
        }
        ModeDeReglement other = (ModeDeReglement) object;
        if ((this.iDModedereglement == null && other.iDModedereglement != null) || (this.iDModedereglement != null && !this.iDModedereglement.equals(other.iDModedereglement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.ModeDeReglement[ iDModedereglement=" + iDModedereglement + " ]";
    }
    
}
