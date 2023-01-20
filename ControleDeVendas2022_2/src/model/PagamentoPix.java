package model;

public class PagamentoPix {
	private String codigo;
	
	public void visualizar_codigo() {
		
	}
	
	public PagamentoPix(String codigo) {
		this.setCodigo(codigo);
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
}
