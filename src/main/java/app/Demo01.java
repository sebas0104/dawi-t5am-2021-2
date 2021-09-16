package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		//obtener la conexion con mi base de dato->segun unidad de persistecia -->DAOFactori fabrica=...
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//creo los DAO usando la fabrica  
	EntityManager em = fabrica.createEntityManager();
	//-- proceso registrar un nuevo usario
	
	Usuario u = new Usuario();
	u.setCodigo(10);
	u.setNombre("Eren");
	u.setApellido("Ackerman");
	u.setUsuario("tatakae@gmail.com");
	u.setClave("12345");
	u.setFnacim("2021/08/24");
	u.setTipo(1);
	u.setEstado(1);
	
	// para registra , actualizar , elimnar -> se maneja mediante trasacciones
	em.getTransaction().begin();
	em.persist(u);//para registrar
	em.getTransaction().commit();
	System.out.println("Registro ok");
	em.close();
	
	
		
	}
	
}
