package moncommerce.web.controller;

import moncommerce.domain.model.ProduitProduit;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.ProduitProduitService;
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
        this.getSelected().getProduitProduitPK().setIDProduitComposee(this.getSelected().getProduit1().getIDProduit());
        this.getSelected().getProduitProduitPK().setIDProduitComposant(this.getSelected().getProduit().getIDProduit());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProduitProduitPK(new moncommerce.domain.model.ProduitProduitPK());
    }

}
