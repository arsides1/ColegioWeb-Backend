package colegio.com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column(length = 100, nullable = false)
	private String nombres;

	@Column(length = 100, nullable = false)
	private String apellidos;

	@ManyToOne
	//fk
	@JoinColumn(name = "idRol",referencedColumnName = "idRol")
	private Rol  idRol;



	@Column(length = 50, nullable = false)
	private String usuario;

	@Column(length = 50, nullable = false)
	private String password;

	@Column(length = 100)
	private String email;

	@Column(columnDefinition = "TINYINT(1)")
	private boolean Estado;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate fechaRegistro;
	
}
