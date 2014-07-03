package moncommerce.web.controller;

import moncommerce.domain.model.LigneCommandeClient;
import moncommerce.repositroy.LigneCommandeClientFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "ligneCommandeClientController")
@ViewScoped
public class LigneCommandeClientController extends AbstractController<LigneCommandeClient> implements Serializable {

    @EJB
    private LigneCommandeClientFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public LigneCommandeClientController() {
        super(LigneCommandeClient.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getLigneCommandeClientPK().setIDCommandeClient(this.getSelected().getCommandeClient().getIDCommandeClient());
        this.getSelected().getLigneCommandeClientPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setLigneCommandeClientPK(new moncommerce.domain.model.LigneCommandeClientPK());
    }

}
