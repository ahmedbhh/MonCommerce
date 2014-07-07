package moncommerce.gestionClient.web.controller;

import moncommerce.gestionClient.domain.model.FactureClientProduit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.gestionClient.service.FactureClientProduitService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "factureClientProduitController")
@ViewScoped
public class FactureClientProduitController extends AbstractController<FactureClientProduit> implements Serializable {

    @Autowired
    private FactureClientProduitService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FactureClientProduitController() {
        super(FactureClientProduit.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getFactureClientProduitPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
        this.getSelected().getFactureClientProduitPK().setIDFactureClient(this.getSelected().getFactureClients().getIDFactureClients());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setFactureClientProduitPK(new moncommerce.gestionClient.domain.model.FactureClientProduitPK());
    }

}
