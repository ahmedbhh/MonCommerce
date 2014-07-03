package moncommerce.web.controller;

import moncommerce.domain.model.BonentreeProduit;
import moncommerce.repositroy.BonentreeProduitFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "bonentreeProduitController")
@ViewScoped
public class BonentreeProduitController extends AbstractController<BonentreeProduit> implements Serializable {

    @EJB
    private BonentreeProduitFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public BonentreeProduitController() {
        super(BonentreeProduit.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getBonentreeProduitPK().setIDBonEntree(this.getSelected().getBonentree().getIDBonEntree());
        this.getSelected().getBonentreeProduitPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setBonentreeProduitPK(new moncommerce.domain.model.BonentreeProduitPK());
    }

}
