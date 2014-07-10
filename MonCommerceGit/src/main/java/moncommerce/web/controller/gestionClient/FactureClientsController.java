package moncommerce.web.controller.gestionClient;

import moncommerce.domain.model.test.FactureClients;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionClient.FactureClientsService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "factureClientsController")
@ViewScoped
public class FactureClientsController extends AbstractController<FactureClients> implements Serializable {

    
    @Autowired
    private FactureClientsService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FactureClientsController() {
        super(FactureClients.class);
    }

}
