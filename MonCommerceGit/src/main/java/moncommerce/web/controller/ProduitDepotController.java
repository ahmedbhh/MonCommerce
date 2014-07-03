package moncommerce.web.controller;

import moncommerce.domain.model.ProduitDepot;
import moncommerce.repositroy.ProduitDepotFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "produitDepotController")
@ViewScoped
public class ProduitDepotController extends AbstractController<ProduitDepot> implements Serializable {

    @EJB
    private ProduitDepotFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ProduitDepotController() {
        super(ProduitDepot.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getProduitDepotPK().setIDdepot(this.getSelected().getDepot().getIDdepot());
        this.getSelected().getProduitDepotPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProduitDepotPK(new moncommerce.domain.model.ProduitDepotPK());
    }

}
