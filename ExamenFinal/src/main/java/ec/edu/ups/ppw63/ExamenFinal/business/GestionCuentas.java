package ec.edu.ups.ppw63.ExamenFinal.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.ExamenFinal.dao.CuentaDAO;
import ec.edu.ups.ppw63.ExamenFinal.dao.RecargaDAO;
import ec.edu.ups.ppw63.ExamenFinal.model.Cuenta;
import ec.edu.ups.ppw63.ExamenFinal.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCuentas {
	
	@Inject
	private CuentaDAO daoCuenta;
	
	@Inject
	private RecargaDAO daoRecarga;
	
	public Cuenta getCuentaPorNumero(String numero) throws Exception{
		
		if(numero.length()!=10) {
			throw new Exception("Numero incorrecto");
		}
		return daoCuenta.getCuentaPorNumero(numero);
	}
	
	public List<Cuenta> getCuentas(){
		return daoCuenta.getAll();
	}
	
	public Cuenta transferencia(String numero, double monto) {
		Cuenta cuenta = daoCuenta.getCuentaPorNumero(numero);
		System.out.println("El saldo del cliente "+cuenta.getSaldo()+ " antes de la transferencia es: "+cuenta.getSaldo());
		cuenta.setSaldo(cuenta.getSaldo() + monto);
		System.out.println("El saldo del cliente "+cuenta.getSaldo()+ " despues de la transferencia es: "+cuenta.getSaldo());
		Cuenta administrador = daoCuenta.getCuentaPorNumero("0998663179");
		daoCuenta.update(cuenta);
		administrador.setSaldo(cuenta.getSaldo() - monto);
		daoCuenta.update(administrador);
		Recarga recarga = new Recarga();
		recarga.setFecha(new Date());
		recarga.setMonto(monto);
		recarga.setNumero(numero);
		daoRecarga.insert(recarga);
		
		return cuenta;
	}
}
