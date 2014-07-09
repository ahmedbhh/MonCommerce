package moncommerce.web.controller.produit;

import moncommerce.domain.model.produit.ProduitDepot;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.produit.ProduitDepotService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "produitDepotController")
@ViewScoped
public class ProduitDepotController extends AbstractController<ProduitDepot> implements Serializable {

    @Autowired
    private ProduitDepotService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ProduitDepotController() {
        super(ProduitDepot.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getProduitDepotPK().setIDdepot(this.getSelected().getDepot().getIDdepot());
        this.getSelected().getProduitDepotPK().setIdProduit(this.getSelected().getProduit().getIdProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProduitDepotPK(new moncommerce.domain.model.produit.ProduitDepotPK());
    }

}
