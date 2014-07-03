package moncommerce.web.controller;

import moncommerce.domain.model.FamilleFournisseur;
import moncommerce.repositroy.FamilleFournisseurFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "familleFournisseurController")
@ViewScoped
public class FamilleFournisseurController extends AbstractController<FamilleFournisseur> implements Serializable {

    @EJB
    private FamilleFournisseurFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FamilleFournisseurController() {
        super(FamilleFournisseur.class);
    }

}
