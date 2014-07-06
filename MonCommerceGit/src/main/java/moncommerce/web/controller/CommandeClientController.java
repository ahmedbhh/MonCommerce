package moncommerce.web.controller;

import moncommerce.domain.model.CommandeClient;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.CommandeClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "commandeClientController")
@ViewScoped
public class CommandeClientController extends AbstractController<CommandeClient> implements Serializable {

    @Autowired
    private CommandeClientService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CommandeClientController() {
        super(CommandeClient.class);
    }

}
