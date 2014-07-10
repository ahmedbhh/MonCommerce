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
public class BondesortieProduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_produit")
    private long idProduit;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Bon_de_sortie")
    private long iDBondesortie;

    public BondesortieProduitPK() {
    }

    public BondesortieProduitPK(long idProduit, long iDBondesortie) {
        this.idProduit = idProduit;
        this.iDBondesortie = iDBondesortie;
    }

    public long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(long idProduit) {
        this.idProduit = idProduit;
    }

    public long getIDBondesortie() {
        return iDBondesortie;
    }

    public void setIDBondesortie(long iDBondesortie) {
        this.iDBondesortie = iDBondesortie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProduit;
        hash += (int) iDBondesortie;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BondesortieProduitPK)) {
            return false;
        }
        BondesortieProduitPK other = (BondesortieProduitPK) object;
        if (this.idProduit != other.idProduit) {
            return false;
        }
        if (this.iDBondesortie != other.iDBondesortie) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "moncommerce.domain.model.test.BondesortieProduitPK[ idProduit=" + idProduit + ", iDBondesortie=" + iDBondesortie + " ]";
    }
    
}
