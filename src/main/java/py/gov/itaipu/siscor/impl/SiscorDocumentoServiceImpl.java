package py.gov.itaipu.siscor.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import com.atlassian.activeobjects.external.ActiveObjects;
import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.google.gson.reflect.TypeToken;

import net.java.ao.Entity;
import net.java.ao.Query;
import py.gov.itaipu.siscor.api.SiscorDocumentoService;
import py.gov.itaipu.siscor.entity.confluence.SiscorDocumento;
import py.gov.itaipu.siscor.entity.confluence.SiscorMemorando;
import py.gov.itaipu.siscor.entity.confluence.dto.SiscorDocumentoDTO;

@ExportAsService({ SiscorDocumentoService.class })
@Named("siscorDocumentoService")
public final class SiscorDocumentoServiceImpl<T extends SiscorDocumento & Entity, G extends SiscorDocumentoDTO>
		implements SiscorDocumentoService<T, G> {
	private static final String INITIAL_CODE = "00000";
	
	private final TypeToken<T> typeToken = new TypeToken<T>() { };
	  private final Type type = typeToken.getType(); // or getRawType() to return Class<? super T>

	  public Type getType() {
	    return type;
	  }

	@ComponentImport
	private final ActiveObjects ao;

	@Inject
	public SiscorDocumentoServiceImpl(ActiveObjects ao) {
		this.ao = ao;
	}
	
	public T add(G documentoDTO) {
		System.out.println("INSIDE ADD " + new Date());
		System.out.println("Class " + getClass().getGenericSuperclass());
		System.out.println("Class " + getClass().getGenericSuperclass().getTypeName());
		System.out.println("Class " + getClass().getClasses().length);
		System.out.println("Class " + getClass().getTypeParameters()[0]);
		System.out.println("Class " + type);
		
		List<T> list = new ArrayList<T>();
        Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println("Class " + cls.getName());
		
		T documento = null;
		try {
			documentoDTO = initializeMinutaNewYear(documentoDTO);
			documento = (T) ao.create(SiscorMemorando.class);
			documento.setMinutaCodigo(documentoDTO.getMinutaCodigo());
			documento.setMinutaAno(documentoDTO.getMinutaAno());
			documento.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return documento;
	}

	public List<T> all() {
		List<T> lista = (List<T>) Arrays.asList(ao.find(SiscorMemorando.class));
		return lista;
	}

	public T last() {
		List<T> lista = (List<T>) Arrays.asList(ao.find(SiscorMemorando.class, Query.select().order("ID DESC").limit(1)));
		T documento = lista.isEmpty() ? null : lista.get(0);
		return documento;
	}

	private G initializeMinutaNewYear(G documento) {
		try {

			String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
			documento.setMinutaAno(currentYear);
			documento.setMinutaCodigo(INITIAL_CODE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return documento;
	}
}
