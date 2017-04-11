package py.gov.itaipu.siscor.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atlassian.plugin.spring.scanner.annotation.imports.ComponentImport;

// import py.gov.itaipu.siscor.api.MyPluginComponent;
import py.gov.itaipu.siscor.api.SiscorDocumentoService;
import py.gov.itaipu.siscor.entity.confluence.SiscorMemorando;
import py.gov.itaipu.siscor.entity.confluence.dto.SiscorMemorandoDTO;

public final class SiscorServlet extends HttpServlet
{
	private static final long serialVersionUID = 3915110675953041082L;
	
	@ComponentImport
    private final SiscorDocumentoService<SiscorMemorando> service;

    @Inject
    public SiscorServlet(SiscorDocumentoService<SiscorMemorando> service)
    {
        System.out.println("init SiscorServlet");
        this.service = service;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        SiscorMemorandoDTO siscorMemorandoDTO = new SiscorMemorandoDTO();
        service.add((SiscorMemorando) siscorMemorandoDTO);

        List<SiscorMemorando> lista = service.all();

        final PrintWriter w = res.getWriter();
        SiscorMemorando siscorMemorando = lista.stream().reduce((a, b) -> b).orElse(null);
        w.write("<h1>SISCOR-MINUTA QUANTITY:"+lista.size()+"</h1>");
        w.write("<h1>SISCOR-MINUTA LAST ID:"+siscorMemorando.getID()+"</h1>");
        w.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        //final String autor = req.getParameter("autor");
        //SiscorMinuta siscorMinuta = newArrayList(ao.find(SiscorMinuta.class, Query.select().order("ID DESC").limit(1))).get(0);
        //System.out.println("siscorMinuta " + siscorMinuta != null ? siscorMinuta.getMinutaCodigo() : "no encontrado");
        //res.sendRedirect(req.getContextPath() + "/plugins/servlet/siscor/wizard");
    }
}
