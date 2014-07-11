package moncommerce.web.converter.produit;

import moncommerce.domain.model.test.Famille;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import moncommerce.service.produit.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
public class FamilleConverter implements Converter {

    @Autowired
    private FamilleService ejbFacade;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
        System.out.println("getAsObject" + value);
        /*if (value == null || value.length() == 0 || JsfUtil.isDummySelectItem(component, value)) {
         return null;
         }*/

        try {

            //System.out.println(this.ejbFacade.find(new Long(value)));
            return this.ejbFacade.find(new Long(1));
        } catch (Exception e) {
            System.out.println("expection getAsObject: " + e);
            return null;
        }

    }

    java.lang.Long getKey(String value) {
        java.lang.Long key;
        key = Long.valueOf(value);
        return key;
    }

    String getStringKey(java.lang.Long value) {
        System.out.println("getStringKey");
        StringBuffer sb = new StringBuffer();
        sb.append(value);
        return sb.toString();
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        System.out.println("getAsString");
        if (object == null
                || (object instanceof String && ((String) object).length() == 0)) {
            return null;
        }
        if (object instanceof Famille) {
            Famille o = (Famille) object;
            return getStringKey(o.getIDFamille());
        } else {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Famille.class.getName()});
            return null;
        }
    }

}
