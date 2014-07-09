package moncommerce.web.controller.gestionFournisseur;

import moncommerce.domain.model.gestionFournisseur.FactureFournisseurReglementFournisseurs;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionFournisseur.FactureFournisseurReglementFournisseursService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "factureFournisseurReglementFournisseursController")
@ViewScoped
public class FactureFournisseurReglementFournisseursController extends AbstractController<FactureFournisseurReglementFournisseurs> implements Serializable {

    @Autowired
    private FactureFournisseurReglementFournisseursService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FactureFournisseurReglementFournisseursController() {
        super(FactureFournisseurReglementFournisseurs.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getFactureFournisseurReglementFournisseursPK().setIDReglementfournisseurs(this.getSelected().getReglementFournisseurs().getIDReglementfournisseurs());
        this.getSelected().getFactureFournisseurReglementFournisseursPK().setIDFactureFournisseur(this.getSelected().getFactureFournisseur().getIDFactureFournisseur());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setFactureFournisseurReglementFournisseursPK(new moncommerce.domain.model.gestionFournisseur.FactureFournisseurReglementFournisseursPK());
    }

}
