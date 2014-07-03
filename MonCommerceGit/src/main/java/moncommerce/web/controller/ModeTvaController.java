package moncommerce.web.controller;

import moncommerce.domain.model.ModeTva;
import moncommerce.repositroy.ModeTvaFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "modeTvaController")
@ViewScoped
public class ModeTvaController extends AbstractController<ModeTva> implements Serializable {

    @EJB
    private ModeTvaFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ModeTvaController() {
        super(ModeTva.class);
    }

}
