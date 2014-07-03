package moncommerce.web.controller;

import moncommerce.domain.model.ReglementClient;
import moncommerce.repositroy.ReglementClientFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "reglementClientController")
@ViewScoped
public class ReglementClientController extends AbstractController<ReglementClient> implements Serializable {

    @EJB
    private ReglementClientFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ReglementClientController() {
        super(ReglementClient.class);
    }

}
