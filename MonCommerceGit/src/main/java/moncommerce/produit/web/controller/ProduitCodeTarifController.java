package moncommerce.produit.web.controller;

import moncommerce.produit.domain.model.ProduitCodeTarif;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.produit.service.ProduitCodeTarifService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "produitCodeTarifController")
@ViewScoped
public class ProduitCodeTarifController extends AbstractController<ProduitCodeTarif> implements Serializable {

    @Autowired
    private ProduitCodeTarifService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ProduitCodeTarifController() {
        super(ProduitCodeTarif.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getProduitCodeTarifPK().setIDProduit(this.getSelected().getProduit().getIDProduit());
        this.getSelected().getProduitCodeTarifPK().setIDCodetarif(this.getSelected().getCodeTarif().getIDCodetarif());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProduitCodeTarifPK(new moncommerce.produit.domain.model.ProduitCodeTarifPK());
    }

}
