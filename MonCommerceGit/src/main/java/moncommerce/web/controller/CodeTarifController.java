package moncommerce.web.controller;

import moncommerce.domain.model.CodeTarif;
import moncommerce.repositroy.CodeTarifFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "codeTarifController")
@ViewScoped
public class CodeTarifController extends AbstractController<CodeTarif> implements Serializable {

    @EJB
    private CodeTarifFacade ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public CodeTarifController() {
        super(CodeTarif.class);
    }

}
