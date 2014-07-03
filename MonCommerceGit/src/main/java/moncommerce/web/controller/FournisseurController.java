package moncommerce.web.controller;

import moncommerce.domain.model.Fournisseur;
import moncommerce.repositroy.FournisseurFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "fournisseurController")
@ViewScoped
public class FournisseurController extends AbstractController<Fournisseur> implements Serializable {

    @EJB
    private FournisseurFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FournisseurController() {
        super(Fournisseur.class);
    }

}
