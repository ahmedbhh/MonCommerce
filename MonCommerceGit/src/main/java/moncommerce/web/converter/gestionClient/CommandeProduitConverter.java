package moncommerce.web.converter.gestionClient;

import moncommerce.domain.model.test.CommandeProduit;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.domain.model.test.CommandeProduitPK;
import moncommerce.service.gestionClient.CommandeProduitService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class CommandeProduitConverter implements Converter {

    @Autowired
    private CommandeProduitService ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    CommandeProduitPK getKey(String value) {
        CommandeProduitPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new CommandeProduitPK();
        key.setIdProduit(Long.parseLong(values[0]));
        key.setIDCommandefournisseur(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(CommandeProduitPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIdProduit());
        sb.append(SEPARATOR);
        sb.append(value.getIDCommandefournisseur());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof CommandeProduit) {
            CommandeProduit o = (CommandeProduit) object;
            return getStringKey(o.getCommandeProduitPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), CommandeProduit.class.getName()});
            return null;
        }
    }

}
