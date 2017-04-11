package py.gov.itaipu.siscor.impl;

import com.atlassian.activeobjects.external.ActiveObjects;
import net.java.ao.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Calendar;
import java.lang.System;
import java.lang.Exception;
import java.lang.Integer;

import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.ApplicationProperties;

import javax.inject.Inject;
import javax.inject.Named;

import py.gov.itaipu.siscor.api.SiscorMinutaService;
import py.gov.itaipu.siscor.entity.confluence.SiscorMinuta;
import py.gov.itaipu.siscor.entity.confluence.dto.SiscorMinutaDTO;

@ExportAsService ({SiscorMinutaService.class})
@Named ("siscorMinutaService")
public final class SiscorMinutaServiceImpl implements SiscorMinutaService
{
    private static final String INITIAL_CODE = "00000";
    @ComponentImport
    private final ActiveObjects ao;

    @Inject
    public SiscorMinutaServiceImpl(ActiveObjects ao)
    {
        this.ao = ao;
    }

    @Override
    public SiscorMinuta addMinuta(SiscorMinutaDTO siscorMinutaDTO)
    {
        siscorMinutaDTO = nextValMinuta();
        SiscorMinuta siscorMinuta = ao.create(SiscorMinuta.class);
      try{
        siscorMinuta.setMinutaCodigo(siscorMinutaDTO.getMinutaCodigo());
        siscorMinuta.setMinutaAno(siscorMinutaDTO.getMinutaAno());
        siscorMinuta.save();
      }catch(Exception e){
        e.printStackTrace();
      }
        return siscorMinuta;
    }

    @Override
    public List<SiscorMinuta> allMinuta()
    {
      List<SiscorMinuta> lista =  Arrays.asList(ao.find(SiscorMinuta.class));
      return lista;
    }

    @Override
    public SiscorMinuta lastMinuta()
    {
      List<SiscorMinuta> lista =  Arrays.asList(ao.find(SiscorMinuta.class, Query.select().order("ID DESC").limit(1)));
      SiscorMinuta siscorMinuta = lista.isEmpty() ? null : lista.get(0);
      if(Objects.nonNull(siscorMinuta)){
          System.out.println("lastMinuta " + toString(siscorMinuta));
      }
      return siscorMinuta;
    }

    private SiscorMinutaDTO nextValMinuta(){
        String nextValMinuta = "";
        SiscorMinuta lastMinuta = lastMinuta();
        boolean existsLastMinuta = Objects.nonNull(lastMinuta);
        String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));

        if(existsLastMinuta){
            boolean currentYearEqualsToLastMinutaYear = currentYear.equals(lastMinuta.getMinutaAno());
            if(!currentYearEqualsToLastMinutaYear){
              lastMinuta = initializeMinutaNewYear();
            }
        }else{
            lastMinuta = initializeMinutaNewYear();
        }

        Integer lastMinutaCodigo = Integer.parseInt(lastMinuta.getMinutaCodigo());
        String newMinutaCodigo = String.format("%05d", lastMinutaCodigo+1);

        nextValMinuta = newMinutaCodigo + currentYear;

        SiscorMinutaDTO siscorMinutaDTO = new SiscorMinutaDTO();
        siscorMinutaDTO.setMinutaCodigo(newMinutaCodigo);
        siscorMinutaDTO.setMinutaAno(currentYear);

        System.out.println("nextVal: " + nextValMinuta);

        return siscorMinutaDTO;
    }

    private SiscorMinuta initializeMinutaNewYear(){
        String currentYear = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        SiscorMinuta siscorMinuta = ao.create(SiscorMinuta.class);;
        siscorMinuta.setMinutaAno(currentYear);
        siscorMinuta.setMinutaCodigo(INITIAL_CODE);
        return siscorMinuta;
    }

    private String toString(SiscorMinuta siscorMinuta){
        return "ID: " + siscorMinuta.getID()
        + " codigo:" + siscorMinuta.getMinutaCodigo()
        + " ano: " + siscorMinuta.getMinutaAno();
    }
}
