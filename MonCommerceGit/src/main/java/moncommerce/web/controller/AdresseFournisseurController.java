package moncommerce.web.controller;

import moncommerce.domain.model.AdresseFournisseur;
import moncommerce.repositroy.AdresseFournisseurFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "adresseFournisseurController")
@ViewScoped
public class AdresseFournisseurController extends AbstractController<AdresseFournisseur> implements Serializable {

    @EJB
    private AdresseFournisseurFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public AdresseFournisseurController() {
        super(AdresseFournisseur.class);
    }

}
