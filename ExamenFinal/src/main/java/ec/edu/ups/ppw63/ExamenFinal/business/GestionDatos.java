package ec.edu.ups.ppw63.ExamenFinal.business;

import ec.edu.ups.ppw63.ExamenFinal.dao.CuentaDAO;
import ec.edu.ups.ppw63.ExamenFinal.model.Cuenta;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private CuentaDAO daocuenta;
	
	@PostConstruct
	public void init() {
		System.out.println("iniciando");
		
		Cuenta cuenta = new Cuenta();
		
		cuenta.setCodigo(1);
		cuenta.setNumero("0998663179");
		cuenta.setSaldo(300);
		daocuenta.insert(cuenta);
		
		System.out.println(cuenta.toString());
		
		cuenta = new Cuenta();
		
		cuenta.setCodigo(2);
		cuenta.setNumero("0987654321");
		cuenta.setSaldo(0);
		daocuenta.insert(cuenta);
		
		System.out.println(cuenta.toString());
		
		cuenta = new Cuenta();
		
		cuenta.setCodigo(3);
		cuenta.setNumero("0984751351");
		cuenta.setSaldo(0);
		daocuenta.insert(cuenta);
		
		System.out.println(cuenta.toString());
	}
}
