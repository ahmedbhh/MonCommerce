package moncommerce.gestionClient.web.converter;

import moncommerce.gestionClient.domain.model.FactureClientProduit;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.gestionClient.service.FactureClientProduitService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class FactureClientProduitConverter implements Converter {

    @Autowired
    private FactureClientProduitService ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    moncommerce.gestionClient.domain.model.FactureClientProduitPK getKey(String value) {
        moncommerce.gestionClient.domain.model.FactureClientProduitPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new moncommerce.gestionClient.domain.model.FactureClientProduitPK();
        key.setIDProduit(Long.parseLong(values[0]));
        key.setIDFactureClient(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(moncommerce.gestionClient.domain.model.FactureClientProduitPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIDProduit());
        sb.append(SEPARATOR);
        sb.append(value.getIDFactureClient());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof FactureClientProduit) {
            FactureClientProduit o = (FactureClientProduit) object;
            return getStringKey(o.getFactureClientProduitPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FactureClientProduit.class.getName()});
            return null;
        }
    }

}
