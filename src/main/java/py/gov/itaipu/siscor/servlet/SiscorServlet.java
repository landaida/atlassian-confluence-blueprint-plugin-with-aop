package py.gov.itaipu.siscor.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import java.lang.System;

import py.gov.itaipu.siscor.api.MyPluginComponent;
import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

public final class SiscorServlet extends HttpServlet
{
    @ComponentImport
    private final MyPluginComponent service;

    @Inject
    public SiscorServlet(MyPluginComponent service)
    {
        System.out.println("init SiscorServlet");
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        final PrintWriter w = res.getWriter();
        w.write("<h1>SISCOR SISCOR SISCOR</h1>");
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
