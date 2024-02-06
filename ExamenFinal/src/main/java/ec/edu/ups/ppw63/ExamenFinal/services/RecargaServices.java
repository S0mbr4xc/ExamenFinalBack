package ec.edu.ups.ppw63.ExamenFinal.services;

import java.util.List;

import ec.edu.ups.ppw63.ExamenFinal.business.GestionRecarga;
import ec.edu.ups.ppw63.ExamenFinal.model.Recarga;
import ec.edu.ups.ppw63.demo63.model.Cliente;
import ec.edu.ups.ppw63.demo63.services.ErrorMessage;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recarga")
public class RecargaServices {
	
	@Inject
	private GestionRecarga gRecargas;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getClientes(){
		List<Recarga> recargas = gRecargas.getRecargas();
		if(clientes.size()>0)
			return Response.ok(recargas).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran recargas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
}
