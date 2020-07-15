package com.barbgend.jsf;

import com.barbgend.entities.TblResumenproducto;
import com.barbgend.jsf.util.JsfUtil;
import com.barbgend.jsf.util.PaginationHelper;
import com.barbgend.sessions.TblResumenproductoFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("tblResumenproductoController")
@SessionScoped
public class TblResumenproductoController implements Serializable {

    private TblResumenproducto current;
    private DataModel items = null;
    @EJB
    private com.barbgend.sessions.TblResumenproductoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public TblResumenproductoController() {
    }

    public TblResumenproducto getSelected() {
        if (current == null) {
            current = new TblResumenproducto();
            current.setTblResumenproductoPK(new com.barbgend.entities.TblResumenproductoPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private TblResumenproductoFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (TblResumenproducto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new TblResumenproducto();
        current.setTblResumenproductoPK(new com.barbgend.entities.TblResumenproductoPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getTblResumenproductoPK().setRespIdProductoFk(current.getTblProducto().getProIdProducto());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resoruces/Bundle").getString("TblResumenproductoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resoruces/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (TblResumenproducto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getTblResumenproductoPK().setRespIdProductoFk(current.getTblProducto().getProIdProducto());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resoruces/Bundle").getString("TblResumenproductoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resoruces/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (TblResumenproducto) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resoruces/Bundle").getString("TblResumenproductoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resoruces/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public TblResumenproducto getTblResumenproducto(com.barbgend.entities.TblResumenproductoPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = TblResumenproducto.class)
    public static class TblResumenproductoControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TblResumenproductoController controller = (TblResumenproductoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblResumenproductoController");
            return controller.getTblResumenproducto(getKey(value));
        }

        com.barbgend.entities.TblResumenproductoPK getKey(String value) {
            com.barbgend.entities.TblResumenproductoPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.barbgend.entities.TblResumenproductoPK();
            key.setRespIdResumen(Integer.parseInt(values[0]));
            key.setRespIdProductoFk(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.barbgend.entities.TblResumenproductoPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getRespIdResumen());
            sb.append(SEPARATOR);
            sb.append(value.getRespIdProductoFk());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TblResumenproducto) {
                TblResumenproducto o = (TblResumenproducto) object;
                return getStringKey(o.getTblResumenproductoPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TblResumenproducto.class.getName());
            }
        }

    }

}
