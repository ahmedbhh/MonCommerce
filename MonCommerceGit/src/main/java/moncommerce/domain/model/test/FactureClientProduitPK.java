/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model.test;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author AHMED
 */
@Embeddable
public class FactureClientProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Facture_Clients")
    private long iDFactureClients;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produit")
    private long idProduit;

    public FactureClientProduitPK() {
    }

    public FactureClientProduitPK(long iDFactureClients, long idProduit) {
        this.iDFactureClients = iDFactureClients;
        this.idProduit = idProduit;
    }

    public long getIDFactureClients() {
        return iDFactureClients;
    }

    public void setIDFactureClients(long iDFactureClients) {
        this.iDFactureClients = iDFactureClients;
    }

    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDFactureClients;
        hash += (int) idProduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactureClientProduitPK)) {
            return false;
        }
        FactureClientProduitPK other = (FactureClientProduitPK) object;
        if (this.iDFactureClients != other.iDFactureClients) {
            return false;
        }
        if (this.idProduit != other.idProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.FactureClientProduitPK[ iDFactureClients=" + iDFactureClients + ", idProduit=" + idProduit + " ]";
    }
    
}
