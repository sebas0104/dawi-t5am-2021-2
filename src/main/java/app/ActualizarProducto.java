package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Producto;

public class ActualizarProducto {
	public static void main(String[] args) {
		// obtener la conexion con mi base de dato -->DAOFactori fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// creo los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
//-- proceso : actualizar un  producto
		Producto p = new Producto();
		p.setIdprod("poo34");
		p.setDescripcion("hello word");
		p.setStock(20);
		p.setPrecio(2.30);
		p.setIdcategoria(6);
		p.setEstado(2);

//para registra , actualizar , elimnar -> trasacciones
		em.getTransaction().begin();
		em.merge(p);// para actualisar -> si exixte el codigo/ pero si no existe ->lo registra
		em.getTransaction().commit();
		System.out.println("Actualizacion ok");
		em.close();
	}
}
