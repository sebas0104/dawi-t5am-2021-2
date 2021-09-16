package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.Usuario;

public class Demo8 {

	public static void main(String[] args) {
		//obtener la conexion con mi base de dato -->DAOFactori fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//creo los DAO usando la fabrica  
	EntityManager em = fabrica.createEntityManager();
	
	//-- proceso: validar  un usuario segun su usuario y clave--> procedimiento almacenados
	
	String sql2 = "select u from Usuario u where u.usuario = :xusr and u.clave = :xcla";//JPA
	

	TypedQuery<Usuario> query = em.createQuery(sql2, Usuario.class);
			query.setParameter("xusr", "U002@gmail.com");
			query.setParameter("xcla", "10002");
			
	
	
	Usuario u =null;
	try {
		u = query.getSingleResult();
	} catch (Exception e) {
		
	}
	
	if (u==null) {
		System.out.println("codigo no existe");
	}else {
		System.out.println("Bienvenido:"+u.getNombre());
		System.out.println(u);
	}
	
	
	em.close();
	

	}

}
