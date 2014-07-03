package moncommerce.web.controller;

import moncommerce.domain.model.BondetransfertProduit;
import moncommerce.repositroy.BondetransfertProduitFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "bondetransfertProduitController")
@ViewScoped
public class BondetransfertProduitController extends AbstractController<BondetransfertProduit> implements Serializable {

    @EJB
    private BondetransfertProduitFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public BondetransfertProduitController() {
        super(BondetransfertProduit.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getBondetransfertProduitPK().setIDBonDeTransfert(this.getSelected().getBondetransfert().getIDBonDeTransfert());
        this.getSelected().getBondetransfertProduitPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setBondetransfertProduitPK(new moncommerce.domain.model.BondetransfertProduitPK());
    }

}
