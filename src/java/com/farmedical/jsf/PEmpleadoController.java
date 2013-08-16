package com.farmedical.jsf;

import com.farmedical.entity.PEmpleado;
import com.farmedical.jsf.util.JsfUtil;
import com.farmedical.jsf.util.PaginationHelper;
import com.farmedical.beans.PEmpleadoFacade;
import com.farmedical.beans.PersonaFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.event.PhaseId;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@ManagedBean(name = "pEmpleadoController")
@SessionScoped
public class PEmpleadoController implements Serializable {

    private PEmpleado current;
    private DataModel items = null;
    private static final int BUFFER_SIZE = 6124;
    static private String folderToUpload = "";
    private StreamedContent file;
    @EJB
    private com.farmedical.beans.PEmpleadoFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public PEmpleadoController() {
    }

    public PEmpleado getSelected() {
        if (current == null) {
            current = new PEmpleado();
            selectedItemIndex = -1;
        }
        return current;
    }

    private PEmpleadoFacade getFacade() {
        return ejbFacade;
    }
        
    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(25) {
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
        current = (PEmpleado) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
//        return "newjsf";
        return "View";
    }

    public String prepareCreate() {
        current = new PEmpleado();
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PEmpleadoCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (PEmpleado) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PEmpleadoUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (PEmpleado) getItems().getRowData();
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
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("PEmpleadoDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
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

    @FacesConverter(forClass = PEmpleado.class)
    public static class PEmpleadoControllerConverter implements Converter {

        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            PEmpleadoController controller = (PEmpleadoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "pEmpleadoController");
            return controller.ejbFacade.find(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuffer sb = new StringBuffer();
            sb.append(value);
            return sb.toString();
        }

        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof PEmpleado) {
                PEmpleado o = (PEmpleado) object;
                return getStringKey(o.getIdEmpleado());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + PEmpleado.class.getName());
            }
        }
    }

    //subir url
    public void handleFileUpload(FileUploadEvent event) {

        ExternalContext extContext = FacesContext.getCurrentInstance().getExternalContext();

        File result = new File(extContext.getRealPath("//files//" + event.getFile().getFileName()));
//        System.out.println(extContext.getRealPath("//files//" + event.getFile().getFileName()));
        folderToUpload = (("/files/" + event.getFile().getFileName()) + "");
        // current.setRutaFuncion("C:");

        getSelected().setDocumentoUrl(folderToUpload);
        //prueba de datos subida
        if (!PhaseId.INVOKE_APPLICATION.equals(event.getPhaseId())) {
            event.setPhaseId(PhaseId.INVOKE_APPLICATION);
            event.queue();
        } else {
            //do stuff here, #{ngoPhotoBean.description} is set
        }


//fin prueba par descargar
        InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(folderToUpload);
        file = new DefaultStreamedContent(stream, "image/pdf", "Datos.pdf");
        //fin pruebas para la desgarga


        try {
            FileOutputStream fileOutputStream = new FileOutputStream(result);

            byte[] buffer = new byte[BUFFER_SIZE];

            int bulk;
            InputStream inputStream = event.getFile().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }

            fileOutputStream.close();
            inputStream.close();

            FacesMessage msg = new FacesMessage("Descripción del Archivo", "Nombre del archivo: " + event.getFile().getFileName() + 
                    "\ntamaño: " + event.getFile().getSize() / 1024 + " Kb\ntipo: " + event.getFile().getContentType() + 
                    "\n \n El archivo se ha almacenado correctamente."
                    + "\n ruta del archivo" + folderToUpload);

            FacesContext.getCurrentInstance().addMessage(null, msg);


        } catch (IOException e) {
            e.printStackTrace();

            FacesMessage error = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El archivo no se ha almacenado!", "");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }
    }

    public String getFolderToUpload() {
        return folderToUpload;
    }

    /**
     * @param folderToUpload the folderToUpload to set
     */
    public void setFolderToUpload(String folderToUpload) {
        this.folderToUpload = folderToUpload;
    }

    //Descargar archivo
    public void FileDownloadController() {
        InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream("/files/tigo.png");
        file = new DefaultStreamedContent(stream, "image/pdf", "downloaded_optimus.pdf");

    }

    public StreamedContent getFile() {
        return file;
    }
    //fin datos para upload FIle

    //prueba url
    public String url() {
        return getSelected().getDocumentoUrl();
    }

    public StreamedContent getFileArchivo() {
        InputStream stream = ((ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext()).getResourceAsStream(url());
        file = new DefaultStreamedContent(stream, "aplication/pdf", "downloaded_pdf.pdf");
        return file;
    }
}