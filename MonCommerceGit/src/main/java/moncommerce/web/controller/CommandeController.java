package moncommerce.web.controller;

import moncommerce.domain.model.Commande;
import moncommerce.repositroy.CommandeFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "commandeController")
@ViewScoped
public class CommandeController extends AbstractController<Commande> implements Serializable {

    @EJB
    private CommandeFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CommandeController() {
        super(Commande.class);
    }

}
