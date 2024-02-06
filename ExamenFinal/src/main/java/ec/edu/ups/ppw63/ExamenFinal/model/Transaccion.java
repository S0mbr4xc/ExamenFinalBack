package ec.edu.ups.ppw63.ExamenFinal.model;

public class Transaccion {

	private int cOrigen;
	private int cDestino;
	private float monto;
	public Transaccion(int cOrigen, int cDestino, float monto) {
		super();
		this.cOrigen = cOrigen;
		this.cDestino = cDestino;
		this.monto = monto;
	}
	public int getcOrigen() {
		return cOrigen;
	}
	public void setcOrigen(int cOrigen) {
		this.cOrigen = cOrigen;
	}
	public int getcDestino() {
		return cDestino;
	}
	public void setcDestino(int cDestino) {
		this.cDestino = cDestino;
	}
	public float getMonto() {
		return monto;
	}
	public void setMonto(float monto) {
		this.monto = monto;
	}
	
}
