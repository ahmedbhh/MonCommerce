package moncommerce.produit.web.controller;

import moncommerce.produit.domain.model.Uniteemesure;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.produit.service.UniteemesureService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "uniteemesureController")
@ViewScoped
public class UniteemesureController extends AbstractController<Uniteemesure> implements Serializable {

    @Autowired
    private UniteemesureService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public UniteemesureController() {
        super(Uniteemesure.class);
    }

}
