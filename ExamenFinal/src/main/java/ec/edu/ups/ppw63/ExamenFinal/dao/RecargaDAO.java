package ec.edu.ups.ppw63.ExamenFinal.dao;

import java.util.List;

import ec.edu.ups.ppw63.ExamenFinal.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Recarga cliente) {
		em.persist(cliente);
	}
	
	public void update(Recarga cliente) {
		em.merge(cliente);
	}
	
	public void remove(int codigo) {
		Recarga cliente = em.find(Recarga.class, codigo);
		em.remove(cliente);
	}
	
	public Recarga read(int codigo) {
		Recarga cliente = em.find(Recarga.class, codigo);
		return cliente;
	}
	
	public List<Recarga> getAll(){
		String jpql = "SELECT c FROM Recarga c";
		Query q = em.createQuery(jpql, Recarga.class);
		return q.getResultList();
	}
	
}
