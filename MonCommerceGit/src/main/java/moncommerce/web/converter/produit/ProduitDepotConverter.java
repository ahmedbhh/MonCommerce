package moncommerce.web.converter.produit;

import moncommerce.domain.model.test.ProduitDepot;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.service.produit.ProduitDepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
public class ProduitDepotConverter implements Converter {

    @Autowired
    private ProduitDepotService ejbFacade;

    private static final String SEPARATOR = "#";
    private static final String SEPARATOR_ESCAPED = "\\#";

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    moncommerce.domain.model.test.ProduitDepotPK getKey(String value) {
        moncommerce.domain.model.test.ProduitDepotPK key;
        String values[] = value.split(SEPARATOR_ESCAPED);
        key = new moncommerce.domain.model.test.ProduitDepotPK();
        key.setIDdepot(Long.parseLong(values[0]));
        key.setIdProduit(Long.parseLong(values[1]));
        return key;
    }

    String getStringKey(moncommerce.domain.model.test.ProduitDepotPK value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value.getIDdepot());
        sb.append(SEPARATOR);
        sb.append(value.getIdProduit());
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
