package moncommerce.web.controller;

import moncommerce.domain.model.CommandeProduit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.CommandeProduitService;
import org.springframework.beans.factory.annotation.Autowired;

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
        this.getSelected().getCommandeProduitPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setCommandeProduitPK(new moncommerce.domain.model.CommandeProduitPK());
    }

}
