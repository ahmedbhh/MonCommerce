package moncommerce.web.controller;

import moncommerce.domain.model.Commande;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "commandeController")
@ViewScoped
public class CommandeController extends AbstractController<Commande> implements Serializable {

    @Autowired
    CommandeService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CommandeController() {
        super(Commande.class);
    }

}
