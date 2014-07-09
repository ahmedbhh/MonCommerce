/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.gestionClient;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author AHMED
 */
@Entity
@Table(name = "detail_payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetailPayment.findAll", query = "SELECT d FROM DetailPayment d"),
    @NamedQuery(name = "DetailPayment.findByIDdetailpayment", query = "SELECT d FROM DetailPayment d WHERE d.iDdetailpayment = :iDdetailpayment"),
    @NamedQuery(name = "DetailPayment.findByBanque", query = "SELECT d FROM DetailPayment d WHERE d.banque = :banque"),
    @NamedQuery(name = "DetailPayment.findByNumCheque", query = "SELECT d FROM DetailPayment d WHERE d.numCheque = :numCheque"),
    @NamedQuery(name = "DetailPayment.findByNomproprietaire", query = "SELECT d FROM DetailPayment d WHERE d.nomproprietaire = :nomproprietaire"),
    @NamedQuery(name = "DetailPayment.findByDateversement", query = "SELECT d FROM DetailPayment d WHERE d.dateversement = :dateversement"),
    @NamedQuery(name = "DetailPayment.findByALordre", query = "SELECT d FROM DetailPayment d WHERE d.aLordre = :aLordre")})
public class DetailPayment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_detail_payment")
    private Long iDdetailpayment;
    @Size(max = 20)
    @Column(name = "Banque")
    private String banque;
    @Size(max = 50)
    @Column(name = "num_cheque")
    private String numCheque;
    @Size(max = 50)
    @Column(name = "Nom_proprietaire")
    private String nomproprietaire;
    @Column(name = "Date_versement")
    @Temporal(TemporalType.DATE)
    private Date dateversement;
    @Size(max = 50)
    @Column(name = "a_lordre")
    private String aLordre;
    @JoinColumn(name = "ID_Accompte_Client", referencedColumnName = "ID_Accompte_Client")
    @ManyToOne
    private AccompteClient iDAccompteClient;
    @JoinColumn(name = "ID_Reglement_Client", referencedColumnName = "ID_Reglement_Client")
    @ManyToOne
    private ReglementClient iDReglementClient;

    public DetailPayment() {
    }

    public DetailPayment(Long iDdetailpayment) {
        this.iDdetailpayment = iDdetailpayment;
    }

    public Long getIDdetailpayment() {
        return iDdetailpayment;
    }

    public void setIDdetailpayment(Long iDdetailpayment) {
        this.iDdetailpayment = iDdetailpayment;
    }

    public String getBanque() {
        return banque;
    }

    public void setBanque(String banque) {
        this.banque = banque;
    }

    public String getNumCheque() {
        return numCheque;
    }

    public void setNumCheque(String numCheque) {
        this.numCheque = numCheque;
    }

    public String getNomproprietaire() {
        return nomproprietaire;
    }

    public void setNomproprietaire(String nomproprietaire) {
        this.nomproprietaire = nomproprietaire;
    }

    public Date getDateversement() {
        return dateversement;
    }

    public void setDateversement(Date dateversement) {
        this.dateversement = dateversement;
    }

    public String getALordre() {
        return aLordre;
    }

    public void setALordre(String aLordre) {
        this.aLordre = aLordre;
    }

    public AccompteClient getIDAccompteClient() {
        return iDAccompteClient;
    }

    public void setIDAccompteClient(AccompteClient iDAccompteClient) {
        this.iDAccompteClient = iDAccompteClient;
    }

    public ReglementClient getIDReglementClient() {
        return iDReglementClient;
    }

    public void setIDReglementClient(ReglementClient iDReglementClient) {
        this.iDReglementClient = iDReglementClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDdetailpayment != null ? iDdetailpayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetailPayment)) {
            return false;
        }
        DetailPayment other = (DetailPayment) object;
        if ((this.iDdetailpayment == null && other.iDdetailpayment != null) || (this.iDdetailpayment != null && !this.iDdetailpayment.equals(other.iDdetailpayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.DetailPayment[ iDdetailpayment=" + iDdetailpayment + " ]";
    }
    
}
