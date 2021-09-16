package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		//obtener la conexion con mi base de dato -->DAOFactori fabrica
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
				//creo los DAO usando la fabrica  
			EntityManager em = fabrica.createEntityManager();
			//-- proceso : actualizar un  usario
			
			Usuario u = new Usuario();
			u.setCodigo(20);
			u.setNombre("Eren");
			u.setApellido("Jeager");
			u.setUsuario("eren24@gmail.com");
			u.setClave("paloma");
			u.setFnacim("2021/08/24");
			u.setTipo(1);
			u.setEstado(1);
			
	// para registra , actualizar , elimnar -> trasacciones
			em.getTransaction().begin();
			em.merge(u);//para actualisar -> si exixte el codigo/ pero si no existe ->lo  registra
			em.getTransaction().commit();
			System.out.println("Actualizacion ok");
			em.close();
			

	}

}
