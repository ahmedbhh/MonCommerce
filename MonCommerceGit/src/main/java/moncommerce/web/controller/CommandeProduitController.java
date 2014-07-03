package moncommerce.web.controller;

import moncommerce.domain.model.CommandeProduit;
import moncommerce.repositroy.CommandeProduitFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "commandeProduitController")
@ViewScoped
public class CommandeProduitController extends AbstractController<CommandeProduit> implements Serializable {

    @EJB
    private CommandeProduitFacade ejbFacade;

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
