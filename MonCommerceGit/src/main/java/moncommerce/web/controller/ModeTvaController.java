package moncommerce.web.controller;

import moncommerce.domain.model.ModeTva;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.ModeTvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "modeTvaController")
@ViewScoped
public class ModeTvaController extends AbstractController<ModeTva> implements Serializable {

    @Autowired
    private ModeTvaService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public ModeTvaController() {
        super(ModeTva.class);
    }

}
