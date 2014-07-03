package moncommerce.web.converter;

import moncommerce.domain.model.ProduitDepot;
import moncommerce.repositroy.ProduitDepotFacade;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean
public class ProduitDepotConverter implements Converter {

    @EJB
    private ProduitDepotFacade ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    moncommerce.domain.model.ProduitDepotPK getKey(String value) {
        moncommerce.domain.model.ProduitDepotPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new moncommerce.domain.model.ProduitDepotPK();
        key.setIDdepot(Long.parseLong(values[0]));
        key.setIDProduit(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(moncommerce.domain.model.ProduitDepotPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIDdepot());
        sb.append(SEPARATOR);
        sb.append(value.getIDProduit());
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof ProduitDepot) {
            ProduitDepot o = (ProduitDepot) object;
            return getStringKey(o.getProduitDepotPK());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), ProduitDepot.class.getName()});
            return null;
        }
    }

}
