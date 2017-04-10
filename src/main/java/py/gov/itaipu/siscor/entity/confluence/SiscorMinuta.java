package py.gov.itaipu.siscor.entity.confluence;

import net.java.ao.Entity;
import net.java.ao.Preload;

@Preload
public interface SiscorMinuta extends Entity
{

  public String getMinutaCodigo();
  public void setMinutaCodigo(String minutaCodigo);

  public String getMinutaAno();
  public void setMinutaAno(String minutaAno);

}
