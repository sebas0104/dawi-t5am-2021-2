package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo5 {

	public static void main(String[] args) {
		//combinar el 4 pero agregando el ejrcicio 3
		
		//obtener la conexion con mi base de dato -->DAOFactori fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//creo los DAO usando la fabrica  
	EntityManager em = fabrica.createEntityManager();
	
	//-- proceso: obtener la informacion de un usuario
	Usuario u = em.find(Usuario.class, 10);//devulve un obj usuario segun la pk
	
	if (u==null) {
		System.out.println("codigo no existe");
	}else {
		System.out.println("Eliminado el Usuario!!");
		em.getTransaction().begin();
		em.remove(u);//para eliminar (borrar de la tabla)/cabiar un estado
		em.getTransaction().commit();
		System.out.println("Eliminar ok");
	}
	
	
	em.close();
	

	}

}
