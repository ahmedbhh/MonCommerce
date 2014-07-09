package moncommerce.web.controller.produit;

import moncommerce.domain.model.produit.ProduitProduit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.produit.ProduitProduitService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "produitProduitController")
@ViewScoped
public class ProduitProduitController extends AbstractController<ProduitProduit> implements Serializable {

    @Autowired
    private ProduitProduitService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ProduitProduitController() {
        super(ProduitProduit.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getProduitProduitPK().setIDProduitComposee(this.getSelected().getProduit1().getIdProduit());
        this.getSelected().getProduitProduitPK().setIDProduitComposant(this.getSelected().getProduit().getIdProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProduitProduitPK(new moncommerce.domain.model.produit.ProduitProduitPK());
    }

}
