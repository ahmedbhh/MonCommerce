package moncommerce.gestionClient.web.controller;

import moncommerce.gestionClient.domain.model.BondesortieProduit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.gestionClient.service.BondesortieProduitService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@ManagedBean(name = "bondesortieProduitController")
@ViewScoped
public class BondesortieProduitController extends AbstractController<BondesortieProduit> implements Serializable {

    @Autowired
    private BondesortieProduitService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public BondesortieProduitController() {
        super(BondesortieProduit.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getBondesortieProduitPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
        this.getSelected().getBondesortieProduitPK().setIDBondeSortie(this.getSelected().getBondesortie().getIDBondeSortie());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setBondesortieProduitPK(new moncommerce.gestionClient.domain.model.BondesortieProduitPK());
    }

}
