package py.gov.itaipu.siscor.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import java.lang.System;
import java.util.List;

// import py.gov.itaipu.siscor.api.MyPluginComponent;
import py.gov.itaipu.siscor.api.SiscorMinutaService;
import py.gov.itaipu.siscor.entity.confluence.SiscorMinuta;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

public final class SiscorServlet extends HttpServlet
{
    // @ComponentImport
    // private final MyPluginComponent service;
    @ComponentImport
    private final SiscorMinutaService service;

    @Inject
    public SiscorServlet(SiscorMinutaService service)
    {
        System.out.println("init SiscorServlet");
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        service.holaMundoService();
        service.add("03", "089");
        service.add("04", "090");
        service.add("05", "091");
        List<SiscorMinuta> lista = service.all();
        SiscorMinuta siscorMinuta = service.last();
        if(siscorMinuta != null){
          System.out.println(siscorMinuta.getMinutaCodigo());
        }
        final PrintWriter w = res.getWriter();
        siscorMinuta = lista.stream().reduce((a, b) -> b).orElse(null);
        w.write("<h1>SISCOR-MINUTA QUANTITY:"+lista.size()+"</h1>");
        w.write("<h1>SISCOR-MINUTA LAST ID:"+siscorMinuta.getID()+"</h1>");
        w.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        //final String autor = req.getParameter("autor");
        //SiscorMinuta siscorMinuta = newArrayList(ao.find(SiscorMinuta.class, Query.select().order("ID DESC").limit(1))).get(0);
        //System.out.println("siscorMinuta " + siscorMinuta != null ? siscorMinuta.getMinutaCodigo() : "no encontrado");
        // siscorMinutaService.holaMundoService();
        //res.sendRedirect(req.getContextPath() + "/plugins/servlet/siscor/wizard");
    }
}
