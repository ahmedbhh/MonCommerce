package moncommerce.web.controller.gestionFournisseur;

import moncommerce.domain.model.gestionFournisseur.ProduitFactureFournisseur;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionFournisseur.ProduitFactureFournisseurService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "produitFactureFournisseurController")
@ViewScoped
public class ProduitFactureFournisseurController extends AbstractController<ProduitFactureFournisseur> implements Serializable {

    @Autowired
    private ProduitFactureFournisseurService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ProduitFactureFournisseurController() {
        super(ProduitFactureFournisseur.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getProduitFactureFournisseurPK().setIdProduit(this.getSelected().getProduit().getIdProduit());
        this.getSelected().getProduitFactureFournisseurPK().setIDFactureFournisseur(this.getSelected().getFactureFournisseur().getIDFactureFournisseur());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setProduitFactureFournisseurPK(new moncommerce.domain.model.gestionFournisseur.ProduitFactureFournisseurPK());
    }

}
