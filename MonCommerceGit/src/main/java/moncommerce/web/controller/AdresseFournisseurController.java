package moncommerce.web.controller;

import moncommerce.domain.model.AdresseFournisseur;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.AdresseFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@ManagedBean(name = "adresseFournisseurController")
@ViewScoped
public class AdresseFournisseurController extends AbstractController<AdresseFournisseur> implements Serializable {

    @Autowired
    private AdresseFournisseurService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public AdresseFournisseurController() {
        super(AdresseFournisseur.class);
    }

}
