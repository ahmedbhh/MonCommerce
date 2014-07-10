package moncommerce.web.controller.gestionFournisseur;

import moncommerce.domain.model.test.BonentreeProduit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionFournisseur.BonentreeProduitService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "bonentreeProduitController")
@ViewScoped
public class BonentreeProduitController extends AbstractController<BonentreeProduit> implements Serializable {

    @Autowired
    private BonentreeProduitService ejbFacade;

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
        this.getSelected().getBonentreeProduitPK().setIdProduit(this.getSelected().getProduit().getIdProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setBonentreeProduitPK(new moncommerce.domain.model.test.BonentreeProduitPK());
    }

}
