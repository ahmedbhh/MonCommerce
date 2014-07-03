package moncommerce.web.controller;

import moncommerce.domain.model.CommandeClient;
import moncommerce.repositroy.CommandeClientFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "commandeClientController")
@ViewScoped
public class CommandeClientController extends AbstractController<CommandeClient> implements Serializable {

    @EJB
    private CommandeClientFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CommandeClientController() {
        super(CommandeClient.class);
    }

}
