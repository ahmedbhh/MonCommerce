package moncommerce.fournisseur.web.converter;

import moncommerce.fournisseur.domain.model.FamilleFournisseur;
import moncommerce.web.controller.util.JsfUtil;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.fournisseur.service.FamilleFournisseurService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean
public class FamilleFournisseurConverter implements Converter {

    @Autowired
    private FamilleFournisseurService ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
            return null;
        }
        return this.ejbFacade.find(getKey(value));
    }

    java.lang.Long getKey(String value) {
        java.lang.Long key;
        key = Long.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Long value) {
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof FamilleFournisseur) {
            FamilleFournisseur o = (FamilleFournisseur) object;
            return getStringKey(o.getIDFamilleFournisseur());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), FamilleFournisseur.class.getName()});
            return null;
        }
    }

}
