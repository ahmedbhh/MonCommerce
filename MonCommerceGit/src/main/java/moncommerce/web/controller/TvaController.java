package moncommerce.web.controller;

import moncommerce.domain.model.Tva;
import moncommerce.repositroy.TvaFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "tvaController")
@ViewScoped
public class TvaController extends AbstractController<Tva> implements Serializable {

    @EJB
    private TvaFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public TvaController() {
        super(Tva.class);
    }

}
