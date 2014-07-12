package moncommerce.web.controller.client;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.domain.model.test.Client;
import moncommerce.service.client.ClientService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@ManagedBean(name = "clientController")
@ViewScoped
public class ClientController extends AbstractController<Client> implements Serializable {

    @Autowired
    private ClientService ejbFacade;


    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ClientController() {
        super(Client.class);
    }

}
