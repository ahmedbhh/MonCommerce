package moncommerce.web.converter;

import moncommerce.domain.model.CommandeProduit;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.service.CommandeProduitService;
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

    moncommerce.domain.model.CommandeProduitPK getKey(String value) {
        moncommerce.domain.model.CommandeProduitPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new moncommerce.domain.model.CommandeProduitPK();
        key.setIDProduit(Long.parseLong(values[0]));
        key.setIDCommandefournisseur(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(moncommerce.domain.model.CommandeProduitPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIDProduit());
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
