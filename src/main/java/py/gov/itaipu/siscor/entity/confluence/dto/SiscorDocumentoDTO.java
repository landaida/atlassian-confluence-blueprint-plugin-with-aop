package py.gov.itaipu.siscor.entity.confluence.dto;

public class SiscorDocumentoDTO {
	private String minutaCodigo;
	private String minutaAno;
	private String tipoDocumento;
	private String ciudad;
	private String asunto;
	private String confluenceTitulo;
	private String destinatarios;
	private String remitentes;
	private String fecha;
	
	public String getMinutaCodigo() {
		return minutaCodigo;
	}

	public void setMinutaCodigo(String minutaCodigo) {
		this.minutaCodigo = minutaCodigo;
	}

	public String getMinutaAno() {
		return minutaAno;
	}

	public void setMinutaAno(String minutaAno) {
		this.minutaAno = minutaAno;
	}
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getConfluenceTitulo() {
		return confluenceTitulo;
	}

	public void setConfluenceTitulo(String confluenceTitulo) {
		this.confluenceTitulo = confluenceTitulo;
	}

	public String getDestinatarios() {
		return destinatarios;
	}

	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}

	public String getRemitentes() {
		return remitentes;
	}

	public void setRemitentes(String remitentes) {
		this.remitentes = remitentes;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
