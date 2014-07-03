package moncommerce.web.controller;

import moncommerce.domain.model.FactureClientProduit;
import moncommerce.repositroy.FactureClientProduitFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "factureClientProduitController")
@ViewScoped
public class FactureClientProduitController extends AbstractController<FactureClientProduit> implements Serializable {

    @EJB
    private FactureClientProduitFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FactureClientProduitController() {
        super(FactureClientProduit.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getFactureClientProduitPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
        this.getSelected().getFactureClientProduitPK().setIDFactureClient(this.getSelected().getFactureClients().getIDFactureClients());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setFactureClientProduitPK(new moncommerce.domain.model.FactureClientProduitPK());
    }

}
