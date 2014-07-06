package moncommerce.web.controller;

import moncommerce.domain.model.TitreContact;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.service.TitreContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "titreContactController")
@ViewScoped
public class TitreContactController extends AbstractController<TitreContact> implements Serializable {

    @Autowired
    private TitreContactService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public TitreContactController() {
        super(TitreContact.class);
    }

}
