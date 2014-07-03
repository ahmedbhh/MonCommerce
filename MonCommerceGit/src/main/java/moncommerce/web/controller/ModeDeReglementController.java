package moncommerce.web.controller;

import moncommerce.domain.model.ModeDeReglement;
import moncommerce.repositroy.ModeDeReglementFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "modeDeReglementController")
@ViewScoped
public class ModeDeReglementController extends AbstractController<ModeDeReglement> implements Serializable {

    @EJB
    private ModeDeReglementFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ModeDeReglementController() {
        super(ModeDeReglement.class);
    }

}
