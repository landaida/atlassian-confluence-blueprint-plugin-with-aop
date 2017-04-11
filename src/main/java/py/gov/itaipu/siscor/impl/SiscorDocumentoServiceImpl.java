package py.gov.itaipu.siscor.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

import py.gov.itaipu.siscor.api.SiscorDocumentoService;

@ExportAsService ({SiscorDocumentoService.class})
@Named ("siscorDocumentoService")
public final class SiscorDocumentoServiceImpl<T> implements SiscorDocumentoService<T>
{
    private static final String INITIAL_CODE = "00000";
    private final Class<T> genericType;

    @ComponentImport
    private final ActiveObjects ao;

    @Inject
    public SiscorDocumentoServiceImpl(ActiveObjects ao)
    {
        this.ao = ao;
    }

	public T add(T documento) {
		return null;
	}

	public List<T> all() {
		return null;
	}

	public T last() {
		return null;
	}

    
    private T initializeMinutaNewYear(){
    	final ParameterizedType type = (ParameterizedType) getClass().getGenericSuperclass();
    	Class<T> theType = (Class<T>) (type).getActualTypeArguments()[0];
    	Class clazz = Class.forName(theType.getName());    	
        String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        T siscorMinuta = (T) ao.create(clazz);
        
        ((Object) siscorMinuta).setMinutaAno(currentYear);
        ((Object) siscorMinuta).setMinutaCodigo(INITIAL_CODE);
        return siscorMinuta;
    }
}
