package ec.edu.ups.ppw63.ExamenFinal.business;

import java.util.List;

import ec.edu.ups.ppw63.ExamenFinal.dao.RecargaDAO;
import ec.edu.ups.ppw63.ExamenFinal.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionRecarga {
	
	@Inject
	private RecargaDAO daoRecarga;
	
	public void guardarRecarga(Recarga recarga) {
		Recarga cli = daoRecarga.read(recarga.getCodigo());
		if (cli != null){
			daoRecarga.insert(recarga); 
		}else {
			daoRecarga.update(recarga);
		}
	}
	
	public void actualizarRecarga(Recarga recarga) throws Exception {
		Recarga cli = daoRecarga.read(recarga.getCodigo());
		if (cli != null){
			daoRecarga.update(recarga);
		}else {
			throw new Exception("Recarga no existe");
		}
	}
	
	public List<Recarga> getRecargas(){
		return daoRecarga.getAll();
	}
}
