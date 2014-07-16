package moncommerce.web.controller.gestionClient;

import moncommerce.domain.model.test.CommandeProduit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionClient.CommandeProduitService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "commandeProduitController")
@ViewScoped
public class CommandeProduitController extends AbstractController<CommandeProduit> implements Serializable {

    @Autowired
    private CommandeProduitService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CommandeProduitController() {
        super(CommandeProduit.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getCommandeProduitPK().setIDCommandefournisseur(this.getSelected().getCommande().getIDCommandefournisseur());
        this.getSelected().getCommandeProduitPK().setIdProduit(this.getSelected().getProduit().getIdProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCommandeProduitPK(new moncommerce.domain.model.test.CommandeProduitPK());
    }

}
