package moncommerce.web.controller;

import moncommerce.domain.model.BondetransfertProduit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.BondetransfertProduitService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "bondetransfertProduitController")
@ViewScoped
public class BondetransfertProduitController extends AbstractController<BondetransfertProduit> implements Serializable {

    @Autowired
    private BondetransfertProduitService ejbFacade;

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
        this.getSelected().getBondetransfertProduitPK().setIdProduit(this.getSelected().getBondetransfertProduitPK().getIdProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setBondetransfertProduitPK(new moncommerce.domain.model.BondetransfertProduitPK());
    }

}
