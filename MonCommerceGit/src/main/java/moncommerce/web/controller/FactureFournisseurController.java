package moncommerce.web.controller;

import moncommerce.domain.model.FactureFournisseur;
import moncommerce.repositroy.FactureFournisseurFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "factureFournisseurController")
@ViewScoped
public class FactureFournisseurController extends AbstractController<FactureFournisseur> implements Serializable {

    @EJB
    private FactureFournisseurFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FactureFournisseurController() {
        super(FactureFournisseur.class);
    }

}
