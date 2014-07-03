package moncommerce.web.controller;

import moncommerce.domain.model.Entrprise;
import moncommerce.repositroy.EntrpriseFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "entrpriseController")
@ViewScoped
public class EntrpriseController extends AbstractController<Entrprise> implements Serializable {

    @EJB
    private EntrpriseFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public EntrpriseController() {
        super(Entrprise.class);
    }

}
