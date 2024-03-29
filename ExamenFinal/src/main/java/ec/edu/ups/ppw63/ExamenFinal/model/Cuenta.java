package ec.edu.ups.ppw63.ExamenFinal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cuenta {
	
	@Id
	private int codigo;
	private String numero;
	private double saldo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "Cuenta [codigo=" + codigo + ", numero=" + numero + ", saldo=" + saldo + "]";
	}
	
	
}
