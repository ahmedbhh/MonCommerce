/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.domain.model;

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
    @Column(name = "IDProduit", nullable = false)
    private long iDProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDFacture_Client", nullable = false)
    private long iDFactureClient;

    public FactureClientProduitPK() {
    }

    public FactureClientProduitPK(long iDProduit, long iDFactureClient) {
        this.iDProduit = iDProduit;
        this.iDFactureClient = iDFactureClient;
    }

    public long getIDProduit() {
        return iDProduit;
    }

    public void setIDProduit(long iDProduit) {
        this.iDProduit = iDProduit;
    }

    public long getIDFactureClient() {
        return iDFactureClient;
    }

    public void setIDFactureClient(long iDFactureClient) {
        this.iDFactureClient = iDFactureClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDProduit;
        hash += (int) iDFactureClient;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FactureClientProduitPK)) {
            return false;
        }
        FactureClientProduitPK other = (FactureClientProduitPK) object;
        if (this.iDProduit != other.iDProduit) {
            return false;
        }
        if (this.iDFactureClient != other.iDFactureClient) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.FactureClientProduitPK[ iDProduit=" + iDProduit + ", iDFactureClient=" + iDFactureClient + " ]";
    }
    
}
