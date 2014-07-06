package moncommerce.web.controller;

import moncommerce.domain.model.ReglementClient;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.ReglementClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "reglementClientController")
@ViewScoped
public class ReglementClientController extends AbstractController<ReglementClient> implements Serializable {

    @Autowired
    private ReglementClientService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ReglementClientController() {
        super(ReglementClient.class);
    }

}
