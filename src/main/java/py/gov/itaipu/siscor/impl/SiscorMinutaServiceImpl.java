package py.gov.itaipu.siscor.impl;

import com.atlassian.activeobjects.external.ActiveObjects;
import net.java.ao.Query;

import java.util.Arrays;
import java.util.List;
import java.lang.System;
import java.lang.Exception;

import com.atlassian.plugin.spring.scanner.annotation.export.ExportAsService;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;
import com.atlassian.sal.api.ApplicationProperties;

import javax.inject.Inject;
import javax.inject.Named;

import py.gov.itaipu.siscor.api.SiscorMinutaService;
import py.gov.itaipu.siscor.entity.confluence.SiscorMinuta;

@ExportAsService ({SiscorMinutaService.class})
@Named ("siscorMinutaService")
public final class SiscorMinutaServiceImpl implements SiscorMinutaService
{
    @ComponentImport
    private final ActiveObjects ao;

    @Inject
    public SiscorMinutaServiceImpl(ActiveObjects ao)
    {
        this.ao = ao;
    }

    @Override
    public SiscorMinuta add(String minutaCodigo, String minutaAno)
    {
      System.out.println("inside add " + minutaCodigo + " " + minutaAno);
      SiscorMinuta entity = null;
      try{
        entity = ao.create(SiscorMinuta.class);
        entity.setMinutaCodigo(minutaCodigo);
        entity.setMinutaAno(minutaAno);
        entity.save();
      }catch(Exception e){
        e.printStackTrace();
      }
        return entity;
    }

    @Override
    public List<SiscorMinuta> all()
    {
      List<SiscorMinuta> lista =  Arrays.asList(ao.find(SiscorMinuta.class));
      if(!lista.isEmpty()){
        System.out.println("all length " + lista.size());
      }
      return lista;
    }

    @Override
    public SiscorMinuta last()
    {
      SiscorMinuta[] lista = ao.find(SiscorMinuta.class, Query.select().order("ID DESC").limit(1));
      return lista[0];
    }
    @Override
    public void holaMundoService(){
        System.out.println("HOLA MUNDO FROM SERVICE");
    }
}
