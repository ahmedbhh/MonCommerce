package moncommerce.web.controller;

import moncommerce.domain.model.ProduitFactureFournisseur;
import moncommerce.repositroy.ProduitFactureFournisseurFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "produitFactureFournisseurController")
@ViewScoped
public class ProduitFactureFournisseurController extends AbstractController<ProduitFactureFournisseur> implements Serializable {

    @EJB
    private ProduitFactureFournisseurFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ProduitFactureFournisseurController() {
        super(ProduitFactureFournisseur.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getProduitFactureFournisseurPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
        this.getSelected().getProduitFactureFournisseurPK().setIDFactureFournisseur(this.getSelected().getFactureFournisseur().getIDFactureFournisseur());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProduitFactureFournisseurPK(new moncommerce.domain.model.ProduitFactureFournisseurPK());
    }

}
