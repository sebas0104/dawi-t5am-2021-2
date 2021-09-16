package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Producto;

public class RegistrarProducto {

	public static void main(String[] args) {
		
		//obtener la conexion con mi base de dato->segun unidad de persistecia -->DAOFactori fabrica=...
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
				//creo los DAO usando la fabrica  
				EntityManager em = fabrica.createEntityManager();
				
				//-- proceso registrar un nuevo producto
				Producto p  = new Producto();
				p.setIdprod("poo32");
				p.setDescripcion("prueba");
				p.setStock(20);
				p.setPrecio(2.30);
				p.setIdcategoria(6);
				p.setEstado(2);
				
				// para registra , actualizar , elimnar -> se maneja mediante trasacciones
				em.getTransaction().begin();
				em.persist(p);//para registrar
				em.getTransaction().commit();
				System.out.println("Producto ok");
				em.close();
				
				
	}

}
