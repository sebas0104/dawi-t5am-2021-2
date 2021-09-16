package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		//obtener la conexion con mi base de dato -->DAOFactori fabrica
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
				//creo los DAO usando la fabrica  
			EntityManager em = fabrica.createEntityManager();
			
			//-- proceso: obtener la informacion de un usuario
			Usuario u = em.find(Usuario.class, 20);//devulve un obj usuario segun la pk
			
			if (u==null) {
				System.out.println("codigo no existe");
			}else {
				System.out.println("Bienvenido:"+u.getNombre());
				System.out.println(u);
			}
			
			
			em.close();
			

	}

}
