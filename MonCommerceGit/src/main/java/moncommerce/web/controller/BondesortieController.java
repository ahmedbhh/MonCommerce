package moncommerce.web.controller;

import moncommerce.domain.model.Bondesortie;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.BondesortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@ManagedBean(name = "bondesortieController")
@ViewScoped
public class BondesortieController extends AbstractController<Bondesortie> implements Serializable {
    
    @Autowired
    private BondesortieService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public BondesortieController() {
        super(Bondesortie.class);
    }

}
