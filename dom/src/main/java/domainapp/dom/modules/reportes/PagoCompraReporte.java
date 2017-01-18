package domainapp.dom.modules.reportes;

import java.math.BigDecimal;

public class PagoCompraReporte {

	private String nroRecibo;
	public String getNroRecibo() {return nroRecibo;}
	public void setNroRecibo(String nroRecibo) {this.nroRecibo = nroRecibo;}
	
	private String fechaDePago;
	public String getFechaDePago() {return fechaDePago;}
	public void setFechaDePago(String fechaDePago) {this.fechaDePago = fechaDePago;}

	private BigDecimal valor;
	public BigDecimal getValor() {return valor;}
	public void setValor(BigDecimal valor) {this.valor = valor;}
	
	private String nombreCajero;
	public String getNombreCajero() {return nombreCajero;}
	public void setNombreCajero(String nombreCajero) {this.nombreCajero = nombreCajero;}
	
	private String formaDePago;
	public String getFormaDePago() {return formaDePago;}
	public void setFormaDePago(String formaDePago) {this.formaDePago = formaDePago;}
}
