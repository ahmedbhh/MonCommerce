package moncommerce.web.controller;

import moncommerce.domain.model.FactureFournisseurReglementFournisseurs;
import moncommerce.repositroy.FactureFournisseurReglementFournisseursFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "factureFournisseurReglementFournisseursController")
@ViewScoped
public class FactureFournisseurReglementFournisseursController extends AbstractController<FactureFournisseurReglementFournisseurs> implements Serializable {

    @EJB
    private FactureFournisseurReglementFournisseursFacade ejbFacade;

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
        this.getSelected().setFactureFournisseurReglementFournisseursPK(new moncommerce.domain.model.FactureFournisseurReglementFournisseursPK());
    }

}
