package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Producto;

public class ListadoProductos {

	public static void main(String[] args) {

		// obtener la conexion con mi base de dato -->DAOFactori fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// creo los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();

		// -- proceso: listado de un usuarios
		System.out.println("Listado de productos");
		//String sql = "select * from tb_usuarios";//<----- JDBC
		String sql = "select p from Producto p";//JPA
		

		List<Producto> lstProducto = em.createQuery(sql, Producto.class).getResultList();
		
		System.out.println("Cantidad de Producto :" + lstProducto.size());
		
		for (Producto p : lstProducto) {
			System.out.println(">>>>" + p);
		}
		
		/*System.out.println("Listado de usuarios x tipo");
		//String sql = "select * from tb_usuarios where idtipo =?";//<----- JDBC
		String sql2 = "select u from Usuario u where u.tipo = :xtipo";//JPA-*/
	}

}
