package ec.edu.ups.ppw63.ExamenFinal.dao;

import java.util.List;

import ec.edu.ups.ppw63.ExamenFinal.model.Cuenta;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class CuentaDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cuenta cliente) {
		em.persist(cliente);
	}
	
	public void update(Cuenta cliente) {
		em.merge(cliente);
	}
	
	public void remove(int codigo) {
		Cuenta cliente = em.find(Cuenta.class, codigo);
		em.remove(cliente);
	}
	
	public Cuenta read(int codigo) {
		Cuenta cliente = em.find(Cuenta.class, codigo);
		return cliente;
	}
	
	public List<Cuenta> getAll(){
		String jpql = "SELECT c FROM Cliente c";
		Query q = em.createQuery(jpql, Cuenta.class);
		return q.getResultList();
	}
	
	public Cuenta getCuentaPorNumero(String num){
		String jpql = "SELECT c FROM Cuenta c WHERE c.numero = :num";
		Query q = em.createQuery(jpql, Cuenta.class);
		q.setParameter("numero", num);
		List<Cuenta> clientes = q.getResultList();
		if(clientes.size()>0)
			return clientes.get(0);
		return null;
	}
}
