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
public class LigneCommandeClientPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Commande_Client")
    private long iDCommandeClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produit")
    private long idProduit;

    public LigneCommandeClientPK() {
    }

    public LigneCommandeClientPK(long iDCommandeClient, long idProduit) {
        this.iDCommandeClient = iDCommandeClient;
        this.idProduit = idProduit;
    }

    public long getIDCommandeClient() {
        return iDCommandeClient;
    }

    public void setIDCommandeClient(long iDCommandeClient) {
        this.iDCommandeClient = iDCommandeClient;
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
        hash += (int) iDCommandeClient;
        hash += (int) idProduit;
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
        if (this.idProduit != other.idProduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.LigneCommandeClientPK[ iDCommandeClient=" + iDCommandeClient + ", idProduit=" + idProduit + " ]";
    }
    
}
