package moncommerce.web.controller;

import moncommerce.domain.model.AdresseFacturation;
import moncommerce.repositroy.AdresseFacturationFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "adresseFacturationController")
@ViewScoped
public class AdresseFacturationController extends AbstractController<AdresseFacturation> implements Serializable {

    @EJB
    private AdresseFacturationFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public AdresseFacturationController() {
        super(AdresseFacturation.class);
    }

}
