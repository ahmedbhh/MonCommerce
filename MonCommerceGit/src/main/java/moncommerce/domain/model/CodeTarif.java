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
import javax.persistence.CascadeType;
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
@Table(name = "code_tarif")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CodeTarif.findAll", query = "SELECT c FROM CodeTarif c"),
    @NamedQuery(name = "CodeTarif.findByIDCodetarif", query = "SELECT c FROM CodeTarif c WHERE c.iDCodetarif = :iDCodetarif"),
    @NamedQuery(name = "CodeTarif.findByCodetaif", query = "SELECT c FROM CodeTarif c WHERE c.codetaif = :codetaif"),
    @NamedQuery(name = "CodeTarif.findByDateHeure", query = "SELECT c FROM CodeTarif c WHERE c.dateHeure = :dateHeure")})
public class CodeTarif implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCode_tarif")
    private Long iDCodetarif;
    @Size(max = 20)
    @Column(name = "Code_taif")
    private String codetaif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateHeure")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateHeure;
    @OneToMany(mappedBy = "iDCodetarif", fetch = FetchType.LAZY)
    private Collection<Client> clientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeTarif", fetch = FetchType.LAZY)
    private Collection<ProduitCodeTarif> produitCodeTarifCollection;

    public CodeTarif() {
    }

    public CodeTarif(Long iDCodetarif) {
        this.iDCodetarif = iDCodetarif;
    }

    public CodeTarif(Long iDCodetarif, Date dateHeure) {
        this.iDCodetarif = iDCodetarif;
        this.dateHeure = dateHeure;
    }

    public Long getIDCodetarif() {
        return iDCodetarif;
    }

    public void setIDCodetarif(Long iDCodetarif) {
        this.iDCodetarif = iDCodetarif;
    }

    public String getCodetaif() {
        return codetaif;
    }

    public void setCodetaif(String codetaif) {
        this.codetaif = codetaif;
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

    @XmlTransient
    @JsonIgnore
    public Collection<ProduitCodeTarif> getProduitCodeTarifCollection() {
        return produitCodeTarifCollection;
    }

    public void setProduitCodeTarifCollection(Collection<ProduitCodeTarif> produitCodeTarifCollection) {
        this.produitCodeTarifCollection = produitCodeTarifCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCodetarif != null ? iDCodetarif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CodeTarif)) {
            return false;
        }
        CodeTarif other = (CodeTarif) object;
        if ((this.iDCodetarif == null && other.iDCodetarif != null) || (this.iDCodetarif != null && !this.iDCodetarif.equals(other.iDCodetarif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.CodeTarif[ iDCodetarif=" + iDCodetarif + " ]";
    }
    
}
