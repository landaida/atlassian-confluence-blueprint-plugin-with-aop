package py.gov.itaipu.siscor.api;

import com.atlassian.activeobjects.tx.Transactional;
import java.util.List;

import py.gov.itaipu.siscor.entity.confluence.SiscorMinuta;


@Transactional
public interface SiscorMinutaService
{
  SiscorMinuta add(String minutaCodigo, String minutaAno);

  List<SiscorMinuta> all();

  SiscorMinuta last();

  void holaMundoService();
}
