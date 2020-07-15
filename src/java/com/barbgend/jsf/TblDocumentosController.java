package com.barbgend.jsf;

import com.barbgend.entities.TblDocumentos;
import com.barbgend.jsf.util.JsfUtil;
import com.barbgend.jsf.util.PaginationHelper;
import com.barbgend.sessions.TblDocumentosFacade;

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

@Named("tblDocumentosController")
@SessionScoped
public class TblDocumentosController implements Serializable {

    private TblDocumentos current;
    private DataModel items = null;
    @EJB
    private com.barbgend.sessions.TblDocumentosFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public TblDocumentosController() {
    }

    public TblDocumentos getSelected() {
        if (current == null) {
            current = new TblDocumentos();
            current.setTblDocumentosPK(new com.barbgend.entities.TblDocumentosPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private TblDocumentosFacade getFacade() {
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
        current = (TblDocumentos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new TblDocumentos();
        current.setTblDocumentosPK(new com.barbgend.entities.TblDocumentosPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getTblDocumentosPK().setDocIdUsuarioFk(current.getTblUsuario().getUsuIdUsuario());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resoruces/Bundle").getString("TblDocumentosCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resoruces/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (TblDocumentos) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getTblDocumentosPK().setDocIdUsuarioFk(current.getTblUsuario().getUsuIdUsuario());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resoruces/Bundle").getString("TblDocumentosUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resoruces/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (TblDocumentos) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resoruces/Bundle").getString("TblDocumentosDeleted"));
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

    public TblDocumentos getTblDocumentos(com.barbgend.entities.TblDocumentosPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = TblDocumentos.class)
    public static class TblDocumentosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TblDocumentosController controller = (TblDocumentosController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "tblDocumentosController");
            return controller.getTblDocumentos(getKey(value));
        }

        com.barbgend.entities.TblDocumentosPK getKey(String value) {
            com.barbgend.entities.TblDocumentosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.barbgend.entities.TblDocumentosPK();
            key.setDocIdDocumento(Integer.parseInt(values[0]));
            key.setDocIdUsuarioFk(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.barbgend.entities.TblDocumentosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getDocIdDocumento());
            sb.append(SEPARATOR);
            sb.append(value.getDocIdUsuarioFk());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof TblDocumentos) {
                TblDocumentos o = (TblDocumentos) object;
                return getStringKey(o.getTblDocumentosPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + TblDocumentos.class.getName());
            }
        }

    }

}
