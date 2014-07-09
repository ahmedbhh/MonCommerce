package moncommerce.web.controller.gestionClient;

import moncommerce.domain.model.gestionClient.AccompteClient;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.gestionClient.AccompteClientService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "accompteClientController")
@ViewScoped
public class AccompteClientController extends AbstractController<AccompteClient> implements Serializable {

    @Autowired
    private AccompteClientService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public AccompteClientController() {
        super(AccompteClient.class);
    }
  


}
