package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Entity
@Table(name = "tb_usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	@Id
	@Column(name = "cod_usua")
	private int codigo;

	@Column(name = "nom_usua")
	private String nombre;

	@Column(name = "ape_usua")
	private String apellido;

	@Column(name = "usr_usua")
	private String usuario;

	@Column(name = "cla_usua")
	private String clave;

	@Column(name = "fna_usua")
	private String fnacim;

	@Column(name = "idtipo")
	private int tipo;

	@Column(name = "est_usua")
	private int estado;

	

}
