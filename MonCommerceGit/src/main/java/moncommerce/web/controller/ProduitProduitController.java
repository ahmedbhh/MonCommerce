package moncommerce.web.controller;

import moncommerce.domain.model.ProduitProduit;
import moncommerce.repositroy.ProduitProduitFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "produitProduitController")
@ViewScoped
public class ProduitProduitController extends AbstractController<ProduitProduit> implements Serializable {

    @EJB
    private ProduitProduitFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ProduitProduitController() {
        super(ProduitProduit.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getProduitProduitPK().setIDProduitComposee(this.getSelected().getProduit1().getIDProduit());
        this.getSelected().getProduitProduitPK().setIDProduitComposant(this.getSelected().getProduit().getIDProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProduitProduitPK(new moncommerce.domain.model.ProduitProduitPK());
    }

}
