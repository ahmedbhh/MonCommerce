package moncommerce.web.controller;

import moncommerce.domain.model.ModeDeReglement;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.ModeDeReglementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "modeDeReglementController")
@ViewScoped
public class ModeDeReglementController extends AbstractController<ModeDeReglement> implements Serializable {

    @Autowired
    private ModeDeReglementService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ModeDeReglementController() {
        super(ModeDeReglement.class);
    }

}
