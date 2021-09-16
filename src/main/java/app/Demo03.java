package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo03 {

	public static void main(String[] args) {
		//obtener la conexion con mi base de dato -->DAOFactori fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//creo los DAO usando la fabrica  
	EntityManager em = fabrica.createEntityManager();
	
	
	//-- proceso : eliminar un usuario
	Usuario u = new Usuario();
	u.setCodigo(20);
	// para registra , actualizar , elimnar -> trasacciones
	em.getTransaction().begin();
	em.remove(u);//para eliminar (borrar de la tabla)/cabiar un estado
	em.getTransaction().commit();
	System.out.println("Eliminar ok");
	em.close();
	

	}

}
