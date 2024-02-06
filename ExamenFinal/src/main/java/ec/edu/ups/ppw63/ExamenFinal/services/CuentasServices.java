package ec.edu.ups.ppw63.ExamenFinal.services;

import java.util.List;

import ec.edu.ups.ppw63.ExamenFinal.business.GestionCuentas;
import ec.edu.ups.ppw63.ExamenFinal.model.Cuenta;
import ec.edu.ups.ppw63.ExamenFinal.model.Transaccion;
import jakarta.ws.rs.Produces;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("cuentas")
public class CuentasServices {

	@Inject
	private GestionCuentas gCuentas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Transaccion trans) {
		try {
			gCuentas.transferencia(trans.getcDestino(), trans.getMonto());
			return Response.ok(trans).build();
		} catch (Exception e) {
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getAll() {
		List<Cuenta> cuentas = gCuentas.getCuentas();
		if(cuentas.size()>0) {
			return Response.ok(cuentas).build();
		}
		ErrorMessage error = new ErrorMessage(6, "No se registran cuentas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
	}
}
