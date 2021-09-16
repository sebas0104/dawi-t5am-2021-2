package app;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Demo6 {

	public static void main(String[] args) {

//
		// obtener la conexion con mi base de dato -->DAOFactori fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");

		// creo los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();

		// -- proceso: listado de un usuarios
		System.out.println("Listado de usuarios");
		//String sql = "select * from tb_usuarios";//<----- JDBC
		String sql = "select u from Usuario u";//JPA
		

		List<Usuario> lstUsuarios = em.createQuery(sql, Usuario.class).getResultList();
		
		System.out.println("Cantidad de usuarios :" + lstUsuarios.size());
		
		for (Usuario u : lstUsuarios) {
			System.out.println(">>>>" + u);
		}
		
		System.out.println("Listado de usuarios x tipo");
		//String sql = "select * from tb_usuarios where idtipo =?";//<----- JDBC
		String sql2 = "select u from Usuario u where u.tipo = :xtipo";//JPA
		

		List<Usuario> lstUsuarios2 = em.createQuery(sql2, Usuario.class).setParameter("xtipo", 1).getResultList();
		
		System.out.println("Cantidad de usuarios :" + lstUsuarios2.size());
		
		for (Usuario u : lstUsuarios2) {
			System.out.println(">>>>" + u);
		}
		

		em.close();
	}

}
