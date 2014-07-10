package moncommerce.web.controller.gestionClient;

import moncommerce.domain.model.test.BondesortieProduit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionClient.BondesortieProduitService;
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
        this.getSelected().getBondesortieProduitPK().setIdProduit(this.getSelected().getProduit().getIdProduit());
        this.getSelected().getBondesortieProduitPK().setIDBondesortie(this.getSelected().getBondesortie().getIDBondesortie());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setBondesortieProduitPK(new moncommerce.domain.model.test.BondesortieProduitPK());
    }

}
