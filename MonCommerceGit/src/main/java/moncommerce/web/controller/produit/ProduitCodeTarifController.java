package moncommerce.web.controller.produit;

import moncommerce.domain.model.produit.ProduitCodeTarif;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.produit.ProduitCodeTarifService;
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
        this.getSelected().getProduitCodeTarifPK().setIdProduit(this.getSelected().getProduit().getIdProduit());
        this.getSelected().getProduitCodeTarifPK().setIDCodetarif(this.getSelected().getCodeTarif().getIDCodetarif());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProduitCodeTarifPK(new moncommerce.domain.model.produit.ProduitCodeTarifPK());
    }

}
