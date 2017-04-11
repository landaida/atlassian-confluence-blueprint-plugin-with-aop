package py.gov.itaipu.siscor.api;

import com.atlassian.activeobjects.tx.Transactional;
import java.util.List;

import py.gov.itaipu.siscor.entity.confluence.SiscorMinuta;


@Transactional
public interface SiscorMinutaService
{
  SiscorMinuta addMinuta(String minutaCodigo, String minutaAno);

  List<SiscorMinuta> allMinuta();

  SiscorMinuta lastMinuta();

  String nextValMinuta();
}
