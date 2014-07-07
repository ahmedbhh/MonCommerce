/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package moncommerce.gestionClient.domain.model;

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
public class LigneCommandeClientPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCommande_Client")
    private long iDCommandeClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDProduit")
    private long iDProduit;

    public LigneCommandeClientPK() {
    }

    public LigneCommandeClientPK(long iDCommandeClient, long iDProduit) {
        this.iDCommandeClient = iDCommandeClient;
        this.iDProduit = iDProduit;
    }

    public long getIDCommandeClient() {
        return iDCommandeClient;
    }

    public void setIDCommandeClient(long iDCommandeClient) {
        this.iDCommandeClient = iDCommandeClient;
    }

    public long getIDProduit() {
        return iDProduit;
    }

    public void setIDProduit(long iDProduit) {
        this.iDProduit = iDProduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iDCommandeClient;
        hash += (int) iDProduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LigneCommandeClientPK)) {
            return false;
        }
        LigneCommandeClientPK other = (LigneCommandeClientPK) object;
        if (this.iDCommandeClient != other.iDCommandeClient) {
            return false;
        }
        if (this.iDProduit != other.iDProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.LigneCommandeClientPK[ iDCommandeClient=" + iDCommandeClient + ", iDProduit=" + iDProduit + " ]";
    }
    
}
