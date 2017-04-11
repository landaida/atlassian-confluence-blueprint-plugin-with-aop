package py.gov.itaipu.siscor.entity.confluence;

public interface SiscorDocumento
{

  public String getMinutaCodigo();
  public void setMinutaCodigo(String minutaCodigo);

  public String getMinutaAno();
  public void setMinutaAno(String minutaAno);

  public String getTipoDocumento();
  public void setTipoDocumento(String tipoDocumento);

  public String getCiudad();
  public void setCiudad(String ciudad);

  public String getAsunto();
  public void setAsunto(String asunto);

  public String getConfluenceTitulo();
  public void setConfluenceTitulo(String confluenceTitulo);

  public String getDestinatarios();
  public void setDestinatarios(String destinatarios);

  public String getRemitentes();
  public void setRemitentes(String remitentes);

  public String getFecha();
  public void setFecha(String fecha);

}
