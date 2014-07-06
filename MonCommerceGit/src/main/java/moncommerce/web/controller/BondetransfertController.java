package moncommerce.web.controller;

import moncommerce.domain.model.Bondetransfert;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.BondetransfertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@ManagedBean(name = "bondetransfertController")
@ViewScoped
public class BondetransfertController extends AbstractController<Bondetransfert> implements Serializable {

    @Autowired
    private BondetransfertService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public BondetransfertController() {
        super(Bondetransfert.class);
    }

}
