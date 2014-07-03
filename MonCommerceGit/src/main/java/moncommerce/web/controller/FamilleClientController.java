package moncommerce.web.controller;

import moncommerce.domain.model.FamilleClient;
import moncommerce.repositroy.FamilleClientFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "familleClientController")
@ViewScoped
public class FamilleClientController extends AbstractController<FamilleClient> implements Serializable {

    @EJB
    private FamilleClientFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FamilleClientController() {
        super(FamilleClient.class);
    }

}
