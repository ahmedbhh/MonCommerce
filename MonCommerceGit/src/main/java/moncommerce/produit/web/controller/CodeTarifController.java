package moncommerce.produit.web.controller;

import moncommerce.produit.domain.model.CodeTarif;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import moncommerce.produit.service.CodeTarifService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
@ManagedBean(name = "codeTarifController")
@ViewScoped
public class CodeTarifController extends AbstractController<CodeTarif> implements Serializable {

    @Autowired
    private CodeTarifService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CodeTarifController() {
        super(CodeTarif.class);
    }

}
