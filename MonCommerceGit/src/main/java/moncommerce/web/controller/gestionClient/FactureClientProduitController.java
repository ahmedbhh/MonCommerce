package moncommerce.web.controller.gestionClient;

import moncommerce.domain.model.test.FactureClientProduit;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import moncommerce.service.gestionClient.FactureClientProduitService;
import moncommerce.web.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@ManagedBean(name = "factureClientProduitController")
@ViewScoped
public class FactureClientProduitController extends AbstractController<FactureClientProduit> implements Serializable {

    @Autowired
    private FactureClientProduitService ejbFacade;

    @PostConstruct
    @Override
    public void init() {
        super.setFacade(ejbFacade);
    }

    public FactureClientProduitController() {
        super(FactureClientProduit.class);
    }

    @Override
    protected void setEmbeddableKeys() {
        this.getSelected().getFactureClientProduitPK().setIdProduit(this.getSelected().getProduit().getIdProduit());
        this.getSelected().getFactureClientProduitPK().setIDFactureClients(this.getSelected().getFactureClients().getIDFactureClients());
    }

    @Override
    protected void initializeEmbeddableKey() {
        this.getSelected().setFactureClientProduitPK(new moncommerce.domain.model.test.FactureClientProduitPK());
    }
/*
    @Override
    protected void persist(PersistAction persistAction, String successMessage) {

        System.out.println("persist : " + getSelected());
        if (getSelected() != null) {
            this.setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    System.out.println("edit");
                    this.ejbFacade.edit(getSelected());
                } else {
                    System.out.println("remove eeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                    System.out.println(getSelected().getFactureClientProduitPK());
                    this.ejbFacade.remove(getSelected().getFactureClientProduitPK());
                    System.out.println("remove complite ");
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (Exception ex) {
                String msg = "";
                Throwable cause = JsfUtil.getRootCause(ex.getCause());
                if (cause != null) {
                    if (cause instanceof ConstraintViolationException) {
                        ConstraintViolationException excp = (ConstraintViolationException) cause;
                        for (ConstraintViolation s : excp.getConstraintViolations()) {
                            JsfUtil.addErrorMessage(s.getMessage());
                        }
                    } else {
                        msg = cause.getLocalizedMessage();
                        if (msg.length() > 0) {
                            JsfUtil.addErrorMessage(msg);
                        } else {
                            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                        }
                    }
                }
            }
        }
    }
*/
}
