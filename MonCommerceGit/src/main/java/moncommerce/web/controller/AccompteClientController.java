package moncommerce.web.controller;

import moncommerce.domain.model.AccompteClient;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.AccompteClientService;
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
