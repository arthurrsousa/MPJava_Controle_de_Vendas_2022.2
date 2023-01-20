package model;

public class PagamentoBoleto {
private String codigo;
	
	public void visualizar_codigo() {
		
	}
	
	public PagamentoBoleto(String codigo) {
		this.setCodigo(codigo);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
