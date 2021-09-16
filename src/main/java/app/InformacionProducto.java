package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Producto;

public class InformacionProducto {
	public static void main(String[] args) {
		//obtener la conexion con mi base de dato -->DAOFactori fabrica
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
				
				//creo los DAO usando la fabrica  
			EntityManager em = fabrica.createEntityManager();
			
			//-- proceso: obtener la informacion de un usuario
			Producto p = em.find(Producto.class,"poo332");//devulve un obj usuario segun la pk
			
			if (p==null) {
				System.out.println("codigo no existe");
			}else {
				System.out.println("Bienvenido:"+p.getIdprod());
				System.out.println(p);
			}
			
			
			em.close();
			

	}
}
