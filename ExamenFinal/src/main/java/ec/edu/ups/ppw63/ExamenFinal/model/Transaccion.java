package ec.edu.ups.ppw63.ExamenFinal.model;

public class Transaccion {

	private String cOrigen;
	private String cDestino;
	private double monto;
	public Transaccion(String cOrigen, String cDestino, float monto) {
		super();
		this.cOrigen = cOrigen;
		this.cDestino = cDestino;
		this.monto = monto;
	}
	public String getcOrigen() {
		return cOrigen;
	}
	public void setcOrigen(String cOrigen) {
		this.cOrigen = cOrigen;
	}
	public String getcDestino() {
		return cDestino;
	}
	public void setcDestino(String cDestino) {
		this.cDestino = cDestino;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
}
